(ns babashka.impl.fs
  (:require [babashka.fs :as fs]
            [clojure.string :as str]
            [sci.core :as sci]))

(def fns (sci/create-ns 'babashka.fs nil))

(def current-file (fs/file (fs/absolutize (fs/path "src" *file*))))

(defn update-vars [_]
  (let [output (with-out-str (doseq [k (sort (keys (ns-publics 'babashka.fs)))]
                                 (println (str "   '" k) (format "(sci/copy-var fs/%s fns)" k))))
        this-file (slurp current-file)
        new-file (str/replace this-file #"(?m);; placeholder\n[\s\S]*;; end placeholder"
                              (str ";; placeholder\n" output "    ;; end placeholder"))]
    (spit current-file new-file)))

(def fs-namespace
  {;; placeholder
   'absolute? (sci/copy-var fs/absolute? fns)
   'absolutize (sci/copy-var fs/absolutize fns)
   'canonicalize (sci/copy-var fs/canonicalize fns)
   'components (sci/copy-var fs/components fns)
   'copy (sci/copy-var fs/copy fns)
   'copy-tree (sci/copy-var fs/copy-tree fns)
   'create-dir (sci/copy-var fs/create-dir fns)
   'create-dirs (sci/copy-var fs/create-dirs fns)
   'create-file (sci/copy-var fs/create-file fns)
   'create-link (sci/copy-var fs/create-link fns)
   'create-sym-link (sci/copy-var fs/create-sym-link fns)
   'create-temp-dir (sci/copy-var fs/create-temp-dir fns)
   'creation-time (sci/copy-var fs/creation-time fns)
   'delete (sci/copy-var fs/delete fns)
   'delete-if-exists (sci/copy-var fs/delete-if-exists fns)
   'delete-on-exit (sci/copy-var fs/delete-on-exit fns)
   'delete-tree (sci/copy-var fs/delete-tree fns)
   'directory? (sci/copy-var fs/directory? fns)
   'ends-with? (sci/copy-var fs/ends-with? fns)
   'exec-paths (sci/copy-var fs/exec-paths fns)
   'executable? (sci/copy-var fs/executable? fns)
   'exists? (sci/copy-var fs/exists? fns)
   'extension (sci/copy-var fs/extension fns)
   'file (sci/copy-var fs/file fns)
   'file-name (sci/copy-var fs/file-name fns)
   'file-separator (sci/copy-var fs/file-separator fns)
   'file-time->instant (sci/copy-var fs/file-time->instant fns)
   'file-time->millis (sci/copy-var fs/file-time->millis fns)
   'get-attribute (sci/copy-var fs/get-attribute fns)
   'glob (sci/copy-var fs/glob fns)
   'hidden? (sci/copy-var fs/hidden? fns)
   'instant->file-time (sci/copy-var fs/instant->file-time fns)
   'last-modified-time (sci/copy-var fs/last-modified-time fns)
   'list-dir (sci/copy-var fs/list-dir fns)
   'list-dirs (sci/copy-var fs/list-dirs fns)
   'millis->file-time (sci/copy-var fs/millis->file-time fns)
   'modified-since (sci/copy-var fs/modified-since fns)
   'move (sci/copy-var fs/move fns)
   'normalize (sci/copy-var fs/normalize fns)
   'parent (sci/copy-var fs/parent fns)
   'path (sci/copy-var fs/path fns)
   'path-separator (sci/copy-var fs/path-separator fns)
   'posix->str (sci/copy-var fs/posix->str fns)
   'posix-file-permissions (sci/copy-var fs/posix-file-permissions fns)
   'read-all-bytes (sci/copy-var fs/read-all-bytes fns)
   'read-all-lines (sci/copy-var fs/read-all-lines fns)
   'read-attributes (sci/copy-var fs/read-attributes fns)
   'readable? (sci/copy-var fs/readable? fns)
   'real-path (sci/copy-var fs/real-path fns)
   'regular-file? (sci/copy-var fs/regular-file? fns)
   'relative? (sci/copy-var fs/relative? fns)
   'relativize (sci/copy-var fs/relativize fns)
   'same-file? (sci/copy-var fs/same-file? fns)
   'set-attribute (sci/copy-var fs/set-attribute fns)
   'set-creation-time (sci/copy-var fs/set-creation-time fns)
   'set-last-modified-time (sci/copy-var fs/set-last-modified-time fns)
   'set-posix-file-permissions (sci/copy-var fs/set-posix-file-permissions fns)
   'size (sci/copy-var fs/size fns)
   'split-ext (sci/copy-var fs/split-ext fns)
   'split-paths (sci/copy-var fs/split-paths fns)
   'starts-with? (sci/copy-var fs/starts-with? fns)
   'str->posix (sci/copy-var fs/str->posix fns)
   'strip-ext (sci/copy-var fs/strip-ext fns)
   'sym-link? (sci/copy-var fs/sym-link? fns)
   'temp-dir (sci/copy-var fs/temp-dir fns)
   'walk-file-tree (sci/copy-var fs/walk-file-tree fns)
   'which (sci/copy-var fs/which fns)
   'writable? (sci/copy-var fs/writable? fns)
    ;; end placeholder
   })
