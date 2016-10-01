package co.nawa.ayovote.util

object Twitter4jConfig {

  val oAuthConsumerKeyEnvName = "TWITTER_CONSUMER_KEY"
  val oAuthConsumerSecretEnvName = "TWITTER_CONSUMER_SECRET"
  val oAuthAccessTokenEnvName = "TWITTER_CONSUMER_TOKEN"
  val oAuthAccessTokenSecretEnvName = "TWITTER_CONSUMER_TOKEN_SECRET"

  val oAuthConsumerKey = Option(System.getenv(oAuthConsumerKeyEnvName))
    .getOrElse(throw new Exception("The " + oAuthConsumerKeyEnvName +" environment variable is not set."))
  val oAuthConsumerSecret = Option(System.getenv(oAuthConsumerSecretEnvName))
    .getOrElse(throw new Exception("The " + oAuthConsumerSecretEnvName +" environment variable is not set."))
  val oAuthAccessToken = Option(System.getenv(oAuthAccessTokenEnvName))
    .getOrElse(throw new Exception("The " + oAuthAccessTokenEnvName +" environment variable is not set."))
  val oAuthAccessTokenSecret = Option(System.getenv(oAuthAccessTokenSecretEnvName))
    .getOrElse(throw new Exception("The " + oAuthAccessTokenSecretEnvName +" environment variable is not set."))

  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey(oAuthConsumerKey)
    .setOAuthConsumerSecret(oAuthConsumerSecret)
    .setOAuthAccessToken(oAuthAccessToken)
    .setOAuthAccessTokenSecret(oAuthAccessTokenSecret)
    .build

}
