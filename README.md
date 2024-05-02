# SE Assignment


Project Structure:
|-- src/
|   |-- Main.java                 # Entry point of the application
|   |-- Config/
|   |   |-- ConfigLoader.java    # Loads configuration properties
|   |-- Controller/
|   |   |-- GameController.java
|   |-- Model/
|   |   |-- GameModel.java
|   |-- View/
|   |   |-- GameView.java
|   |-- config.properties        # Configuration file
|-- run.sh                        # Script to build and run the application
|-- README.md                     # Description of the project


## Building the Project
The project can be built and run using a simple bash script included in the repository. First, make sure the script is executable:

```sh
cd tictactoe
chmod +x run.sh
./run.sh

```

Test the project 
Tis will run all the test for Model , view, Controller
```sh
cd tictactoe
chmod +x test.sh
./test.sh

```
