#!/bin/bash
# Compile the Java source files
javac -d out -sourcepath src src/Main.java

# Create resources directory in out if it does not exist
mkdir -p out/resources

# Copy the config.properties file
cp src/resources/config.properties out/resources/config.properties

echo "Build and resource copy completed successfully."
