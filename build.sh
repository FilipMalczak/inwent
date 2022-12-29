#!/usr/bin/bash
source ./common.sh

function build_image() {
  local SUBDIR=$1
  echo "Building '$SUBDIR'"
  cd ./$SUBDIR
  ./gradlew bootBuildImage
  local STATUS=$?
  echo "Done"
  cd ..
  if [[ $STATUS -gt 0 ]]
  then
    echo "Build of '$SUBDIR' failed!"
    echo "Exiting with 1"
    exit 1
  else
    echo "Build of '$SUBDIR' successful"
  fi
}

build_image admin
build_image backend
cd ./admin
echo "ADMIN_IMAGE=docker.io/library/admin:$(./gradlew -q printVersion)" > ../.env
cd ../backend
echo "BACKEND_IMAGE=docker.io/library/backend:$(./gradlew -q printVersion)" >> ../.env
cd ..
