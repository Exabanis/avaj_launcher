#!/usr/bin/env bash
javac com/aircraft/*.java com/utilities/*.java com/simulator/*.java
java com.simulator.Simulator scenario.txt
echo "removing generated classes . . ."
rm -rf com/aircraft/*.class com/utilities/*.class com/simulator/*.class
echo "\nDone!"
open simulation.txt
