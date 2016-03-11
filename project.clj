(defproject gorillalabs/tesla "0.3.0-SNAPSHOT"
  :description "basic microservice."
  :url "https://github.com/otto-de/tesla-microservice"
  :license {:name "Apache License 2.0"
            :url  "http://www.apache.org/license/LICENSE-2.0.html"}
  :scm {:name "git"
        :url  "https://github.com/gorillalabs/tesla"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [mount "0.1.9"]
                 [gorillalabs/config "1.0.0"]
                 [org.clojure/data.json "0.2.6"]
                 [beckon "0.1.1"]
                 [environ "1.0.2"]
                 [clj-time "0.11.0"]

                 [de.otto/status "0.1.0"]

                 ;; io
                 [ring/ring-core "1.4.0"]
                 [ring/ring-defaults "0.1.5"]

                 [compojure "1.4.0"]
                 [metrics-clojure "2.6.1"]
                 [metrics-clojure-graphite "2.6.1"]

                 [org.clojure/tools.logging "0.3.1"]]

;;  :filespecs [{:type :paths :paths ["test-utils"]}]

  :exclusions [org.clojure/clojure
               org.slf4j/slf4j-nop
               org.slf4j/slf4j-log4j12
               log4j
               commons-logging/commons-logging]

  :test-selectors {:default     (constantly true)
                   :integration :integration
                   :unit        :unit
                   :all         (constantly true)}
  :profiles {:test    {:env {:metering-reporter "console"
                             :server-port       "9991"
                             :cache-dir         "/tmp"}}
             :meta    {:env {:app-name :tesla-meta}}
             :uberjar {:aot :all}
             :dev     {:dependencies [[javax.servlet/servlet-api "2.5"]
                                      [org.slf4j/slf4j-api "1.7.16"]
                                      [ch.qos.logback/logback-core "1.1.5"]
                                      [ch.qos.logback/logback-classic "1.1.5"]
                                      [ring-mock "0.1.5"]]
                       :plugins      [[lein-ancient "0.6.8"]
                                      [lein-marginalia "0.8.0"]
                                      [lein-environ "1.0.2"]]

                       :env          {:system "SYSTEM"
                                      :env    "ENV"}}}
  :test-paths ["test" "test-resources" "test-utils"])
