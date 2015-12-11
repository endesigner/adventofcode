(ns advent-1-2
  (:import (java.io FileReader BufferedReader))
  (:use [clojure.string :only (split)])
  )


(defn box-area [sides]
  (map (fn [side] (* 2 side)) sides))

(defn smallest [sides]
  (apply min sides))

(defn sides [l w h]
  (seq [(* l w) (* w h) (* h l)]))

(defn paper-needed [sides]
  (+ (smallest sides) (apply + (box-area sides))))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn read-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    ((fn [line acc]
       (if (some? line)
         (recur (. br readLine) (+ acc (paper-needed (apply sides (map parse-int (split line #"x"))))))
         (println acc)
         ))
     (. br readLine) 0)))

(read-file "input2-1.txt")

