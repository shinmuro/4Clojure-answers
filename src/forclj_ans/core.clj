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
