#DO NOT RUN
#
# INCLUDE VIA source INSTEAD

set -ex

# this is hack for my machine; shouldn't matter on yours ~Filip
newgrp docker &


which_exit_code () {
  which $1 > /dev/null 2> /dev/null
  local RESULT=$?
  echo $RESULT
  return $RESULT
}

SIMPLE=$1

if [[ -z "$SIMPLE" ]]
then
  echo "Trying to figure out docker variant"
  if [[ $(which_exit_code docker) -eq 0 ]]
  then
    SIMPLE=docker
    if [[ $(which_exit_code nerdctl) -eq 0 ]]
    then
      echo "Both nerdctl and docker are available!"
      echo "Provide docker variant as the first parameter to this script."
      echo "Exiting with 1"
      exit 1
    fi
  else
    if [[ $(which_exit_code nerdctl) -eq 0 ]]
    then
      # we know that docker isnt there, so no need to check
      SIMPLE=nerdctl
    else
      echo "Neither nerdctl nor docker is available!"
      echo "Provide docker variant as the first parameter to this script."
      echo "Exiting with 1"
      exit 1
    fi
  fi
else
  echo "Docker variant given explicitly"
fi

COMPOSE=$2
if [[ -z "$COMPOSE" ]]
then
  echo "Trying to figure out Docker Compose variant"
  if [[ "$SIMPLE" -eq "docker" ]]
  then
    if [ $(which_exit_code "docker-compose") -gt 0 ]
    then
      echo "Docker variant is set to docker, but docker-compose is not available!"
      echo "Install necessary software and retry."
      echo "Exiting with 1"
      exit 1
    else
      COMPOSE="docker-compose"
    fi
  else
      # we are sure that if simple!=docker, then simple=nerdctl
      # nerdctl variant has no dash, so we are sorta sure that it is available
      COMPOSE="nerdctl compose"
  fi
else
  echo "Docker Compose variant given explicitly"
  echo "Look out! This script cannot compose compability of Docker and Docker Compose variants!"
fi

echo "Docker variant: $SIMPLE"
echo "Docker Compose variant: $COMPOSE"
