oshopper
========

Webshop exercise:
* Scalatra
* MongoDB
* json4s
* angular.js
* Restangular

## Solution ##

* angular.js acts as the UI framework
* Scala case classes act as the schema for the DB
* Scalatra acts as the REST framework
* json4s is used for serialization within the REST domain
* Database documents are written directly as JSON

## System parameters ##

When running the application on server you need to set -Dmongo.uri-parameter like so:

``
mongo.uri=PUT YOUR MONGODB URI HERE
``

## REST design rules ##

GET = SELECT

POST = INSERT

PUT = UPDATE

DELETE = DELETE
