(ns boilerplate.core
  (:require [goog.events :as events]
            [reagent.dom]
            [re-frame.core :as rf]
            [clojure.string :as str]
            [devtools.core :as devtools])
  (:import [goog History]
           [goog.history EventType]))

;; -- Debugging aids ----------------------------------------------------------
(devtools/install!)       ;; we love https://github.com/binaryage/cljs-devtools
(enable-console-print!)   ;; so that println writes to `console.log`


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
