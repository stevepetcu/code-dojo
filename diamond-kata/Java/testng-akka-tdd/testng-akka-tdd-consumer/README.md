# WIP
TODO:
- run kafka in docker and link containers through a network
- figure out how to write to properly write to streams

# Test-driven development with the Diamond Kata
**Property-based TDD with jUnit** version of the Diamond Kata.

This application consumes input streams from Kafka (characters) and writes the output (diamond) back to Kafka.

This application uses the TestNG framework for tests and the Akka framework for its actor implementation.

**Note**: Property-based testing is a testing procedure where we take a
more functional approach to our tests. For example, if we were to
property-based test addition of numbers, we'd take a look at testing its
properties (commutativity, associativity, identity).
This is in contrast with state-based testing, which would involve testing
addition over a (potentially infinite) subset of numbers.

## Setting up the environment for first run
Setup the docker machine:
```bash
docker-machine create dk.java.testng-akka-tdd-consumer && eval $(docker-machine env dk.java.testng-akka-tdd-consumer)
```

Make all the things:
```bash
make all
```
**Note**: The previous command will start the docker containers, package and run the application.

**Note**: If an `ERROR: Couldn't connect to Docker daemon.` message is
displayed at any time, make sure the docker-machine is evaluated in the current terminal:
```bash
eval $(docker-machine env dk.java.testng-akka-tdd-consumer)
```

## Building and upping the docker containers
Build and up the docker containers, but skip everything else:
```bash
make build-up
```

## Running the tests
Run the tests, but skip everything else:
```bash
make test
```

## Packaging the application
Package the application, but skip everything else:
```bash
make package
```

## Running the application
Run the application, but skip everything else:
```bash
make run
```
**Note**: Don't forget to package the application if any changes were made!