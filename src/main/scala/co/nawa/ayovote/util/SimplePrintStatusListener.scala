package co.nawa.ayovote.util

import twitter4j.{StallWarning, Status, StatusDeletionNotice, StatusListener}

class SimplePrintStatusListener extends StatusListener{

  override def onStatus(status: Status) {
    println(status.getText)
  }

  override def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}

  override def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}

  override def onException(ex: Exception) {
    ex.printStackTrace()
  }

  override def onScrubGeo(arg0: Long, arg1: Long) {}

  override def onStallWarning(warning: StallWarning) {}
}
