#!/bin/bash
## usage:
##  run.sh  <class to run>  [arguments]

if [ -z "$1" ] ; then
    echo "usage : $0 <class to run>  [optional arguments]"
    exit
fi

# (optional) add any extra classpath here
extra_classpath=""
#classpath="target/*:target/dependency-jars/*:$extra_classpath"
classpath="target/thread-safety-labs-0.0.1-SNAPSHOT.jar:target/*:target/*:$extra_classpath"


java -cp "$classpath"  $*
