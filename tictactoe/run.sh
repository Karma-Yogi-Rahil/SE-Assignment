#!/bin/bash

# Define source and output directories
SRC_DIR="src"
OUT_DIR="out"

# Creating the output directory if it does not exist
mkdir -p $OUT_DIR

# Copy resources (config.properties) to the output directory
cp $SRC_DIR/config.properties $OUT_DIR/

# Compile the Java files
echo "Compiling Java source files..."
javac -d $OUT_DIR -sourcepath $SRC_DIR $SRC_DIR/*.java $SRC_DIR/*/*.java  # Adjusted for nested Java files if any

# Check if the compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
    # Run the main class
    echo "Running the application..."
    java -cp "$OUT_DIR" Main  # Adjust if Main is in a package
else
    echo "Compilation failed."
fi

