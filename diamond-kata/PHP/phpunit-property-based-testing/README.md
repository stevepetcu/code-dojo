# Property Based Testing with the Diamond Kata

**Property-based testing with PHPUnit** version of the Diamond Kata.

**Note**: Property-based testing (contrasted with state-based testing) is a testing procedure where we take a more functional approach to our tests. For example, if we were to property-based test addition of numbers, we'd take a look at testing its properties (commutativity, associativity, identity), as opposed to testing a (potentially infinite) subset of number additions.

## Setting up the environment for first run

Setup the docker machine:
```bash
docker-machine create dk.php.phpunit-property-based-testing && eval $(docker-machine env dk.php.phpunit-property-based-testing)
```

Install dependencies, run tests and run the application:
```bash
make all
```

**Note**: If an `ERROR: Couldn't connect to Docker daemon.` message is displayed at any time, make sure the docker-machine is evaluated in the current terminal:
```bash
eval $(docker-machine env dk.php.phpunit-property-based-testing)
```

## Upping the docker containers

Start the docker containers, but skip everything else:
```bash
make up
```

## Installing dependencies

Install composer dependencies, but skip everything else:
```bash
make install
```

Replace install with `update` or `require` for running the associated composer functions.

## Running the tests

Run the tests, but skip everything else:
```bash
make test
```

## Running the application

Run the application, but skip everything else:
```bash
make run
```
