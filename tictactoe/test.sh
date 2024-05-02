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

echo "Compiling Model source files..."
# Compile the source files
javac -d $BIN_DIR -sourcepath $SRC_DIR $SRC_DIR/Model/*.java

echo "Compiling Model test files..."
# Include JUnit in the classpath for compilation
javac -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar" -d $BIN_DIR -sourcepath $TEST_DIR $TEST_DIR/Model/*.java

echo "Running Model tests..."
# Include JUnit in the classpath for running tests
java -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar" org.junit.runner.JUnitCore Model.GameModelTest


echo "Compiling VIew source files..."
# Compile the source files
javac -d $BIN_DIR -sourcepath $SRC_DIR $SRC_DIR/View/*.java

echo "Compiling  View test files..."
# Include JUnit in the classpath for compilation
javac -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar:$LIB_DIR/mockito-core-2.0.0.jar" -d $BIN_DIR -sourcepath $TEST_DIR $TEST_DIR/View/*.java

echo "Running View tests..."
# Include JUnit in the classpath for running tests
java -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar:$LIB_DIR/mockito-core-2.0.0.jar" org.junit.runner.JUnitCore View.GameViewTest




echo "Compiling Controller source files..."
# Compile the source files
javac -d $BIN_DIR -sourcepath $SRC_DIR $SRC_DIR/Controller/*.java

echo "Compiling Controller test files..."
# Include JUnit in the classpath for compilation
javac -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar" -d $BIN_DIR -sourcepath $TEST_DIR $TEST_DIR/Controller/*.java

echo "Running  Controller tests..."
# Include JUnit in the classpath for running tests
java -cp "$BIN_DIR:$LIB_DIR/junit-4.11.jar" org.junit.runner.JUnitCore Controller.GameControllerTest




echo "Build and test processes complete."

