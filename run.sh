#!/bin/bash

echo "Compiling program..."
DIR="bin"
if [ ! -d "$DIR" ]; then
    mkdir bin
fi
javac -d bin -cp lib/csc4101.jar src/*.java

echo "Running program..."
java -cp bin:lib/csc4101.jar Main
