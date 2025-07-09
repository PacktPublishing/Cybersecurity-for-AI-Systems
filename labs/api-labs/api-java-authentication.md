
[  Back to Main Menu](./README.md)

API Java Authentication
=======================

# Intro

## The Problem
 * You develop a great web service.
 * But you need to secure it.
   - Do you *really* need to secure it?
   - **YES!**
 * How to do that?

Notes:

Instructor Notes:

Participant Notes:

We are introducing the idea here of how to sercure web services.  In general,
web services need authentication and authorization to protect their contents
against attackers.  Even very simple web services deployed in a trusted 
environment .

---


## HTTP Basic Authentication
 * Uses HTTP Standard Headers
 * Combine Username + Password to `Base64` string
   - example: `myusername:mypassword`
   - NOT encrypted.  So you need to use SSL!

```text
Authorization: Basic  QWxhZGRpbjpvcGVuIHNlc2FtZQ==
```

Notes:

Instructor Notes:

Participant Notes:

HTTP Basic Authentication is, as its name implies, 
basic.  Unfortunately, it's not particularly secure.  There are 
a lot of problems with this.  It's vulnerable to cross-site
request forgery, CSRF, for one thing, one thing we will discuss
later.


## Spring Basic Authentiation
 * Basic Authentication can be set up by Spring boot
 * By including spring-boot-starter-security 

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Notes:

Instructor Notes:

Participant Notes:

Spring Boot gives us a reasonably good "basic" authentication
with minimal effort.  As a matter of fact, we don't need to do
anything except add the spring-boot-starter-security artifact
to our project.

That said, simply autheticating doesn't actually protect anything.
We will need to

## JSON Web Tokens
 * 

Notes:

Instructor Notes:

Participant Notes:


---

## Cross Site Network Forgery

* When an attacker hijacks a user token
  - reuses token for malicious purposes.
* How to preent CSNF?
  - use SSL
  - Enable CSNF mode 


Notes:

Instructor Notes:

Participant Notes:

Cross-Site Network Forgery means that if an attacker can grab a hold of
a HTTP header of a request, then then he or she can impersonate the user
for the remainder of the session, possibly compromising user data.

To protect against CSNF, we need a 


---


