(ns rpn.core)

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn evaluate [expression]
  (parse-int expression))

