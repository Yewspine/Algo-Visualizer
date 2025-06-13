# Algo Visualizer

## Table of Contents

* [About](#about)
* [Features](#features)
* [Build Instructions](#build-instructions)
  * [Dependencies](#dependencies)
* [Contributing](#contributing)
* [Adding an Algorithm](#adding-an-algorithm)
* [Reporting Issues](#reporting-issues)
* [Notes](#notes)

---

## About

**Algo Visualizer** is an educational tool designed to help students or curious understand how does algorithms work. It provides step-by-step visualizations of algorithm executions, allowing users to observe how data evolves over time.

The application will also includes supplementary information such as:

* Time and space complexity
* Algorithm origin and history
* Implementations in different programming languages
* A concise summary of how the algorithm operates

Code Documentation is available here:
[https://yewspine.github.io/Algo-Visualizer/com.visualizer/module-summary.html](https://yewspine.github.io/Algo-Visualizer/com.visualizer/module-summary.html)

---

## Features

*Coming soon.*

---

## Build Instructions

### Dependencies

| Dependency | Version |
| ---------- | ------- |
| Maven      | 3.8.7   |
| JDK        | 22      |
| JavaFX     | 24      |
| Reflection | 0.10.2  |

### Steps to Build

1. **Run tests (optional but recommended):**

```bash
  mvn clean test
```

2. **Package the application:**

```bash
  mvn clean package
```

3. **Build the application with JavaFX support:**

```bash
  mvn clean javafx:jlink
```

4. **Copy the build artifacts:**

```bash
  cp -r target/visualizer /path/to/your/binaries
```

5. **Run the application:**

Execute the file located at: `visualizer/bin/visualizer`

---

## Contributing

Contributions are welcome!

To get started:

1. Clone the repository:

```bash
  git clone https://github.com/Yewspine/Algo-Visualizer.git
```

2. Create a new branch:

```bash
  git checkout -b <feature-name>
```

3. Follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification for your commit messages.

4. Push your branch and open a pull request:

```bash
  git push origin <feature-name>
```

---

## Adding an Algorithm

To implement a new algorithm:

1. Create a dedicated branch.
2. Use a straightforward and educational implementation, one liners are prohibited.
3. Ensure the code closely follows the standard pseudocode logic.
4. Place the Java source code into the relevant category (e.g., `Pathfinding`, `Sort`, `Search`, etc.).
5. Add a script version of the algorithm in the `resources/script` directory, using the naming format:
   `<AlgorithmName>/<language-extension>.txt`
   *Example:* `BubbleSort/py.txt`

NOTA: Do not forget to `mvn clean package` every time you add something new in resources folder. It might not get added to classPath either way

---

## Reporting Issues

If you find a bug or issue, please submit it via the [GitHub Issues](https://github.com/Yewspine/Algo-Visualizer/issues) page.
Bugs will be reviewed as soon as possible.

---

## Notes

Have a better name idea for this application?
“Visualizer” is just a placeholder, so feel free to open an issue if you have something better.

