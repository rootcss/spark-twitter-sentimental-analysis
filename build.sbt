name := "spark_twitter_sentimental_analysis"
version := "1.0"
scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"
libraryDependencies += "org.apache.spark" %% "spark-sql"  % "1.6.0"
libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.6.0"
libraryDependencies += "com.stratio.receiver" % "spark-rabbitmq_1.6" % "0.3.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-twitter_2.11
libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.11" % "1.6.0"
libraryDependencies += "com.google.code.gson" % "gson" % "2.7"
libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.4"
libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "4.0.4"

libraryDependencies += "com.typesafe" % "config" % "1.2.1"
resolvers += "Akka Repository" at "http://repo.akka.io/releases/"
