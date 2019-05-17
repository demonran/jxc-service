#!/bin/bash
Jar_Path=$1
usage()
{
    echo "Usage: $0 <Jar_Path> {start|stop|restart}  "
    exit 1
}

start()
{
    java -jar $1 &
}
stop()
{
    ps -ef | grep $(Jar_Path) | grep -v grep | awk '{print $2}'|xargs kill -9
}
case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        start
        ;;
    *)
        usage
esac
