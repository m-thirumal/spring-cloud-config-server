#! /bin/bash
#title           :Spring-cloud-config-server.sh
#description     :This script will make a header for a bash script.
#author		     :Thirumal(m.thirumal@hotmail.com)
#date            :29/07/2021
#version         :0.1
#usage		     :./spring-cloud-config-server.sh 2 in LINUX & sh spring-cloud-config-server.sh 2 in MAC OS
#notes           :Install Vim

echo "Git Pull"
git pull
echo "Git pull successful"
echo "Start/build jar using mvn"
mvn install
appName="spring-cloud-config-server-1.0.0-SNAPSHOT.jar"
echo "Killing existing instances" $appName
pkill -f $appName
echo "Starting spring-cloud-config-server application from jar"
count=1
if [ $# -gt 0 ] 
then
    count=$1
fi
echo "Total number of instance to start" $count
for i in $(seq 1 $count);
do
 echo "Starting instance " $i " of " $count;
 nohup java -jar target/$appName >& /dev/null &
done
