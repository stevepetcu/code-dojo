# Property Based Testing with the Diamond Kata

Over-engineered version of the Diamond Kata. Trying out property-based testing.

## Setting up the environment for first run

Setup the docker-machine:
```bash
docker-machine create dk.php.phpunit-property-based-testing && eval $(docker-machine env dk.php.phpunit-property-based-testing)
```

Install dependencies, run tests and run the application:
```bash
make all
```

**OBS**: If an "_ERROR: Couldn't connect to Docker daemon._" message is displayed at any time, make sure the docker-machine is evaluated in the current terminal:
```bash
eval $(docker-machine env dk.php.phpunit-property-based-testing)
```

## Upping the application

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

## Running the code

Run the application, but skip everything else:
```bash
make run
```