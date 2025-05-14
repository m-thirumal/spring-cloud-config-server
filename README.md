# spring-cloud-config-server

### What is this repository for? ###

* Externalized (Property files)
* Environment specific (Spring Profile)
* Consistent (Spring cloud config)
* Version Management (GIT repo source)
* Real Time Management [Refresh config properties in client without restart]

## Required Repos link

* [https://github.com/M-Thirumal/config-repo](https://github.com/M-Thirumal/config-repo)
* [https://github.com/M-Thirumal/spring-cloud-config-client](https://github.com/M-Thirumal/spring-cloud-config-client)

## Eclipse set up

* Import as maven project
* Run as `Spring boot` application

## Build 

```
mvn clean package
```

## Run as Jar 

```
java -jar .\target\spring-cloud-config-server-0.0.1-SNAPSHOT.jar
```

## End points

Application in `DEV` environment will not ask for credentials, however on `PRO` environment it will and it;s basic authentication.

```
http://localhost:8888/{application}/{profile}/{label}
```

## Encryption at Rest - for properties
To encrypt the value before it gets stored in database/git

```
curl localhost:8888/encrypt -s -d mysecret
```

or 

```
curl -u <username>:<password> -s -d <data> http://localhost:8888/encrypt
```

## Decryption for properties

```
curl localhost:8888/decrypt -s -d 682bc583f4641835fa2db009355293665d2647dade3375c0ee201de2a49f7bda
```

### Who do I talk to? ###
* Thirumal