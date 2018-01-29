(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
   2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))
(time (vampire-related-details 0))


true

false

(= true false)

(defn fizzbuzz [n]
  (cond
    (= (mod n 15) 0) "fizzbuzz"
    (= (mod n 3) 0) "fizz"
    (= (mod n 5) 0) "buzz"
    true n))


(fizzbuzz 45)
(fizzbuzz 9)
