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
  (is (= (a5) (conj '(2 3 4) 1))
      (= (a5) (conj '(3 4) 2 1))))
