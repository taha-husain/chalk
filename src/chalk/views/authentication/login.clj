(ns chalk.views.authentication.login
  (:require [hiccup.form :refer [text-field label password-field form-to submit-button]]))

(defn view []
  [:div {:class "well"}
    [:h1 {:class "text-info"} "Hello Chalk"]
    (form-to [:post "/login"]
      [:div {:class "row"}
        [:div {:class "col-lg-2"}
         (label "username" "Username")]
        [:div {:class "col-lg-4"}
         (text-field {:class "form-control" :placeholder "Enter username here"} "username")]
      ]
      [:div {:class "row"}
        [:div {:class "col-lg-2"}
         (label "password" "Password")]
        [:div {:class "col-lg-4"}
         (password-field {:class "form-control" :placeholder "Enter password here"} "password")]
      ]
      [:div {:class "col-lg-4"}
       (submit-button {:class "form-control"} "Login")]
     )
   [:hr]])
