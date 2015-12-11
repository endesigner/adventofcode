(ns advent-1-1
  (:import (java.io FileReader BufferedReader)))

(defn read-file [file-name]
  (let [br (BufferedReader. (FileReader. file-name))]
    ((fn [c acc]
       (if (not= c -1)
         (recur (. br read) (cond
                              (= c 40) (inc acc)
                              (= c 41) (dec acc)
                              ))
         (println acc)
         )
       )
     (. br read) 0
     )))

(read-file "input.txt")
