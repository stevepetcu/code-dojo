DOCKER_MACHINE_NAME := dk.java.junit-tdd
DOCKER_MACHINE_STATE := $(shell docker-machine ls --filter name=$(DOCKER_MACHINE_NAME) --format "{{.State}}")

.PHONY: all, confirm, up, test, compile, run

all: confirm up test compile run

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
	$(warning Please make sure a docker machine named "$(DOCKER_MACHINE_NAME)" is running and evaluated in your terminal.)
	$(error Unable to confirm docker-machine $(DOCKER_MACHINE_NAME) running)
endif