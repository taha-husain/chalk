(ns chalk.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "<h1>Hello World</h1>")
  (route/not-found "<h1>Page not found</h1>"))

