(ns rpn.t-core
  (:use midje.sweet)
  (:use [rpn.core]))

(facts "about RPN calculator"
  (fact "a number evaluates to itself"
    (evaluate "0") => 0
    (evaluate "1") => 1)
  
  (fact "it adds several numbers"
    (evaluate "0 1 +") => 1
    (evaluate "1 2 5 + +") => 8)
  
  (fact "it subtracts several numbers"
    (evaluate "0 1 -") => -1
    (evaluate "1 2 5 - -") => 4))
