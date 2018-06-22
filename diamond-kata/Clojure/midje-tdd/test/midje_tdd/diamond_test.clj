(ns midje_tdd.diamond_test
  (:require [midje.sweet :refer :all]
            [midje_tdd.diamond :refer :all]))

(facts "about `build`"
       (fact "it can return an element"
             (build ['A']) => 'A'))
