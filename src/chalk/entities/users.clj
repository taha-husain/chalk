(ns chalk.entities.users
  (require [korma.core    :refer  :all]
           [chalk.db      :as     db]
           [buddy.hashers :as     hashers]))

(defentity users)

(defn create-user! [user]
  (let [password (:password user)
        username (:username user)]
    (insert users
      (values {:username username :password (hashers/encrypt password)}))))

(defn get-user-by-username-and-password
  [username password]
  (reduce (fn [_ user]
            (if (and (= (:username user) username)
                     (hashers/check password (:password-hash user)))
              (reduced user)))
          (select users)))

(defn get-user [id]
  (select users (where {:id id})))
