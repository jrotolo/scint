#!/bin/bash

echo "Compiling program..."
DIR="bin"
if [ ! -d "$DIR" ]; then
    mkdir bin
fi
javac -d bin -cp lib/spp.jar src/*.java

echo "Running program..."
java -cp bin:lib/spp.jar Main
