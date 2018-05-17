(ns chalk.core
  (:require [compojure.core :refer :all]
            [chalk.routes :refer [app-routes]]))

(def app
 (-> app-routes))
