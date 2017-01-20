(ns rpn.core
  [:require [clojure.string :refer [split]]])

(def ^:private operators {"+" + "-" - "*" * "/" quot})

(def ^:private parse-int #(Integer/parseInt (re-find #"\A-?\d+" %)))

(def ^:private tokenize #(split % #"\s"))

(defn- parse-token [token]
  (if-let [op (get operators token)]
    op
    (parse-int token)))

(defn- parse [expression]
  (map parse-token (tokenize expression)))

(defn- process-symbol [stack symbol]
  (if (number? symbol)
    (conj stack symbol)
    (conj (pop (pop stack))
          (apply symbol (take-last 2 stack)))))

(defn- compute [symbols]
  (peek (reduce process-symbol [] symbols)))

(defn evaluate [expression]
  (->> expression
       parse
       compute))