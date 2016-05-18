(ns forclj-ans.core-test
  (:require [clojure.test :refer :all]
            [forclj-ans.core :refer :all]))

(deftest q1
  (is (= (a1) true)))

(deftest q2
  (is (= (a2) (- 10 (* 2 3)))))

(deftest q3
  (is (= (a3) "HELLO WORLD")))

(deftest q4
  (is (= (a4) '(:a :b :c))))

(deftest q5
  (is (= (a5) (conj '(2 3 4) 1)))
  (is (= (a5) (conj '(3 4) 2 1))))

(deftest q6
  (is (= (a6) (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

(deftest q7
  (is (= (a7) (conj [1 2 3] 4)))
  (is (= (a7) (conj [1 2] 3 4))))

(deftest q8
  (is (= (a8) (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= (a8) (clojure.set/union #{:a :b :c} #{:b :c :d}))))

(deftest q9
  (is (= #{1 2 3 4} (conj #{1 4 3} (a9)))))

(deftest q10
  (is (= (a10) ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= (a10) (:b {:a 10, :b 20, :c 30}))))

(deftest q11
  (is (= {:a 1, :b 2, :c 3} (conj {:a 1} (a11) [:c 3]))))

(deftest q12
  (is (= (a12) (first '(3 2 1))))
  (is (= (a12) (second [2 3 4])))
  (is (= (a12) (last (list 1 2 3)))))

(deftest q13
  (is (= (a13) (rest [10 20 30 40]))))

(deftest q14
  (are [x y] (= x y)
    (a14) ((fn add-five [x] (+ x 5)) 3)
    (a14) ((fn [x] (+ x 5)) 3)
    (a14) (#(+ % 5) 3)
    (a14) ((partial + 5) 3)))

(deftest q15
  (are [x y] (= (a15 x) y)
    2 4
    3 6
    11 22
    7 14))

(deftest q16
  (are [x y] (= (a16 x) y)
    "Dave" "Hello, Dave!"
    "Jenn" "Hello, Jenn!"
    "Rhea" "Hello, Rhea!"))

(deftest q17
  (is (= (a17) (map #(+ % 5) '(1 2 3)))))

(deftest q18
  (is (= (a18) (filter #(> % 5) '(3 4 5 6 7)))))

(deftest q35
  (is (= (a35) (let [x 5] (+ 2 x))))
  (is (= (a35) (let [x 3, y 10] (- y x))))
  (is (= (a35) (let [x 21] (let [y 3] (/ x y))))))

(deftest q36
  (is (= 10 (let [[x y z] (a36)] (+ x y))))
  (is (= 4 (let [[x y z] (a36)] (+ y z))))
  (is (= 1 (let [[x y z] (a36)] z))))

(deftest q37
  (is (= (a37) (apply str (re-seq #"[A-Z]+" "bAlB3Ce")))))

(deftest q57
  (is (= (a57) ((fn foo [x]
              (when (> x 0)
                (conj (foo (dec x)) x))) 5))))

(deftest q68
  (is (= (a68)
         (loop [x 5
                result []]
           (if (> x 0)
             (recur (dec x) (conj result (+ 2 x)))
             result)))))

(deftest q64
  (is (= 15 (reduce (a64) [1 2 3 4 5])))
  (is (=  0 (reduce (a64) [])))
  (is (=  6 (reduce (a64) 1 [2 3]))))

(deftest q71
  (is (= (a71 (sort (rest (reverse [2 5 4 1 3 6]))))
         (-> [2 5 4 1 3 6] reverse rest sort a71))))

(deftest q72
  (is (= (a72 (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
         (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (a72))
         11)))

(deftest q134
  (are [t-or-f k] (t-or-f (a134 k {:a nil :b 2}))
    true? :a
    false? :b
    false? :c))

;; どっか打ち間違える可能性大
;; の前に are でコケた。1個はダメ？
(deftest q145
  (is (= (a145) (for [x (range 40)
                        :when (= 1 (rem x 4))]
                  x)))
  (is (= (a145) (for [x (iterate #(+ 4 %) 0)
                      :let [z (inc x)]
                      :while (< z 40)]
                  z)))
  (is (= (a145) (for [[x y] (partition 2 (range 20))]
                  (+ x y)))))
