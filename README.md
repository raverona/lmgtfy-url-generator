# lmgtfy-url-generator

### What is it?

It is a web service made with Kotlin and Spring MVC that takes a query parameter and responds with a lmgtfy link

##### What is lmgtfy?

lmgtfy, short for "let me google that for you", is a web service that helps people who don't know how to google stuff (it can be hard sometimes)

### Ok, but what is its purpose?

It's purpose is to be the back-end of a Slack Bot that answers a command with a search query with a lmgtfy link for the same query

### How it works?

It's a web server, you make a HTTP POST request it sends a response, failing or succeeding, simple as that 

### How do I run it?

`./gradlew bootRun` can be a good way to start it locally

### How do I contribute?

This repository is pretty much pointless, but if you really think something should or can be improved fork it and make a pull request