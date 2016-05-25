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
  "最初にしてた解答"
  [coll index]
  (first (drop index coll)))

(defn a22 [coll]
  (loop [x coll, n 0]
    (if-not (seq x)
      n
      (recur (rest x) (inc n)))))

(defn a22-alt [coll]
  "最初の解答。殆ど変わりないんだが letfn は別に要らないような。"
  (letfn [(cnt1 [coll n]
            (if (= coll '())
              n
              (recur (rest coll) (inc n))))]
    (cnt1 coll 0)))

(defn a23 [coll]
  (loop [result nil
         remained coll]
    (if-not (seq remained)
      result
      (recur (cons (first remained) result) (rest remained)))))

(defn a24 [coll] (apply + coll))

(defn a25 [coll] (filter odd? coll))

;; シーケンス返すなら loop で求めた方が楽な気がする
(defn a26
  "ものっそい愚直な解答。けど簡単に StackOverFlow 起こす Clojure だと現実的にはこちらが正しい気がする。"
  [n]
  (loop [result [1 1]
         accum 2]
    (cond
      (zero? n) nil
      (= n 1) [1]
      (= n 2) result
      (= n accum) result
      :else (recur (conj result (apply + (take-last 2 result)))
                   (inc accum)))))

(defn a27 [coll]
  (let [len (count coll)
        [x y-tmp] (split-at (quot len 2) coll)
        y (if (pos? (mod len 2)) (rest y-tmp) y-tmp)]
    (= x (reverse y))))

(defn a27-alt
  "最初の解答。明らかにこっちの方が簡単"
  [coll]
  (= (seq coll) (reverse coll)))

(defn a29
  [s]
  (->> (for [c s
             :let [n (int c)]
             :when (and (< 64 n) (> 91 n))]
         c)
       (apply str)))

(defn a29-alt
  "最初の解答。今さら Character/isUpperCase を自前でやる必要もないんでこれで十分ではある"
  [s]
  (apply str (filter (fn [c] (Character/isUpperCase c)) s)))

(defn a30 [coll]
  (loop [result []
         c coll]
    (cond
      (not (seq result))
      (recur (conj result (first c)) (rest c))

      (= (last result) (first c))
      (recur result (rest c))

      :default (recur (conj result (first c)) (rest c))
      )))

(defn a30-alt
  "最初の解答"
  [coll]
  (map first (partition-by identity coll)))

(def a30-alt-2
  "1.7 以降ならそのままのものがある"
  dedupe)

(defn a32
  [coll]
  (mapcat list coll coll))

(defn a32-alt
  "最初の解答。シンプルというかそのままというか。"
  [coll]
  (interleave coll coll))

(defn a34
  [start end]
  (if (= start end)
    nil
    (cons start (a34 (inc start) end))))

(defn a34-alt
  "最初の解答"
  [start end]
  (take (- end start) (iterate inc start)))

(defn a35 [] 7)

(defn a36
  "まんまは厳しいので destructuring でそれっぽく"
  [] [7 3 1])

(defn a37 [] "ABC")

(defn a38 [& args]
  (reduce (fn [x y] (if (>= x y) x y)) args))

(defn a38-alt
  "最初の解答。コードは上の方が長いけど最近は上の方が好み"
  [& args]
  (first (sort > args)))

(def a48 6)

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
