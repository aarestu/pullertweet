package co.nawa.ayovote.model

import co.nawa.ayovote.util.MongoDbConfig
import com.github.jeroenr.bson.BsonDocument
import com.github.jeroenr.bson.Implicits.ObjectId
import com.github.jeroenr.pide.{Dao, Entity, ObjectIdPide}
import com.github.jeroenr.tepkin.MongoCollection
import com.github.jeroenr.bson.BsonDsl._

object PersonModel {

  case class Person(id: ObjectId,
                    userid: Long,
                    name: String,
                    username: String,
                    generation: String,
                    gender: String,
                    sosfrom: String) extends Entity[ObjectId]

  object PersonDao extends Dao[ObjectId, Person] {
    override val collection: MongoCollection = MongoDbConfig.db("person")
  }

  implicit object PersonPide extends ObjectIdPide[Person] {
    override def read(document: BsonDocument): Person = {
      Person(
        id = document.get[ObjectId]("_id").get,
        userid = document.getAs[Long]("userid").get,
        name = document.getAs[String]("name").get,
        username = document.getAs[String]("username").get,
        generation = document.getAs[String]("generation").get,
        gender = document.getAs[String]("gender").get,
        sosfrom = document.getAs[String]("sosfrom").get
      )
    }

    override def write(person: Person): BsonDocument = {
      ("_id" := person.id) ~
        ("userid" := person.userid) ~
        ("name" := person.name) ~
        ("username" := person.username) ~
        ("generation" := person.generation) ~
        ("gender" := person.gender) ~
        ("sosfrom" := person.sosfrom)
    }
  }

}

