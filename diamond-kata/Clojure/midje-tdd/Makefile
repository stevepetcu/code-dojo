.PHONY: run, test, auto-test, ns-test

run:
	docker-compose exec clojure ./bin/console.sh

test:
	docker-compose exec clojure ./bin/test.sh test

auto-test:
	docker-compose exec clojure ./bin/test.sh auto

ns-test:
	docker-compose exec clojure ./bin/test.sh ns