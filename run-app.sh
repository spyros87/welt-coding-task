#!/bin/bash

mvn clean package

rc=$?
if [ $rc -ne 0 ]; then
    echo 'Maven Execution failure'; exit ${rc}
fi

clear

mvn exec:java
