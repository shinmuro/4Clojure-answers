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
