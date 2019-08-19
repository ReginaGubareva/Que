#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/que-1.0-SNAPSHOT.jar \
    #que@192.168.0.17:/home/tarsu/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa #que@192.168.0.17
 << EOF
pgrep java | xargs kill -9
nohup java -jar que-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'

