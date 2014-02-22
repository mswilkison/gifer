(ns gifer.routes.home
  (:use compojure.core)
  (:require [gifer.views.layout :as layout]
            [gifer.util :as util]))

(defn home-page []
  (layout/render "home.html"))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
