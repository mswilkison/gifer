(ns gifer.routes.save
  (:use compojure.core)
  (:require [gifer.views.layout :as layout]
            [clojure.java.io :as io]
            [noir.session :as session]
            [noir.response :as resp]
            [noir.util.route :refer [restricted]]
            [gifer.util :as util]
            [gifer.models.db :as db]))

(defn handle-upload [outVideo effect])

(defroutes save-routes
  (POST "/save" [outVideo effect] (handle-upload outVideo effect)))
