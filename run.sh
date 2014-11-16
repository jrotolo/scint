#!/bin/bash
platform='unknown'
unamestr=`uname`
flag=$1

Compile_Program () {
	printf "Compiling program...\n"
	DIR="bin"
	if [ ! -d "$DIR" ]; then
	    mkdir bin
	fi
	javac -d bin -cp lib/spp.jar src/*.java	
}

if [[ "$unamestr" == 'MINGW32_NT-6.1' ]]; then
	platform='windows'
elif [[ "$unamestr" == 'Linux' ]]; then
	platform='linux'
fi

if [[ "$platform" == 'unknown' ]]; then
	echo "Error can't detect os type"
	exit
elif [[ "$platform" == 'linux' ]]; then
	clear

	Compile_Program

	printf "Running program...\n"
	if [[ $flag ]]; then
		java -cp ../bin:../lib Main < ../$flag
	else
		java -cp ../bin:../lib Main
	fi
elif [[ "$platform" == 'windows' ]]; then
	cls

	Compile_Program
	
	printf "Running program...\n"
	cd src
	if [[ $flag ]]; then
		java -cp ../bin:../lib/spp.jar Main < ../$flag
	else
		java -cp ../bin:../lib/spp.jar Main
	fi
fi
