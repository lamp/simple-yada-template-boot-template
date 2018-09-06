(ns boot.new.simple-yada-template
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "simple-yada-template"))

(defn simple-yada-template
  "Entrypoint for template generator requires a name argument which is the name of the project
  This will provide you with an app at `pwd`/name
  Usage: boot -d boot/new -t simple-yada-template -n name"
  [name]
  (let [data {:name name
              :sanitised (name-to-path name)}]
    (println "Generating fresh 'boot new' simple-yada-template project.")
    (->files data
             ["src/{{sanitised}}/core.clj" (render "core.clj" data)]
             ["build.boot" (render "build.boot" data)]
             [".gitignore" (render "gitignore" data)]
             ["config.edn" (render "config.edn" data)]
             "resources")))

