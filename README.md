# IsaaCloud SDK for Java

The Isaacloud Java SDK can be used to access the Isaacloud API through java. The user can make any number of request calls to the API.

## Requirements

The library works on **Java version of 1.7** and **sbt 0.13.0.**

## Basics

This SDK can be used to connect to Isaacloud v1 REST API on api.isaacloud.com.
Main classes in "isaacloud" package are Cache, Admin and Queue, which represent corresponding entities in the REST API.
The "isaacloud" package also contains special class Isaacloud, which could in future contain more sophisticated methods for interacting with the REST API.

## How to build

1. Clone repository:

    ```
    git clone https://github.com/isaacloud/java-sdk.git
    ```

2. Enter directory:

    ```
    cd java-sdk
    ```

3. Run installation of dependencies:

    ```
    sbt compile
    ```

    You can publish it to your local maven repository by using:

    ```
    sbt publish
    ```

    or you can add as a dependency with build.scala. For example:

```scala
object Build extends Build {
    lazy val sdk = RootProject(uri("https://github.com/isaacloud/java-sdk.git#%s".format("0.0.2-RC2")))
    lazy val defaultSettings =
        Defaults.defaultSettings ++
            Seq(
                name := "play_example",
                version := "1.0",
                scalaVersion := "2.10.1",
                scalacOptions := Seq(
                    "-feature",
                    "-language:implicitConversions",
                    "-language:postfixOps",
                    "-unchecked",
                    "-deprecation",
                    "-encoding", "utf8",
                    "-Ywarn-adapted-args"))

    lazy val root = Project("root",
        file("."),
        settings = defaultSettings ++ Seq(
        resolvers ++= Seq(
            "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
            "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/"),
        libraryDependencies ++= Seq(
            "net.minidev" % "json-smart" % "1.1.1"
        )))
        .dependsOn(sdk)
}
```

## Making request calls

Example of using the sdk:

```java
List<String> fields = new ArrayList<>();
fields.add("email");
fields.add("firstName");

Map<String, String> order = new HashMap<>();
order.put("email", "ASC");

//config is map with "clientId" -> :your_client_id: and "secret" -> :your_client_secret:
Cache cache = new Cache(config);

try {
    Response response = cache.getUsers(null, 0l, order, fields, null, null);
} catch (IsaacloudConnectionException e) {
    // handle connection exceptions here
} catch (Exception e) {
    e.printStackTrace();
}
```

There are multiple ways to access the result of the request. Depending on the expected form of the result (single JSON object or a JSON array), the user can use:

```java
JSONObject json = (JSONObject) response.getJson()
```

or

```java
JSONArray array = (JSONArray) response.getJson()
```

You can check whether it is an array or object using *isObject()* or *isArray()*

If no detailed exception handling is required, you can simply catch the basic IsaacloudConnectionException, as shown in the sample call above. If more detailed information about the error is needed, however, there are several exception classes that extend the general IsaacloudConnectionException. Catch the detailed exception before the general one. Check isaacloud package for more details on available exceptions. Each of these exceptions can return an internal error code and message through the getInternalCode() and getMessage() methods. Reviewing these values will give you further insight on what went wrong.

For detailed information about the possible uri calls, available query parameters and request methods please see our documentation:
https://isaacloud.com/documentation
