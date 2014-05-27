lazy val javaSdk = project.in(file("."))

name := "java-sdk"

version := "0.1.3"

publishMavenStyle := true

publishTo := Some(Resolver.file("shared-repo", Path.userHome / ".m2" / "repository" asFile))

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.apache.httpcomponents" % "httpclient" % "4.3.1",
  "net.minidev" % "json-smart" % "1.2",
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "com.google.guava" % "guava" % "16.0.1"
)

assemblySettings