(ns gifer.routes.save
  (:use compojure.core)
  (:require [gifer.views.layout :as layout]
            [clojure.java.io :as io]
            [ring.util.codec :refer [base64-decode]]
            [noir.io :refer [upload-file]]
            [noir.session :as session]
            [noir.response :as resp]
            [noir.util.route :refer [restricted]]
            [gifer.util :refer [gallery-path]]
            [gifer.models.db :as db]))

(defn handle-upload [blob effect]
  (resp/redirect "/"))

(defroutes save-routes
  (POST "/save" [blob effect] (handle-upload blob effect)))
