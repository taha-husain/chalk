(ns chalk.services.auth
  (require [buddy.hashers         :as     hashers]
           [chalk.entities.users  :refer  [get-user]]))

(defn is-authenticated [{user :user :as req}]
  (not (nil? user)))

(defn wrap-user [handler]
  (fn [{user-id :identity :as req}]
    (handler (assoc req :user (get-user user-id)))))
