# IsaaCloud SDK for Java

The IsaaCloud Java SDK can be used to access the IsaaCloud API through Java. The user can make any number of request calls to the API.

## Requirements

The library works on **Java version 1.7** and **sbt 0.13.0.**

## Basics

This SDK can be used to connect to the Isaacloud v1 REST API on api.com.isaacloud.com.
The "com.isaacloud" package contains a special class Isaacloud, which contains some nice methods for use in communicating with the API.

You can also access the [javadocs](http://isaacloud.github.io/java-sdk/).

## How to build

## How to build it

1. Clone the repository:

    ```
    git clone https://github.com/com.isaacloud/java-sdk.git
    ```

2. Enter the directory:

    ```
    cd java-sdk
    ```

3. Run the installation of dependencies:

    ```
    sbt compile
    ```

    You can publish it to your local maven repository by using:

    ```
    sbt publish
    ```

    or you can add it as a dependency with build.java. For example:

```java
object Build extends Build {
    lazy val sdk = RootProject(uri("https://github.com/com.isaacloud/java-sdk.git#%s".format("0.0.2-RC2")))
    lazy val defaultSettings =
        Defaults.defaultSettings ++
            Seq(
                name := "play_example",
                version := "1.0",
                javaVersion := "2.10.1",
                javacOptions := Seq(
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

## Overview

To make request calls, you can use the Isaacloud API class. To make a simple request, we first need to specify the path to a resource using the *path* method, then declare the query parameters and lastly use a specific REST method for acquiring the results.
Examples of calls:

```java
Map<String, String> config = new HashMap<>();
config.put("clientId",":your_client_id:");
config.put("secret",":your_client_secret:");

Map<String, String> order = new HashMap<>();
order.put("email", "ASC");

Isaacloud isaac = new Isaacloud(config);
try {
    Response response = isaac.path("/cache/users").withFields("email","firstName").withOrder(order).get();
} catch (IsaacloudConnectionException e) {
    // handle connection exceptions here
} catch (Exception e) {
    e.printStackTrace();
}
```

The methods that start with the word *with* are responsible for narrowing the result set. Each one changes the way the result will be returned by the method. You can combine multiple methods in order to get the desired effect.
In methods without a certain trait it will be ignored. The list of the methods is presented below:


* withFields - narrows the result set to contain only json fields which are in the list of the method

    ```java
    Response response = isaac.path("/cache/users").withFields("firstName","lastName");  
    //returns the users' first and last name only
    ```

* withPaginator - limits the number and defines the offset for the results, works only with list resources

    ```java
    Response response = isaac.path("/cache/users").withPaginator(10l,5l);  
    //returns 5 elements starting with the tenth
    ```

* withGroups - returns only the resources containing groups' ids in the list

    ```java
    Response response = isaac.path("/cache/users").withGroups(1l,2l,3l);  
    //returns only the users in segments 1 or 2 or 3
    ```

* withSegments - returns only the resources containing segments' ids in the list

    ```java
    Response response = isaac.path("/cache/users").withSegments(1l,2l
    ,3l);  //returns only the users in segments 1 or 2 or 3
    ```

* withIds - returns only the the resources with ids in the list

    ```java
    Response response = isaac.path("/cache/users").withSegments(1l,2l,3l);  
    //returns only the users in segments 1 or 2 or 3
    ```

* withOrder - declares the order in which the results in list resources should be returned

    ```java
    Map<String,String> order = new HashMap<>();
    order.put("firstName","ASC");
    order.put("lastName","DESC");
    Response response = isaac.path("/cache/users").withOrder(order);  
    //returns results sorted first by firstName ascending and then by lastName descending
    ```

* withCreatedAt - returns only the resources created between certain dates given in milliseconds. If one of the parameters is None, the limit is not set.

    ```java
    Response response = isaac.path("/cache/users").withCreatedAt(1398157190540l,null);  
    //returns only the users created after Tue Apr 22 2014 8:59:50 AM
    ```

* withUpdatedAt - returns only the resources last updated between certain dates given in milliseconds. If one of the parameters is None, the limit is not set.

    ```java
    Response response = isaac.path("/cache/users").withUpdatedAt(null, 1398157190540l);  
    //returns only the users last updated before Tue Apr 22 2014 8:59:50 AM
    ```

* withCustom - shows custom fields in the result

    ```java
    Response response = isaac.path("/admin/users").withCustom();  
    //returns all custom fields
    ```

* withCustoms - declares exactly which fields in custom fields should be shown.

    ```java
    Response response = isaac.path("/admin/users").withCustoms("shoeSize","weight");  
    //returns only custom fields with keys shoeSize and weight
    ```

* withQuery - performs a search with specific field values.
    ```java
    Map<String,Object> query = new HashMap<>();
    query.put("wonGames.amount", 12);
    query.put("wonGames.game", 1);
    Response response = isaac.path("/admin/users").withQuery(query);  
    //returns only users with game 1 won 12 times
     ```

* withQueryParameters - adds query parameters manually.
    ```java
    Map<String,Object> params = new HashMap<>();
    List<String> fields= new LinkedList<>();
    fields.add("firstName");
    fields.add("lastName");
    params.put("fields",fields);
    Response response = isaac.path("/cache/users").withQueryParameters(params);  
    //returns the users' first and last name only
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

If no detailed exception handling is required, you can simply catch the basic IsaacloudConnectionException, as shown in the sample call above. If more detailed information about the error is needed, there are several exception classes that extend the general IsaacloudConnectionException. Catch the detailed exception before the general one. Check com.isaacloud package for more details on available exceptions. Each of these exceptions can return an internal error code and message via the getInternalCode() and getMessage() methods. Reviewing these values will give you further insight on what went wrong.

## Additional examples

### Send events

There is an additional method in the Isaacloud class used for creating events:

```java

    JSONObject body = new JSONObject();
    body.put("destination","JFK");
    body.put("distance","2000");

    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);
    isaac.event(1,"USER","PRIORITY_NORMAL", 1,"NORMAL",body);
```

The method takes the subject id (the id of the group or user it relates to), the subject type (USER or GROUP), the event type, the priority of the event and the body for the event.
Most of this information can be found in scaladocs.

### Get one user from cache

To get one user, use the get method:

```java
    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);
    Long id = 1;
    JSONObject user = (JSONObject)isaac.path("cache/users/"+id).get().getJson();
```

### Get the list of users from cache

To get the list of users, use the get method:

```java
    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);

    JSONArray users = (JSONArray)isaac.path("cache/users").get().getJson();
```

### Create a user

To create a user, use the post method:

```java
    JSONObject user = new JSONObject();
    user.put("birthDate", "1979-10-22");
    user.put("email","dbrown@example.com");
    user.put("password","M0nKey_busine$s");
    user.put("firstName","Dan");
    user.put("lastName","Brown");

    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);

    JSONObject user = (JSONObject)isaac.path("admin/users").post(user);
```

### Update a user

To update a user, use the put method:

```java
    JSONObject user = new JSONObject();
    user.put("firstName","Bob");
    user.put("lastName","Blue");

    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);

    Long id = 1;
    JSONObject user = (JSONObject)isaac.path("admin/users/"+id).put(user);
```

### Delete a user

To delete a user, use the delete method:

```java
    Map<String, String> config = new HashMap<>();
    config.put("clientId",":your_client_id:");
    config.put("secret",":your_client_secret:");
    Isaacloud isaac = new Isaacloud(config);

    isaac.path("admin/users/" + id).delete();
```

For detailed information about the possible URI calls, available query parameters and request methods please see our documentation:
https://com.isaacloud.com/documentation
