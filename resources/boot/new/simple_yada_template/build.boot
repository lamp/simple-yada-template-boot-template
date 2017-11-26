(def project "{{name}}")
(def version "0.0.1")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths #{"src"}
          :dependencies '[[org.clojure/clojure "1.8.0"]
                          [org.clojure/tools.nrepl "0.2.13"]
                          [adzerk/boot-reload "0.5.2"]
                          [aleph "0.4.3"]
                          [yada "1.2.6"]
                          [aero "1.1.2"]
                          [prismatic/schema "1.1.7"]
                          [com.taoensso/timbre "4.10.0"]])

(require '[aero.core :refer (read-config)])

(require '[{{name}}.core])

(def config
  (read-config "config.edn"))

(task-options! 
  repl {:client true :port 5600})

(defn dev []
  (-> '{{name}}.core/-main
      (resolve)
      (apply [])))

(defn start []
 (comp
   (speak)
   (dev)))

(deftask run
  []
  (comp
    (repl :server true
          :port (get-in config [:webserver :port]))
    (start)))
