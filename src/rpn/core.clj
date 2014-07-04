(ns rpn.core)

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn parse-expression [expression]
  (let 
    [operators {"+" + "-" - "*" * "/" quot}
     parse-token 
     (fn [token]
       (let [op (get operators token)]
         (if (nil? op)
           (parse-int token)
           op)))]
    (map parse-token 
         (clojure.string/split expression #"\s"))))

(defn process-symbol [stack symbol]
  (if (number? symbol)
    (conj stack symbol)
    (conj (vec (drop-last 2 stack)) 
          (apply symbol (take-last 2 stack)))))

(defn evaluate [expression]
  (nth 
    (reduce 
      process-symbol
      []
      (parse-expression expression))
    0))

