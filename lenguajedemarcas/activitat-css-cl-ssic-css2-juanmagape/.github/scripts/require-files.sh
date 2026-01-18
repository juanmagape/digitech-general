
#!/usr/bin/env bash
set -euo pipefail
for f in index.html styles.css q-css2.md AUTO.md; do
  if [[ ! -f "$f" ]]; then
    echo "❌ Falta el fitxer obligatori: $f"; exit 1
  fi
done
echo "✅ Fitxers obligatoris presents"
