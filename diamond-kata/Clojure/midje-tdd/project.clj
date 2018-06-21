(defproject midje-tdd "0.0.1-SNAPSHOT"
  :description "Diamond Kata in Clojure with Midje TDD."
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :license "MIT License (included with the project)"
  :main midje_tdd.core
  :profiles {:dev {:dependencies [[midje "1.9.1"]]
                   :plugins [[lein-midje "3.2.1"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}}
             :uberjar {:aot :all})
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.

  
