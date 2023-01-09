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

cd ./admin
ADMIN_IMAGE="docker.io/library/admin:$(./gradlew -q printVersion)"
cd ..
echo "Admin image: $ADMIN_IMAGE"
$SIMPLE inspect $ADMIN_IMAGE > /dev/null 2> /dev/null
# if "inspect" failed
if [ $? -gt 0 ]
then
  echo "Rebuilding Admin"
  build_image admin
else
  echo "Admin up to date"
fi
build_image inwent-service
pwd
echo "ADMIN_IMAGE=$ADMIN_IMAGE" > ./.env
cd ./inwent-service
echo "BACKEND_IMAGE=docker.io/library/inwent-service:$(./gradlew -q printVersion)" >> ../.env
cd ..
