package co.nawa.ayovote.util

import co.nawa.ayovote.model.PersonModel.{Person, PersonDao}
import com.github.jeroenr.bson.element.BsonObjectId
import twitter4j.{StallWarning, Status, StatusDeletionNotice, StatusListener}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import akka.util.Timeout


class SimplePrintStatusListener extends StatusListener{

  implicit val duration: Timeout = 20 seconds

  override def onStatus(status: Status) {

    val user = status.getUser

    val person = new Person(BsonObjectId.generate, user.getId, user.getScreenName,user.getName, "unknown", "unknown", "TWITTER")

    PersonDao.insert(person)
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
