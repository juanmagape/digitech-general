
#!/usr/bin/env bash
set -euo pipefail

CSS="styles.css"
grep -qi "a:link" "$CSS" && grep -qi "a:visited" "$CSS" && grep -qi "a:hover" "$CSS" && grep -qi "a:active" "$CSS" && echo "✅ LVHA present" && exit 0
echo "❌ Falta algun estat d'enllaç (a:link, a:visited, a:hover, a:active) a styles.css"
exit 1
