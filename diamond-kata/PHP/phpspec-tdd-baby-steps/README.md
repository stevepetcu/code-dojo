# Test-driven development with the Diamond Kata

**Baby-steps, TDD with PHPSpec** version of the Diamond Kata.

**Note**: Baby-steps is a game where we commit code that's gone through a Red-Green(-Refactor) cycle (and is thus in a working state) every 10 minutes. Uncommited code should be deleted and work resumed from last working-state version every 10 minutes.

## Setting up the environment for first run

Setup the docker machine:
```bash
docker-machine create dk.php.phpspec-tdd-baby-steps && eval $(docker-machine env dk.php.phpspec-tdd-baby-steps)
```

Install dependencies, run tests and run the application:
```bash
make all
```

**Note**: If an `ERROR: Couldn't connect to Docker daemon.` message is displayed at any time, make sure the docker-machine is evaluated in the current terminal:
```bash
eval $(docker-machine env dk.php.phpspec-tdd-baby-steps)
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
