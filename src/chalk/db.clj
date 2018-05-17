(ns chalk.db
  (:use [korma.db :refer [defdb postgres get-connection]])
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(defdb db (postgres {:host "localhost"
                     :db "chalk"
                     :user "postgres"
                     :password "postgres"
                     :port "5432"}))

(defn load-config
  []
  {:datastore  (jdbc/sql-database "jdbc:postgresql://postgres@localhost/chalk")
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))
