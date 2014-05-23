lazy val javaSdk = project.in(file("."))

name := "java-sdk"

version := "0.1.1"

publishMavenStyle := true

publishTo := Some(Resolver.file("shared-repo", Path.userHome / ".m2" / "repository" asFile))

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11",
  "org.scalatest" % "scalatest_2.10" % "2.1.5",
  "com.typesafe" % "config" % "1.0.2",
  "com.github.scopt" %% "scopt" % "3.2.0",
  "org.apache.httpcomponents" % "httpclient" % "4.3.1",
  "org.json" % "json" % "20131018",
  "net.minidev" % "json-smart" % "1.2",
  "org.mockito" % "mockito-all" % "1.9.5",
  "com.google.guava" % "guava" % "16.0.1"
)
