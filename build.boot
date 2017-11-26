(def project 'simple-yada-template/boot-template)
(def version "0.1.0")

(set-env! :resource-paths #{"resources" "src"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [boot/new "RELEASE"]
			    [adzerk/bootlaces "0.1.13"]
                            [adzerk/boot-test "RELEASE" :scope "test"]]
          :repositories   (conj (get-env :repositories)
                                ["clojars" {:url "https://clojars.org/repo"
                                            :username (System/getenv "CLOJARS_USER")
                                            :password (System/getenv "CLOJARS_PASSWORD")}]))

(task-options!
 pom {:project     project
      :version     version
      :description "Simple Yada Boot Template"
      :url         "https://github.com/lamp/simple-yada-template-boot-template"
      :scm         {:url "https://github.com/lamp/simple-yada-template-boot-template"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
  push {:gpg-sign false
        :repo "clojars"})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]]
         '[boot.new :refer [new]]
         '[adzerk.bootlaces :refer :all])

(deftask deploy []
  (comp
    (pom)
    (jar)
    (push)))
