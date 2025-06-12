# Algo visualizer

## Summary 
- [About](#About)
- [Features](#Features)
- [Build](#Build)
    - [Depedencies](#Depedencies)
- [Contribute](#Contribute)
- [Report Bug](#Issue)

## About

This software is made for educational purpose. The software allow a user to visualize how a given algorithm actually work. Using visual feedback, the software will descend step by step the code of an algorithm and show what's happening to the data. It will also contain further information like Space and Time complexity, algorithm history, different implementation in different language, and a resumee of how the algo work. The project docs is available at https://yewspine.github.io/Algo-Visualizer/com.visualizer/module-summary.html

## Features

*Up coming*

## Build

### Depedencies

|Depedencie  |Version |
|:----------:|:------:|
|Maven       |3.8.7   |
|JDK         |22      |
|JavaFX      |24      |
|Reflection  |0.10.2  |

To compile run the following : 

1. Run clean test if you want to be sure everything works 

```bash 
mvn clean test
```

2. Create the launcher 

```bash
mvn clean javafx:jlink
```

3. Copy the target folder with your binaries

```bash
cp -r target/visualizer /path/to/to/your/binaries
```

4. Execute the file

Execute the file `visualizer` found at : `visualizer/bin/visualizer`

## Contribute

You want to contribute ? Awesome ! This process is quite simple 

Clone the repo: 

```bash
git clone https://github.com/Yewspine/Algo-Visualizer.git
```
Or if you're using ssh: 

```bash
git clone git@github.com:Yewspine/Algo-Visualizer.git
```

create a new branch for your new feature: 

```bash
git branch <Feature name>
```
Do some commit following the [conventionnal commit](https://www.conventionalcommits.org/en/v1.0.0/) specification and then push to open a new PR: 

```bash
git push
```

## Adding an Algorithm.

In case you want to add an algorithm. Create a new Branch makes sure to know the algorithm and implement it with the most simple approach possible.
One liner are strictly prohibited, it must be equivalent to it pseudo-code as much as possible. Then put the java code defining it into it's own category ( e,g Pathfinding, Sort, Search, etc... ).
the script itself is stored in txt under `ressources/script` folder under the convention : "<Algo-name>/<language-extension>.txt" { e.g BubbleSort/py.txt )

## Issue

If you encounter a bug, please report it using the Issue tab on github and create a new Issue, I will review it when I would have time

## Note 

If you have an idea for the name of the application, feel free to tell it, because Calling it " Visualizer " can be frustrating
