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
    (evaluate "10 5 5 / /") => 10)
  
  (fact "it computes an expression with several operators"
    (evaluate "4 2 / 5 + 10 * 5 6 - +") => 69
    (evaluate "3 2 1 + *") => 9
    (evaluate "1 2 + 4 * 5 + 3 -") => 14
    (evaluate "5 1 2 + 4 * + 3 -") => 14
    (evaluate "0 1 - 4 5 * *") => -20))
