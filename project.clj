(defproject chalk "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure       "1.8.0"]
                 [org.clojure/java.jdbc     "0.7.6"]
                 [org.postgresql/postgresql "9.4.1212"]
                 [ring                      "1.6.3"]
                 [korma                     "0.4.3"]
                 [compojure                 "1.6.1"]
                 [hiccup                    "1.0.5"]
                 [ragtime                   "0.7.2"]
                 [jarohen/nomad             "0.7.3"]
                 [buddy/buddy-auth          "2.1.0"]
                 [buddy/buddy-hashers       "1.3.0"]
                 [log4j                     "1.2.15"
                                            :exclusions [javax.mail/mail
                                                         javax.jms/jms
                                                         com.sun.jdmk/jmxtools
                                                         com.sun.jmx/jmxri]]]
  :main ^:skip-aot chalk.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-ring "0.12.4"]
            [venantius/ultra "0.5.2"]]
  :ring {:handler chalk.core/app
         :port 3009}
  :aliases {"migrate"  ["run" "-m" "chalk.db/migrate"]
            "rollback" ["run" "-m" "chalk.db/rollback"]})
