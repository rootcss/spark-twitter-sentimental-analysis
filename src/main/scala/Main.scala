package com.rootcss.spark

import com.rootcss.spark._
import simpl_spark_cassandra._
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.spark.SparkConf

import org.apache.spark.Logging
import org.apache.log4j.{Level, Logger}

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

object Main {

  def main(args: Array[String]) {
    configureLogLevels()
    val twistream = new TwitterStreaming()
    twistream.execute()
  }

  def configureLogLevels() {
    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("akka").setLevel(Level.ERROR)
  }

}