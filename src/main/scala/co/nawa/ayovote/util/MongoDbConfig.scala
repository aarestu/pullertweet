package co.nawa.ayovote.util

import com.github.jeroenr.tepkin.MongoClient

object MongoDbConfig {

  val client = MongoClient("mongodb://localhost:27017")
  val db = client("voteyuk")
}
