(ns advent-1-2
  (:import (java.io FileReader BufferedReader)))

(defn read-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    ((fn [c pos acc]
       (if (and (not= acc -1) (not= c -1))
         (recur (. br read) (inc pos) (cond
                                        (= c 40) (inc acc)
                                        (= c 41) (dec acc)))
         (println (str "position " pos " sum " acc)))
       )
     (. br read) 0 0
     )))

(read-file "input.txt")
