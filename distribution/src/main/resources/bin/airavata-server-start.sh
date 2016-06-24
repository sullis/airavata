#!/usr/bin/env bash

# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements. See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership. The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License. You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied. See the License for the
# specific language governing permissions and limitations
# under the License.

. `dirname $0`/setenv.sh
cd ${AIRAVATA_HOME}/bin
LOGO_FILE="logo.txt"

JAVA_OPTS=""
AIRAVATA_COMMAND=""
EXTRA_ARGS=""
SERVERS=""
IS_DAEMON_MODE=false
LOGO=true
ALL_IN_ONE=false

# parse command arguments
for var in "$@"
do
    case ${var} in
        -xdebug)
        	AIRAVATA_COMMAND="${AIRAVATA_COMMAND}"
            JAVA_OPTS="$JAVA_OPTS -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,address=8000"
            shift
        ;;
        -security)
            JAVA_OPTS="${JAVA_OPTS} -Djava.security.manager -Djava.security.policy=${AIRAVATA_HOME}/conf/axis2.policy -Daxis2.home=${AIRAVATA_HOME}"
            shift
        ;;
	    apiserver | gfac | orchestrator)
	        if [ -z ${SERVERS} ] ; then
	            SERVERS="${var}"
	        else
	            SERVERS="${SERVERS},${var}"
	        fi
            shift
        ;;
        all)
            ALL_IN_ONE=true
            shift
            ;;
        -d)
	        IS_DAEMON_MODE=true
	        shift
	        ;;
	    -nologo)
	        LOGO=false
            shift
        ;;
        -h)
            echo "Usage: airavata-server-start.sh [server-name/s] [command-options]"
            echo "Server names:"
            echo "  apiserver           Start apiserver"
            echo "  gfac                Start gfac server"
            echo "  orchestrator        Start orchestrator server"
            echo "  credentialstore     Start credentialstore server"
            echo "  all                 Start all servers in one JVM"

            echo "command options:"
	        echo "  -d                  Start server in daemon mode"
            echo "  -xdebug             Start Airavata Server under JPDA debugger"
            echo "  -nologo             Do not show airavata logo"
            echo "  -security           Enable Java 2 security"
	        echo "  --<key>[=<value>]   Server setting(s) to override or introduce (overrides values in airavata-server.properties)"
            echo "  -h                  Display this help and exit"
            shift
            exit 0
        ;;
	    *)
	        EXTRA_ARGS="${EXTRA_ARGS} ${var}"
            shift
        ;;
    esac
done

#Construct Airavata command arguments in proper order.
if ${ALL_IN_ONE} ; then
    AIRAVATA_COMMAND="--servers=all ${AIRAVATA_COMMAND} ${EXTRA_ARGS}"
else
    AIRAVATA_COMMAND="--servers=${SERVERS} ${AIRAVATA_COMMAND} ${EXTRA_ARGS}"
fi

#print logo file
if ${LOGO} ; then
	if [ -e ${LOGO_FILE} ]
	then
		cat ${LOGO_FILE}
	fi
fi


if ${IS_DAEMON_MODE} ; then
	echo "Starting airavata server/s in daemon mode..."
	nohup java ${JAVA_OPTS} -classpath "${AIRAVATA_CLASSPATH}" \
    org.apache.airavata.server.ServerMain ${AIRAVATA_COMMAND} $* > /dev/null 2>&1 &
else
	java ${JAVA_OPTS} -classpath "${AIRAVATA_CLASSPATH}" \
    org.apache.airavata.server.ServerMain ${AIRAVATA_COMMAND} $*
fi

