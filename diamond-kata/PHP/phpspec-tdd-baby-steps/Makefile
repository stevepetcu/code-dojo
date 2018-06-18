DOCKER_MACHINE_NAME := dk.java.junit-tdd
DOCKER_MACHINE_STATE := $(shell docker-machine ls --filter name=$(DOCKER_MACHINE_NAME) --format "{{.State}}")
EVALUATED_DOCKER_MACHINE_NAME := ${DOCKER_MACHINE_NAME}

.DEFAULT_GOAL := run
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

check-env:
ifneq ($(DOCKER_MACHINE_STATE),Running)
	$(warning Docker machine "$(DOCKER_MACHINE_NAME)" in unexpected state: "$(DOCKER_MACHINE_STATE)" (expected: "Running").)
	$(warning Please run the following command to create and evaluate the machine:)
	$(warning docker-machine create $(DOCKER_MACHINE_NAME) && eval $$(docker-machine env $(DOCKER_MACHINE_NAME)))
	$(warning Please run the following command to start and evaluate the machine:)
	$(warning docker-machine start $(DOCKER_MACHINE_NAME) && eval $$(docker-machine env $(DOCKER_MACHINE_NAME)))
	$(error Unable to confirm docker-machine $(DOCKER_MACHINE_NAME) running)
endif
ifneq ($(EVALUATED_DOCKER_MACHINE_NAME),$(DOCKER_MACHINE_NAME))
	$(warning Docker machine "$(DOCKER_MACHINE_NAME)" is not evaluated in the current terminal. Please run the following command:)
	$(warning eval $$(docker-machine env $(DOCKER_MACHINE_NAME)))
	$(error Couldn't connect to Docker daemon)
endif
