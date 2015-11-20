#!/bin/bash
# -*- script -*-
#
# Deliver Script
#

FINDMOON=$(L findmoon)
if [ -z "$FINDMOON" ]; then
    echo "Moonserver nicht gefunden. Abbruch!"
    exit 1
fi

WARFILE=$(L warfile)
if [ -z "$WARFILE" ]; then
    echo "Kein WAR File gefunden, nichts gebaut?"
    exit 1
fi

# NICE TO HAVE: L deliver $WARFILE to $FINDMOON with $USER

USER=langha_l
PATHNAME=/var/lib/tomcat-7-testing/webapps
SSH_OPT='-p 21007'

DEBUGGING=

$DEBUGGING ssh $SSH_OPT $USER@$FINDMOON "sudo /etc/init.d/tomcat-7-testing stop"
$DEBUGGING scp $SSH_OPT ${WARFILE} $USER@${FINDMOON}:$PATHNAME
$DEBUGGING ssh $SSH_OPT $USER@$FINDMOON "sudo /etc/init.d/tomcat-7-testing start"
