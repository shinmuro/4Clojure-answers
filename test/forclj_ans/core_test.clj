(ns forclj-ans.core-test
  (:require [clojure.test :refer :all]
            [forclj-ans.core :refer :all]))

(defmacro ^:private problem
  {:style/indent 1}
  [desc & body]
  `(testing (str "4Clojure problem #" ~desc)
     ~@body))

(deftest q1
  (problem "1 Nothing but the Truth"
           (is (= (a1) true))))


;; TODO: testing で問題番号、問題名追加
(deftest q1
  (problem "1 Nothing but the Truth" 
    (is (= (a1) true))))

(deftest q1
  (testing "4Clojure problem #1 Nothing but the Truth"
    (is (= (a1) true))))

(deftest q2
  (problem "2 Simple Math"
    (is (= (a2) (- 10 (* 2 3))))))

(deftest q3
  (problem "3 Intro to Strings"
    (is (= (a3) "HELLO WORLD"))))

(deftest q4
  (problem "4 Intro to Lists"
   (is (= (a4) '(:a :b :c)))))

(deftest q5
  (problem "5 Lists: conj"
    (is (= (a5) (conj '(2 3 4) 1)))
    (is (= (a5) (conj '(3 4) 2 1)))))

(deftest q6
  (problem "6 Intro to Vectors"
    (is (= (a6) (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))))

(deftest q7
  (problem "7 Vectors: conj"
    (is (= (a7) (conj [1 2 3] 4)))
    (is (= (a7) (conj [1 2] 3 4)))))

(deftest q8
  (problem "8 Intro to Sets"
    (is (= (a8) (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= (a8) (clojure.set/union #{:a :b :c} #{:b :c :d})))))

(deftest q9
  (problem "9 Sets: conj"
    (is (= #{1 2 3 4} (conj #{1 4 3} (a9))))))

(deftest q10
  (problem "10 Intro to Maps"
    (is (= (a10) ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= (a10) (:b {:a 10, :b 20, :c 30})))))

(deftest q11
  (problem "11 Maps: conj"
    (is (= {:a 1, :b 2, :c 3} (conj {:a 1} (a11) [:c 3])))))

(deftest q12
  (problem "12 Intro to Sequences"
    (is (= (a12) (first '(3 2 1))))
    (is (= (a12) (second [2 3 4])))
    (is (= (a12) (last (list 1 2 3))))))

(deftest q13
  (problem "13 Sequences: rest"
    (is (= (a13) (rest [10 20 30 40])))))

(deftest q14
  (problem "14 Intro to Functions"
    (are [x y] (= x y)
      (a14) ((fn add-five [x] (+ x 5)) 3)
      (a14) ((fn [x] (+ x 5)) 3)
      (a14) (#(+ % 5) 3)
      (a14) ((partial + 5) 3))))

(deftest q15
  (problem "15 Double Down"
    (are [x y] (= (a15 x) y)
      2 4
      3 6
      11 22
      7 14)))

(deftest q16
  (problem "16 Hello World"
    (are [x y] (= (a16 x) y)
      "Dave" "Hello, Dave!"
      "Jenn" "Hello, Jenn!"
      "Rhea" "Hello, Rhea!")))

(deftest q17
  (problem "17 Sequences: map"
    (is (= (a17) (map #(+ % 5) '(1 2 3))))))

(deftest q18
  (problem "18 Sequences: filter"
    (is (= (a18) (filter #(> % 5) '(3 4 5 6 7))))))

(deftest q19
  (problem "19 Last Element, Special Restrictions: last"
    (are [x y] (= (a19 x) y)
      [1 2 3 4 5] 5
      '(5 4 3) 3
      ["b" "c" "d"] "d")))

(deftest q20
  (problem "20 Penultimate Element"
    (are [x y] (= (a20 x) y)
      (list 1 2 3 4 5) 4
      ["a" "b" "c"] "b"
      [[1 2] [3 4]] [1 2])))

(deftest q21
  (problem "21 Nth Element, Special Restrictions: nth"
    (are [coll idx result] (= (a21 coll idx) result)
      '(4 5 6 7) 2 6
      [:a :b :c] 0 :a
      [1 2 3 4]  1 2
      '([1 2] [3 4] [5 6]) 2 [5 6])))

(deftest q22
  (problem "22 Count a Sequence"
    (are [coll result] (= (a22 coll) result)
      '(1 2 3 3 1)         5
      "Hello World"       11
      [[1 2] [3 4] [5 6]]  3
      '(13)                1)))

(deftest q24
  (problem "24 Sum It All Up"
    (are [coll result] (= (a24 coll) result)
      [1 2 3]          6
      (list 0 -2 5 5)  8
      #{4 2 1}         7
      '(0 0 -1)       -1
      '(1 10 3)       14)))



(deftest q35
  (problem "35 Local bindings"
    (is (= (a35) (let [x 5] (+ 2 x))))
    (is (= (a35) (let [x 3, y 10] (- y x))))
    (is (= (a35) (let [x 21] (let [y 3] (/ x y)))))))

(deftest q36
  (problem "36 Let it Be"
    (is (= 10 (let [[x y z] (a36)] (+ x y))))
    (is (= 4 (let [[x y z] (a36)] (+ y z))))
    (is (= 1 (let [[x y z] (a36)] z)))))

(deftest q37
  (problem "37 Regular Expressions"
    (is (= (a37) (apply str (re-seq #"[A-Z]+" "bAlB3Ce"))))))

(deftest q52
  (problem "52 Intro to Destructuring"
    (is (= [2 4] (a52)))))

(deftest q57
  (problem "57 Simple Recursion"
    (is (= (a57) ((fn foo [x]
                    (when (> x 0)
                      (conj (foo (dec x)) x))) 5)))))

(deftest q64
  (problem "64 Intro to Reduce"
    (is (= 15 (reduce (a64) [1 2 3 4 5])))
    (is (=  0 (reduce (a64) [])))
    (is (=  6 (reduce (a64) 1 [2 3])))))

(deftest q68
  (problem "68 Recurring Theme"
    (is (= (a68)
           (loop [x 5
                  result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result))))))

(deftest q71
  (problem "71 Rearranging Code: ->"
    (is (= (a71 (sort (rest (reverse [2 5 4 1 3 6]))))
           (-> [2 5 4 1 3 6] reverse rest sort a71)))))

(deftest q72
  (problem "72 Rearranging Code: ->>"
    (is (= (a72 (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
           (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (a72))
           11))))

(deftest q134
  (problem "134 Logical falsity and truth"
    (are [t-or-f k] (t-or-f (a134 k {:a nil :b 2}))
      true? :a
      false? :b
      false? :c)))

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

(deftest q156
  (problem "156 Map Defaults"
    (is (= (a156 0 [:a :b :c]) {:a 0 :b 0 :c 0}))
    (is (= (a156 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
    (is (= (a156 [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}))))

(deftest q161
  (problem "161 Subset and Superset"
    (is (clojure.set/superset? (a161) #{2}))
    (is (clojure.set/subset? #{1} (a161)))
    (is (clojure.set/superset? (a161) #{1 2}))
    (is (clojure.set/subset? #{1 2} (a161)))))
