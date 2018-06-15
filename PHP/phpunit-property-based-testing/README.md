# Property Based Testing with the Diamond Kata

Over-engineered version of the Diamond Kata. Trying out property-based testing.

## Setting up the environment for first run

```
docker-machine create dk.php.phpunit-property-based-testing && eval $(docker-machine env dk.php.phpunit-property-based-testing) && docker-compose up -d
```

## Running the tests

```
docker-compose exec php ./vendor/bin/phpunit
```

## Running the code

```
docker-compose exec php ./bin/console
```