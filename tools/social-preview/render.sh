#!/usr/bin/env bash
# Erzeugt aus cards.tsv je eine Karte nach cards/.
set -euo pipefail
cd "$(dirname "$0")"
javac --release 21 -d . SocialPreview.java
mkdir -p cards
while IFS=$'\t' read -r name subtitle footnote; do
  case "$name" in ''|'#'*) continue ;; esac
  java -cp . SocialPreview "cards/$name.png" "$name" "$subtitle" "$footnote"
done < cards.tsv
