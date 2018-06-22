#!/usr/bin/env bash

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
		printf "This command will run all the tests under the midje_test.<namespace> namespace. \nPlease enter the namespace: "
		read namespace
		if [ -z ${namespace} ]
		then namespace="*"
		fi
		printf "Running tests under midje_tdd.${namespace} ...\n"
		lein with-profile dev midje midje_tdd.${namespace}
		;;
	*)
		printf "Test commands:\n"
		printf "\ttest: run all the tests.\n"
		printf "\tauto: run all the tests indefinitely; code changes will be\n"
		printf "\t      automatically detected and relevant tests run.\n"
		printf "\tns:   run all the tests under the \`midje_tdd.<namespace>\`.\n"
esac

exit 0
