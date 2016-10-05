name := "pullertweet"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.twitter4j" % "twitter4j-stream" % "4.0.5",
  "com.github.jeroenr" %% "pide" % "0.7"
)
    