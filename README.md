# org-fearless-url-shortener

[lesson](https://bclozel.github.io/lectures/spring-boot-hol)

[pdf](/spring-boot-url-shortener.pdf)

Generated with:

```
$ mkdir url-shortener && cd $_
$ curl https://start.spring.io/starter.zip \
    -d type=maven-project \
    -d platformVersion=2.0.9.RELEASE \
    -d dependencies=web,devtools,actuator \
    -d groupId=org.fearless \
    -d artifactId=urlshortener \
    -o url-shortener.zip
$ unzip url-shortener.zip
$ rm url-shortener.zip
```

## Test it

```
$ ./mvnw clean test
```

## Start it

```
$ ./mvnw spring-boot:run
$ open http://localhost:8080
$ curl http://localhost:8080
```

## Do More @

<https://spring.io/guides>