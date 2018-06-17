.PHONY: all, run, compile

all: compile run

run:
	docker-compose exec java ./bin/console.sh

compile:
	docker-compose exec java ./docker/java/scripts/compile.sh