package co.nawa.ayovote

import co.nawa.ayovote.util.{SimplePrintStatusListener, Twitter4jConfig}
import twitter4j.{FilterQuery, TwitterStreamFactory}

object PullerTweet {

  def main(args: Array[String]) {

    val twitterStream = new TwitterStreamFactory(Twitter4jConfig.config).getInstance

    twitterStream.addListener(new SimplePrintStatusListener)

    if (args.length > 0) {
      val filterQuery = new FilterQuery()
      filterQuery.track(args.apply(0))

      twitterStream.filter(filterQuery)
    } else {
      throw new Exception("The filter query is not set.")
    }
  }
}
