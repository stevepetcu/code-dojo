#!/usr/bin/env bash

printf "Starting tests... This may take a minute.\n"

case $1 in
	test)
		printf "Simple test run.\n"
		lein with-profile dev midje
		;;
	auto)
		printf "Auto-test run. \n"
		lein with-profile dev midje :autotest
		;;
	ns)
		printf "Please enter the namespace: "
		read namespace
		printf "Running tests under ${namespace}...\n"
		lein midje ${namespace}.*
		;;
	*)
		printf "Unexpected input.\n"
		exit 1
esac

exit 0
