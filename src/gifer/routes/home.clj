(ns gifer.routes.home
  (:use compojure.core)
  (:require [gifer.views.layout :as layout]
            [gifer.util :as util]
            [gifer.models.db :as db]))

(defn home-page []
  (layout/render "home.html"))

(defn about-page []
  (layout/render "about.html"))

(defn all-page []
  (layout/render
   "gallery.html"
   {:gifs (db/get-all-gifs)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/all" [] (all-page)))
