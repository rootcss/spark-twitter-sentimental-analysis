package com.rootcss.spark

import twitter4j._
import twitter4j.conf._
import twitter4j.conf.ConfigurationBuilder
import com.typesafe.config.ConfigFactory

class TwitterOAuth {

  val conf = ConfigFactory.load("application.conf").getConfig("twitter_oauth")
  val configurations = new twitter4j.conf.ConfigurationBuilder()
                      .setOAuthConsumerKey(conf.getString("consumer_key"))
                      .setOAuthConsumerSecret(conf.getString("consumer_secret"))
                      .setOAuthAccessToken(conf.getString("access_token"))
                      .setOAuthAccessTokenSecret(conf.getString("access_token_secret"))
                      .build

  def getAuthorization() : Option[twitter4j.auth.Authorization] = {
    val twitter_auth = new TwitterFactory(configurations)
    val a = new twitter4j.auth.OAuthAuthorization(configurations)
    val atwitter : Option[twitter4j.auth.Authorization] =  Some(twitter_auth.getInstance(a).getAuthorization())
    return atwitter
  }
}