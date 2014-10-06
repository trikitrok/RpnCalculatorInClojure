(ns rpn.core
  [:use [clojure [string :only [split]]]])

(defn- parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn- parse-token [token]
  (let 
    [operators {"+" + "-" - "*" * "/" quot}]
    (if-let [op (get operators token)] 
      op 
      (parse-int token))))

(defn- parse [expression]
  (map parse-token 
       (split expression #"\s")))

(defn- process-symbol [stack symbol]
  (if (number? symbol)
    (conj stack symbol)
    (conj (pop (pop stack))
          (apply symbol (take-last 2 stack)))))

(defn evaluate [expression]
  (peek 
    (reduce 
      process-symbol
      []
      (parse expression))))