
#!/usr/bin/env bash
set -euo pipefail

CSS="styles.css"
if grep -qi "#main" "$CSS" && grep -qi "#aside" "$CSS" && (grep -qi "float\s*:" "$CSS" || grep -qi "position\s*:" "$CSS"); then
  echo "✅ Maquetació clàssica detectada (#main/#aside + float/position)"
  exit 0
fi
echo "❌ No s'ha detectat maquetació clàssica amb floats/position (i selectors #main/#aside)"
exit 1
