(ns advent-2-2
  (:import (java.io FileReader BufferedReader))
  (:use [clojure.string :only (split)])
  )

(defn ribbon [a b]
  (+ a a b b))

(defn bow [l w h]
  (* l w h))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn parse-line [line]
  (map parse-int (split line #"x")))

(defn read-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    ((fn [line acc]
       (if (some? line)
         (let [l (parse-line line)]
           (recur (. br readLine) (+ acc (apply bow l)
             (apply ribbon (drop-last (sort l)))))
           )
         (println acc)
         )
       )
     (. br readLine) 0)
    ))

(read-file "input2-1.txt")
