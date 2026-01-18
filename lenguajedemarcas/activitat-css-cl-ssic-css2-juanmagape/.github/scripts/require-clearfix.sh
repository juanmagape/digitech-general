
#!/usr/bin/env bash
set -euo pipefail

CSS="styles.css"
if grep -qi "\.clear\s*\{[^}]*clear\s*:\s*both" "$CSS" || grep -qi "#content\s*\{[^}]*overflow\s*:" "$CSS"; then
  echo "✅ Clearfix / conteniment de floats present"
  exit 0
fi
echo "❌ Falta 'clear: both' per a .clear o una solució de conteniment (overflow) a #content"
exit 1
