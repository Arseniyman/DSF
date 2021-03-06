#!/bin/bash

# Run init scripts (credits go to MySQL Docker entrypoint script)

until curl mysqlcup:3306; do
  >&2 echo "MySQLcup is unavailable - sleeping"
  sleep 1
done

until curl mysqltea:3306; do
  >&2 echo "MySQLtea is unavailable - sleeping"
  sleep 1
done

for f in ${SCRIPT_DIR}/init_* ${SCRIPT_DIR}/init.d/*; do
      case "$f" in
        *.sh)  echo "[Entrypoint] running $f"; . "$f" ;;
        *)     echo "[Entrypoint] ignoring $f" ;;
      esac
      echo
done

exec ${SCRIPT_DIR}/startInForeground.sh

