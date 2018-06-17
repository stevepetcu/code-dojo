.PHONY: all, confirm, test, compile, run

all: confirm test compile run

confirm:
	@(read -p "Running this command may take a while. Are you sure? [y/N]: " sure && case "$$sure" in [yY]) true;; *) false;; esac)

test:
	docker-compose exec maven mvn clean test

compile:
	docker-compose exec java ./docker/java/scripts/compile.sh

run:
	docker-compose exec java ./bin/console.sh