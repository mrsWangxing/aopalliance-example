#!/bin/bash

function trap_exit() {
    #test -f $$ && rm $$
    echo "exit"
}

set -e
trap "trap_exit" EXIT

which mvn
if [ $? -eq 0 ]; then
    mvn clean
fi

for x in $(find -type f \( -name \*.java -o -name \*.xml \))
do
    echo ${x}
    grep -v '^\s*$' ${x} > ${x}.$$
    mv ${x}.$$ ${x}
done
