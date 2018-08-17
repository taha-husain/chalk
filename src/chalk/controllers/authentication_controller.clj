(ns chalk.controllers.authentication-controller
  (require [ring.util.response                :refer [response redirect]]
           [chalk.views.authentication.login  :refer [view]]
           [chalk.services.auth               :refer [get-user-by-username-and-password]]
           [chalk.views.layout                :as    layout]))

(defn new-login [req]
  (layout/application "Login" (view)))

(defn login [{{username "username" password "password"} :form-params
               session :session :as req}]
  (if-let [user (get-user-by-username-and-password username password)]

    ; If authenticated
    (assoc (redirect "/")
           :session (assoc session :identity (:id user)))

    ; Otherwise
    (redirect "/login/")))

(defn logout [{session :session}]
  (assoc (redirect "/login/")
         :session (dissoc session :identity)))
