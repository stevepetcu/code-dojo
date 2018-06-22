(ns midje_tdd.diamond_test
  (:require [midje.sweet :refer :all]
            [midje_tdd.diamond :refer :all]))

(facts "about `build`"
       (fact "it can return a character"
             (build 'A) => 'A)
       (fact "it won't accept more than an input character"
             ;; The following test not pass. TODO: implement input validation.
             (build 'AB) => 'AB))
