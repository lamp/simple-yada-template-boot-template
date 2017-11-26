(ns boot.new.simple-yada-template
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "simple-yada-template"))

(defn simple-yada-template
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating fresh 'boot new' simple-yada-template project.")
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core" data)]
	     ["build.boot" (render "build.boot" data)]
             [".gitignore" (render "gitignore" data)]
             ["config.edn" (render "config.edn" data)])))
