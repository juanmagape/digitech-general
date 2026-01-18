
#!/usr/bin/env bash
set -euo pipefail

CSS="styles.css"
grep -qi "border-collapse\s*:\s*collapse" "$CSS" && grep -qi "\.dades\s*th" "$CSS" && echo "✅ Estils de taula bàsics OK" && exit 0
echo "❌ Falta estil de taula: 'border-collapse: collapse' o selectores '.dades th'"
exit 1
