import sbt._
import Keys._
import com.github.retronym.SbtOneJar

object Build extends Build {
	
  lazy val defaultSettings =
    Defaults.defaultSettings ++
      Seq(
        name := "isaacloud-java-sdk",
        version := "1.0"
        )


  lazy val root = Project("root",
    file("."),
    settings = defaultSettings ++ SbtOneJar.oneJarSettings ++ Seq(
      resolvers ++= Seq(
        "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
        "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/"),
      libraryDependencies ++= Seq(
        "org.apache.httpcomponents" % "httpclient" % "4.3.1",
        "net.minidev" % "json-smart" % "1.1.1"
        )))

}