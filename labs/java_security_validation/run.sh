#!/bin/bash
## usage:
## run.sh <class to run> [arguments]

if [ -z "$1" ] ; then
echo "usage : $0 <class to run> [arguments boiler id and temperature]"
exit
fi

native="/home/aberami/Documents/java_security_validation/native"
# (optional) add any extra classpath here
classpath="target/security.jar"

java -Djava.library.path=$native -cp $classpath $*

