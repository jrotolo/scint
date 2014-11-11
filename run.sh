#!/bin/bash
platform='unknown'
unamestr=`uname`

if [[ "$unamestr" == 'MINGW32_NT-6.1' ]]; then
	platform='windows'
elif [[ "$unamestr" == 'Linux' ]]; then
	platform='linux'
fi

if [[ "$platform" == 'unknown' ]]; then
	echo "Error can't detect os type"
	exit
elif [[ "$platform" == 'linux' ]]; then
	printf "Compiling program...\n"
	DIR="bin"
	if [ ! -d "$DIR" ]; then
	    mkdir bin
	fi
	javac -d bin -cp lib/spp.jar src/*.java

	printf "Running program...\n"
	java -cp bin:lib/spp.jar Main
elif [[ "$platform" == 'windows' ]]; then
	printf "Compiling program...\n"
	DIR="bin"
	if [[ ! -d "$DIR" ]]; then
		mkdir bin
	fi
	javac -d bin -cp lib/spp.jar src/*.java

	printf "Running program...\n"
	cd src
	java -cp ../bin:../lib Main
fi
