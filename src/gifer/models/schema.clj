(ns gifer.models.schema)

(def db-spec (or (System/getenv "DATABASE_URL")
  {:subprotocol "postgresql"
   :subname "//localhost/gifer"
   :user "maclane"
   :password "itftennis"}))


