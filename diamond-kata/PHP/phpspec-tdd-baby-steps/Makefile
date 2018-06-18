DOCKER_MACHINE_NAME := dk.php.phpspec-tdd-baby-steps
DOCKER_MACHINE_STATE := $(shell docker-machine ls --filter name=$(DOCKER_MACHINE_NAME) --format "{{.State}}")

.PHONY: all, up, install, test, run, check_env

all: up install test run

up: check_env
	docker-compose up -d

install: check_env
	docker run --rm --interactive --tty --volume $(shell pwd):/app composer install

test: check_env
	docker-compose exec php ./vendor/bin/phpspec run --verbose

run: check_env
	docker-compose exec php ./bin/console

check_env:
ifneq ($(DOCKER_MACHINE_STATE),Running)
	$(warning Docker machine "$(DOCKER_MACHINE_NAME)" in unexpected state: "$(DOCKER_MACHINE_STATE)" (expected: "Running").)
	$(warning Please make sure a docker machine named "$(DOCKER_MACHINE_NAME)" is running and evaluated in your terminal.)
	$(error Unable to confirm docker-machine $(DOCKER_MACHINE_NAME) running)
endif