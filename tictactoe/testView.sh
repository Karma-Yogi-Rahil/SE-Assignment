#!/bin/bash

# Define the directory variables
SRC_DIR="src"
TEST_DIR="test"
LIB_DIR="lib"
BIN_DIR="bin"
CONFIG_FILE="config.properties" # Define the config file name

# Ensure the bin directory exists
mkdir -p $BIN_DIR

# Copy resources (config.properties) to the output directory
echo "Copying configuration file..."
cp $SRC_DIR/$CONFIG_FILE $BIN_DIR/

echo "Compiling source files..."
# Compile the source files
javac -d $BIN_DIR -sourcepath $SRC_DIR $SRC_DIR/View/*.java

echo "Compiling test files..."
# Include JUnit in the classpath for compilation
javac -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar:$LIB_DIR/mockito-core-2.0.0.jar" -d $BIN_DIR -sourcepath $TEST_DIR $TEST_DIR/View/*.java

echo "Running tests..."
# Include JUnit in the classpath for running tests
java -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar:$LIB_DIR/mockito-core-2.0.0.jar" org.junit.runner.JUnitCore View.GameViewTest

echo "Build and test processes complete."
