DOCKER_MACHINE_NAME := dk.java.junit-tdd
DOCKER_MACHINE_STATE := $(shell docker-machine ls --filter name=$(DOCKER_MACHINE_NAME) --format "{{.State}}")
EVALUATED_DOCKER_MACHINE_NAME := ${DOCKER_MACHINE_NAME}

.DEFAULT_GOAL := run
.PHONY: all, confirm, up, test, compile, run

all: confirm up test run

confirm:
	@(read -p "Running this command may take a while. Are you sure? [y/N]: " sure && case "$$sure" in [yY]) true;; *) false;; esac)

up: check-env
	docker-compose up -d

test: check-env
	docker-compose exec maven mvn clean test

compile: check-env
	docker-compose exec java ./docker/java/scripts/compile.sh

run: check-env
	docker-compose exec java ./bin/console.sh

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