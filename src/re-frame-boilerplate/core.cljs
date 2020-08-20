(ns re-frame-boilerplate.core
  (:require [reagent.dom]
            [re-frame.core :as rf]
            [clojure.string :as str]))

(rf/reg-event-db
 :initialize
 (fn [_ _]
   {:hello "World"}))

(defn ui
  []
  [:div
   [:h1 "Hello world, it is now"]])

(defn render
  []
  (reagent.dom/render [ui]
                      (js/document.getElementById "app")))

(defn ^:dev/after-load clear-cache-and-render!
  []
  (rf/clear-subscription-cache!)
  (render))

(defn run
  []
  (rf/dispatch-sync [:initialize])
  (render))
