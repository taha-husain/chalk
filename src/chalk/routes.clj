(ns chalk.routes
  (:require [compojure.route              :as    route]
            [buddy.auth.accessrules       :refer [restrict]]
            [compojure.core               :refer [defroutes context GET POST]]
            [chalk.services.auth          :refer [is-authenticated]]
            [chalk.controllers
              [authentication-controller  :refer [new-login login logout]]]))

(defroutes admin-routes
  (GET "/" [] "<h1>admin homepage</h1>"))

(defroutes app-routes
  (context "/admin" []
    (restrict admin-routes {:handler is-authenticated}))
  (GET "/"          []    "<h1>Hello World</h1>")
  (GET "/login"    []    new-login)
  (POST "/login"   []    login)
  (POST "/logout"  []    logout)
  (route/not-found "<h1>Page not found</h1>"))
