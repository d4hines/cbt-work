(ns clojure-noob.core
  (:gen-class))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}])

(identity asym-hobbit-body-parts)

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part (asym-hobbit-body-parts 1))


(defn symmetrize-body-parts ;1
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts ;2
         final-body-parts []]
    (if (empty? remaining-asym-parts) ;3
      final-body-parts
      (let [[part & remaining] remaining-asym-parts] ;4
        (recur remaining ;5
          (into final-body-parts
            (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

(def x 0)
(let [x (inc x)] x)

(def dalmatian-list `("Pongo" "Perdita" "Puppy"))
(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

(into [ 1 2 3] (set [:foo :foo]))

(comment
 (loop [iteration 0 mes "win!"]
  (println (str "Iteration " iteration)
   (if) (> iteration 3)
     (do
       (println "Goodbye!")
       (str "You " mes))
     (recur (inc iteration) mes))))


(+
 (+ 4 5
    (+ 1 3)))

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))
(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)
(hit asym-hobbit-body-parts)
(hit asym-hobbit-body-parts)
(hit asym-hobbit-body-parts)

(let [myVector [{:a "b"} 1 2 2 "b" :a {:a "b"} {:a "c"}]]
     (set myVector))

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(defn length [array]
  (reduce (fn [length currEl] (+ length 1))
    0
    array))

(def afterFeb (drop-while #(< (:month %) 2) food-journal))
(length afterFeb)
(length (take-while #(< (:month %) 4) (drop-while #(< (:month %) 2) food-journal)))
