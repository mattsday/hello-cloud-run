# Hello Cloud Run

Silly little demo to show Cloud Run scaling and help optimise it.

The [Dockerfile](Dockerfile) contains the optimisations which include JVM arguments and Spring Boot ones.

## The App

It listens on two interfaces:

1. `/` and `/hello` - returns an array of `hello cloud run`
2. `/hello/{x}` - returns an array of `hello {x}` where `{x}` is abitrary text

All code is defined in [src/main/kotlin/uk/co/mattsday/demos/hellocloudrun](src/main/kotlin/uk/co/mattsday/demos/hellocloudrun)

## Optimisations

### JVM

1. `-XX:TieredStopAtLevel=1` - doesn't continue to optimise the Just-in-time compiler (JIT) which reduces startup time at the cost of potential future performance
2. `-XX:+AlwaysPreTouch` - touches memory at startup phase rather than incrementally during startup - not sure if this has an impact (worth testing)
3. `noverify` - removed in JDK 13 - skips verification of bytecode in the class loader

### Spring Boot

1. `spring.main.banner-mode=off` - remove the banner, don't think it affects startup time but helps reduce log clutter
2. `spring.main.lazy-initialization=true` - new in Spring Boot 2.2 or later, enables lazy loading - [info](https://www.baeldung.com/spring-boot-lazy-initialization)

