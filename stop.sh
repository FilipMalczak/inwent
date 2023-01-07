#!/usr/bin/bash
source ./common.sh

$COMPOSE kill 
if [[ $($SIMPLE ps -aq | wc -l) -gt 0 ]]
then
    $SIMPLE rm -f $($SIMPLE ps -aq)
fi
