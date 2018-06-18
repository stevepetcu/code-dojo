# Test-driven development with the Diamond Kata
TDD with jUnit version of the Diamond Kata.

## Setting up the environment for first run
Setup the docker machine:
```bash
docker-machine create dk.java.junit-tdd && eval $(docker-machine env dk.java.junit-tdd)
```

Make all the things:
```bash
make all
```
**Note**: The previous command will start the docker containers,
compile and run the tests, and compile and run the application.

**Note**: If an `ERROR: Couldn't connect to Docker daemon.` message is
displayed at any time, make sure the docker-machine is evaluated in the current terminal:
```bash
eval $(docker-machine env dk.java.junit-tdd)
```

## Upping the docker containers
Start the docker containers, but skip everything else:
```bash
make up
```

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
