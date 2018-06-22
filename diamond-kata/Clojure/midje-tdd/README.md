# Test-driven development with the Diamond Kata

**TDD with Clojure and [Midje](https://github.com/marick/Midje/)** version of the Diamond Kata.

## Setting up the environment for first run

Setup the docker-machine:
```bash
docker-machine create dk.clojure.midje-tdd && eval $(docker-machine env dk.clojure.midje-tdd)
```

## Running the tests

### Run all the tests:
```bash
make test
```

### Run the tests under a specified namespace:
```bash
make ns-test
```

### Run all the tests indefinitely:
```bash
make auto-test
```
This sets up a watcher on the code files. If they change, only the relevant tests will be run again.
