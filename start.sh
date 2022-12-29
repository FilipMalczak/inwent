#!/usr/bin/bash
source ./common.sh

$COMPOSE up -d

if [[ ! -z "$1" ]]
then
    $COMPOSE logs -f backend
fi
