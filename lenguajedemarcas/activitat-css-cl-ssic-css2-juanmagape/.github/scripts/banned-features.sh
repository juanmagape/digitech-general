
#!/usr/bin/env bash
set -euo pipefail
shopt -s globstar

FILES=(**/*.css)
PATTERNS=("display\s*:\s*flex" "grid-template" "grid\s*:" "var\(" ":\s*is\(" ":\s*where\(" ":\s*has\(" "nth-child" "@container" "container-type" "container-name" "layer\s*:" "^\s*--[a-zA-Z-]+")
FAIL=0

for css in "${FILES[@]}"; do
  [[ -f "$css" ]] || continue
  while IFS= read -r pat; do :; done < /dev/null
  for pat in "${PATTERNS[@]}"; do
    if grep -P -n -i -- "$pat" "$css" >/dev/null 2>&1; then
      echo "❌ Prohibit al CSS modern trobat a $css → patró: $pat"
      FAIL=1
    fi
  done
done

if [[ $FAIL -eq 1 ]]; then
  echo "Regles modernes detectades (Flex/Grid/vars/pseudo avançats...). Activitat exigeix CSS2 clàssic."
  exit 1
else
  echo "✅ Cap característica moderna prohibida detectada."
fi
