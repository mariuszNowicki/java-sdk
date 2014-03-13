# Isaacloud SDK for Java programming language

This SDK can be used to connect to Isaacloud v1 REST API on api.isaacloud.com.

Main classes in "isaacloud" package are Cache, Admin and Queue, which represent corresponding entities in the REST API.

It is normally built using sbt, but you can also publish it to you local maven repository using:
```
sbt publish 
```
The "isaacloud" package also contains special class Isaacloud, which could in future contain more sophisticated methods for interacting with the REST API.

