#!/bin/sh

BASE_DIR=$(cd "$(dirname "$0")"; pwd)/
cd $BASE_DIR

APP_NAME=byname-dlnu
APP_ACTIVE=prod

function startApp()
{
	echo "trying start app $APP_NAME at [${BASE_DIR}]  ......................"

	JVM_PARAM="
        -server
        -Xmx512M
        -Xms512M
        -Xmn256M
        -XX:PermSize=128M
        -XX:MaxPermSize=256M
        -XX:GCTimeRatio=19
        -XX:+ClassUnloading 
        -XX:+UseConcMarkSweepGC
		-Xloggc:log/gc.log
		-Denv=DEV
	"

    nohup java -DGID=$BASE_DIR $JVM_PARAM -jar "$APP_NAME".jar --spring.profiles.active=$APP_ACTIVE > "$APP_NAME".log 2>&1 &

#	rm -rf "$APP_NAME".log

	echo "success start app $APP_NAME at [${BASE_DIR}] ......................"
}

function stopApp()
{
	echo "trying stop app $APP_NAME at [${BASE_DIR}] ......................"
	PID=$(ps -ef|grep $BASE_DIR|grep $APP_NAME|grep -v grep|grep -v kill|awk '{ print $2 }')
	if [ ${PID} ]; then
	    echo 'Stop Process...'
	    kill -15 $PID
	fi
	sleep 5
	
	PID=$(ps -ef|grep $BASE_DIR|grep $APP_NAME|grep -v grep|grep -v kill|awk '{ print $2 }')
	if [ ${PID} ]; then
	    echo 'Kill Process!'
	    kill -9 $PID
	else
	    echo 'Stop Success!'
	fi
	echo "success stop app $APP_NAME at [${BASE_DIR}] ......................"
}

function restartApp()
{
	stopApp
    sleep 1
	startApp
    exit
}

function displayHelp()
{
	echo '	'
    echo ' Please Attach a parameter when run this shell   '
    echo ' Parameters:'
    echo '      start  : Start Application in Service Mode(Log to File)'
    echo '      stop   : Stop The Application'
    echo '      restart: Restart The Application'
    echo '	'
}

case $1 in
	start)
		startApp
		;;
	stop)
		stopApp
		;;
	restart)
		restartApp
		;;
	*)
		displayHelp
		;;
esac
