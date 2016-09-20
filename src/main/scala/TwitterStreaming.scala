package com.rootcss.spark

import org.apache.spark.streaming.{Seconds, StreamingContext}
import StreamingContext._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import com.rootcss.spark._

class TwitterStreaming {

  def execute() {
    val filters                                 = List("UriAttack", "bigdata", "bitcoin")
    val sparkAppName: String                    = "Spark Twitter Sentimental Analysis"
    val sparkMaster: String                     = "local[*]"
    val fetchTimeInterval: Int                  = 10

    val ssc = new StreamingContext(sparkMaster,
                                   sparkAppName,
                                   Seconds(fetchTimeInterval))

    val stream = TwitterUtils.createStream(ssc,
                                           new TwitterOAuth().getAuthorization(),
                                           filters)

    val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))

    val topCounts10 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(10))
                     .map{case (topic, count) => (count, topic)}
                     .transform(_.sortByKey(false))


    topCounts10.foreachRDD(rdd => {
      val topList = rdd.take(5)
      println("\nPopular topics in last 10 seconds (%s total):".format(rdd.count()))
      topList.foreach{case (count, tag) => println("%s (%s tweets)".format(tag, count))}
    })

    ssc.start()
    ssc.awaitTermination()
  }

}