(ns gifer.util
  (:require [noir.session :as session]
            [ring.util.codec :refer [url-encode]]
            [noir.io :as io]
            [markdown.core :as md])
  (:import java.io.File))

(def galleries "galleries")

(defn gallery-path []
  (str galleries File/separator (session/get :user-id)))

(defn image-uri [userid file-name]
  (str "/img/" userid "/" (url-encode file-name)))

(defn md->html
  "reads a markdown file from public/md and returns an HTML string"
  [filename]
  (->>
    (io/slurp-resource filename)
    (md/md-to-html-string)))
