#!/usr/bin/bash
#set -ex

source ./common.sh

$COMPOSE up -d

if [[ ! -z "$1" ]]
then
    echo "Lets let everything to go up; waiting for 5s before following logs"
    sleep 5
    echo "Done wait, lets see now"
    $COMPOSE logs -f $1
fi
