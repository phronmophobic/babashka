(ns babashka.impl.ffi
  {:no-doc true}
  (:require [com.phronemophobic.clj-libffi :as ffi]
            [tech.v3.datatype.ffi :as dt-ffi]
            [sci.impl.namespaces :refer [copy-var]]
            [sci.impl.vars :as vars]))

(def tns (vars/->SciNamespace 'babashka.ffi nil))

(def ffi-namespace
  {'load-library (copy-var ffi/load-library tns)
   'string->c (copy-var dt-ffi/string->c tns)
   'c->string (copy-var dt-ffi/c->string tns)
   'call (copy-var ffi/call tns)})
