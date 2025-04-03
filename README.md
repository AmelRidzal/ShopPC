# projekat

Project37 is the solution to all youre apocaliptic problems. During an apocalypse youre main concearn is safty. Can you name anything safer then a tank. A machine made to take hits, and give them back twice as hard if not more. Get yours today at our online shop!!!

## Features

- An avest database and stock of military vehicles(mainly tanks)

- Ordering is as easy as clicking a button

- An admin panel where they can add, edit, or delete catalog items, users information as well as recites(wink wink), allowing them to manage the app's content and data. 


## Installation

Clone the repository and position yourself into its main directory. If you have GitHub installed on youre PC, you can do the following:

```bash
  git clone https://github.com/AM37AM37/projekat
  cd my-project
```


## Building
To run the standard GUI version of the app, do the following:
```bash
  mvn clean install
```
Or to run the CLI version:
```bash
  mvn clean install -P cli-app
```

## Usage
To run the compiled java files, navigate to the target folder with:
```bash
  cd target
```
Then run the following for the GUI version:
 ```bash
  java --module-path "\path\to\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml -jar
     FXproba-gui-jar-with-dependencies.jar
``` 
For the CLI version, do the following:
 ```bash
  java -jar FXproba-cli-jar-with-dependencies.jar -<parameters>
``` 


## Command Line Parameters
The following parameters can be used when running the program from the command line:
```bash
  -h
```
Description: Prints all available paramaters.

```bash
  -uu value1 
```

Description: Specifies the value for username paramater.

```bash
  -up value2
```

Description: Specifies the value for password paramater.

```bash
  -ue value3
```

Description: Specifies the value for email paramater.


```bash
  -ua -uu value1 -up value2 -ue value3 
```

Description: Adds a new user to the database depending on the specified parameters.

```bash
  -ud value1
```
Description: Deletes an new user from the database with the specified paramater being the users username.

```bash
  -ul 
```
Description: Lists all users from the database.


```bash
  -us value1 
```
Description: Searches for the User in the database and returns all of the information about him.

```bash
  -kn value1
```
Description: Specifies the value for catholog item name paramater.

```bash
  -kc value2
```
Description: Specifies the value for catholog item class paramater.

```bash 
  -kp value3
```
Description: Specifies the value for catholog item price paramater.

```bash
  -kdi value4
```
Description: Specifies the value for catholog item discription paramater.

```bash
  -kam value5
```
Description: Specifies the value for catholog item amount paramater.

```bash
  -ka -kn value1 -kc value2 -kp value3 -kdi value4 -kam value5 
```

Description: Adds a new catholog item to the database depending on the specified parameters.

```bash
  -kd value1
```
Description: Deletes a catholog item from the database with the specified paramater being the catholog items name.

```bash
  -kl 
```
Description: Lists the catholog from the database.

```bash
  -rl 
```
Description: Lists all recites from the database.

```bash
  -v 
```
Description: Prints current version of project.
## Running the tests
To run the tests, do the following:
```bash
  mvn test
```
Disclaimer: When running the JavaFX tests, you may encounter a failed test due to the fact that you may have multiple windows open. This is not a problem with the code, but rather with the test itself. If you encounter this, simply close all other windows and run the test again.


## Built With
- Intellij IDEA 
- Scene Builder
- MySQL Workbench

## Contact
Have any questions or feedback? Feel free to reach out to us at aridzal2@etf.unsa.ba <br>
We would love to hear from you and help you survive the apocalips! 

Thank you for choosing Project37 for ur apocalyptic needs. We're confident that you will love our products! 

