(ns chalk.services.auth
  (require [buddy.hashers :as hashers]))

(defn is-authenticated [{user :user :as req}]
  (not (nil? user)))

(defn uuid [] (java.util.UUID/randomUUID))

(defn create-user! [user]
  (let [password (:password user)
        user-id (uuid)]
    (-> user
        (assoc :id user-id :password-hash (hashers/encrypt password))
        (dissoc :password)
        (->> (swap! userstore assoc user-id)))))

(defn get-user [user-id]
  (get @userstore user-id))

(defn get-user-by-username-and-password [username password]
  (reduce (fn [_ user]
            (if (and (= (:username user) username)
                     (hashers/check password (:password-hash user)))
              (reduced user))) (vals @userstore)))

(defn wrap-user [handler]
  (fn [{user-id :identity :as req}]
    (handler (assoc req :user (get-user user-id)))))
