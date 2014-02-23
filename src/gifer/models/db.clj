(ns gifer.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [gifer.models.schema :as schema]))

(defdb db schema/db-spec)

(defentity users)
(defentity gifs)

(defn create-user [user]
  (insert users
          (values user)))

(defn update-user [id first-name last-name email]
  (update users
  (set-fields {:first_name first-name
               :last_name last-name
               :email email})
  (where {:id id})))

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))

(defn add-gif [id b64string effect]
  (insert gifs (values {:id id :b64string b64string :effect effect})))

(defn gifs-by-user [id]
  (select gifs
          (where {:id id})))

(defn get-all-gifs []
  (select gifs
          (limit 30)))
