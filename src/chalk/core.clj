(ns chalk.core
  (require [compojure.core               :refer :all]
            [chalk.routes                 :refer [app-routes]]
            [chalk.services.auth          :refer [wrap-user]]
            [buddy.auth.backends.session  :refer [session-backend]]
            [buddy.auth.middleware        :refer [wrap-authentication wrap-authorization]]
            [ring.middleware.session      :refer [wrap-session]]
            [ring.middleware.params       :refer [wrap-params]]))

(def backend (session-backend))

(def app
 (-> app-routes
     (wrap-user)
     (wrap-authentication backend)
     (wrap-authorization backend)
     (wrap-session)
     (wrap-params)))
