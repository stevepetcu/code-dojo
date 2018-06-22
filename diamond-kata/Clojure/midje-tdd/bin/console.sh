#!/usr/bin/env bash

printf "Please enter a character: "
read character

lein run ${character}

exit 0
