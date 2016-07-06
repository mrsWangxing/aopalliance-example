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

find -type f -name '*.java'       | xargs sed -i '/^\s*$/d'
find -type f -name '*.xml'        | xargs sed -i '/^\s*$/d'
#find -type f -name '*.properties' | xargs sed -i '/^\s*$/d'
#find -type f -name '*.jsp'        | xargs sed -i '/^\s*$/d'

#for x in $(find -type f \( -name \*.java -o -name \*.xml \))
#do
#    echo ${x}
#    grep -v '^\s*$' ${x} > /dev/null
#    if [ $? -ne 0 ]; then
#        grep -v '^\s*$' ${x} > ${x}.$$
#        mv ${x}.$$ ${x}
#    fi
#done