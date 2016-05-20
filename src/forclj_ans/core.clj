(ns forclj-ans.core)

(defn a1 [] true)

(defn a2 [] 4)

(defn a3 [] "HELLO WORLD")

(defn a4
  "公案そのままでは厳しいので若干変更"
  []
  (list :a :b :c))

(defn a5 [] '(1 2 3 4))

(defn a6 [] '(:a :b :c))

(defn a7 [] [1 2 3 4])

(defn a8 [] #{:a :b :c :d})

(defn a9 [] 2)

(defn a10 [] 20)

(defn a11 [] [:b 2])

(defn a12 [] 3)

(defn a13 [] '(20 30 40))

(defn a14 [] 8)

(defn a15 [x] (* x 2))

(defn a16 [name]
  (str "Hello, " name "!"))

(defn a17 [] '(6 7 8))

(defn a18 [] '(6 7))

(defn a19 [coll]
  (reduce (fn [x y] y) coll))

(defn a20 [coll]
  (nth coll (- (count coll) 2)))

(defn a21 [coll index]
  (loop [in-coll coll
         n index]
    (if (zero? n)
      (first in-coll)
      (recur (rest in-coll) (dec n)))))

(defn a21-alt
  "最初にしてた回答"
  [coll index]
  (first (drop index coll)))

(defn a22 [coll]
  (loop [x coll, n 0]
    (if-not (seq x)
      n
      (recur (rest x) (inc n)))))

(defn a22-alt [coll]
  "最初にしてた回答。殆ど変わりないんだが letfn は別に要らないような。"
  (letfn [(cnt1 [coll n]
            (if (= coll '())
              n
              (recur (rest coll) (inc n))))]
    (cnt1 coll 0)))

(defn a24 [coll] (apply + coll))

(defn a35 [] 7)

(defn a36
  "まんまは厳しいので destructuring でそれっぽく"
  [] [7 3 1])

(defn a37 [] "ABC")

(defn a57 [] [5 4 3 2 1])

(defn a52 []
  (let [[a b c d e] [0 1 2 3 4]] [c e]))

(defn a68 [] [7 6 5 4 3])

(defn a64 [] +)

(def a71 last)

(def a72 (partial apply +))

(defn a134 [k m]
  (and (contains? m k)
       (nil? (k m))))

(defn a145 [] [1 5 9 13 17 21 25 29 33 37])

(defn a156 [v ks]
  (->> (interleave ks (repeat v))
       (partition 2)
       (map vec)
       (reduce conj {})))

(defn a161 [] #{1 2})
