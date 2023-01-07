#!/usr/bin/bash
set -ex

source ./common.sh

$COMPOSE up -d

if [[ ! -z "$1" ]]
then
    $COMPOSE logs -f backend
fi
