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
    (evaluate "1 2 5 - -") => 4)
  
  (fact "it multiplies several numbers"
    (evaluate "0 1 *") => 0
    (evaluate "1 2 5 * *") => 10)
  
  (fact "it divides several numbers (integer division)"
    (evaluate "4 2 /") => 2
    (evaluate "10 5 5 / /") => 10))
