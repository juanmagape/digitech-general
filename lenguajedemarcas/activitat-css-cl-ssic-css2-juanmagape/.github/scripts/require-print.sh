
#!/usr/bin/env bash
set -euo pipefail

grep -qi "@media\s+print" styles.css && echo "✅ @media print present" && exit 0
echo "❌ Falta bloc @media print a styles.css"
exit 1
