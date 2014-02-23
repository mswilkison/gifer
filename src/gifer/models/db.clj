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

(defn add-gif [id gname]
  (transaction
    (if (empty? (select images
                        (where {:id id :gname gname})
                        (limit 1)))
      (insert images (values {:id id :gname gname}))
      (throw
        (Exception. "you have already uploaded this image")))))
