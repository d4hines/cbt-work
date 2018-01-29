(ns fwpd.core)
(require 'proto-repl.saved-values)
(def filename "/home/d4hines/repos/cbt-work/fwpd/suspects.csv")
(slurp filename)

(def vamp-keys [:name :glitter-index])
(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity
                  :glitter-index str->int})
(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(parse (slurp filename))

(defn fndotest []
  :test :foobar)

(fndotest)



(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (proto-repl.saved-values/save 1)
                   (assoc row-map vamp-key (convert vamp-key value)))
              {}
              (map vector vamp-keys unmapped-row)))
    rows))


(def vampire-map (mapify (parse (slurp filename))))

(identity vampire-map)

(first vampire-map)

(defn glitter-filter
  [min-glitter records]
  (filter #(>= (:glitter-index %) min-glitter) records))

(def high-glitter (glitter-filter 3 vampire-map))
(identity high-glitter)

(map :name high-glitter)

(defn validate
  [vmap record]
  (if
    (and false)
    :foo))

(validate :test :test)

; (defn add-suspect [entry existing-map]
;   (if)
;   (conj existing-map entry))
; (add-suspect {:name "Daniel Higginbotham" :key 7} vampire-map)

(loop [x 2 y "a"]
  (if (zero? x)
    y
    (recur (dec x) (str "a" y))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Peg Thing ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn row-sum [n]
  (loop [x n acc 0]
    (if (zero? x)
      acc
      (recur (dec x) (+ acc x)))))

(row-sum 5)


(defn tri*
  ([] (tri* 0 1))
  ([sum n]
   (let [new-sum (+ sum n)]
     (cons ne))))



def tri (tri)

(take 5 tri)
