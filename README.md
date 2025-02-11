# Tron Game

An implementation of the classic **Tron game**, where players control bikes (Light Cycles) that leave behind walls of light. The goal is to avoid collisions and force opponents to crash into walls, boundaries, or themselves.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Game Rules](#game-rules)
- [Project Architecture](#project-architecture)
- [Contributing](#contributing)
- [License](#license)

## Features
- 🏍️ **Human Player:** Control the bike using the arrow keys.
- 🤖 **AI (Clu):** Play against a smart AI that randomly chooses safe directions.
- 🕹️ **Grid:** The game takes place on a 50x50 grid.
- 🌈 **Simple Graphics:** Classic design using StdDraw for rendering.
- 🏆 **Win/Loss System:** The game ends when only one player is left standing.

## Prerequisites
- **Java 23+**
- `StdDraw` library for graphical rendering.

## Installation
1. Clone the repository:
``` bash
   git clone https://github.com/your-username/project-name.git
   cd project-name
```

1. Run the game:
``` bash
   java -cp lib/StdDraw.jar tron/*.java AppTron.java
```
## Usage
- **Human Player:**
    - Control your bike using the arrow keys:
        - Up: ↑
        - Down: ↓
        - Left: ←
        - Right: →

- **AI (Clu):** The computer controls Clu and randomly selects directions to find open paths.

When the game starts, the grid is initialized, and two players (a human and an AI) are added. The last player alive wins the game.

## Game Rules
1. Each player controls a bike that leaves a trail (wall) behind it as it moves.
2. A collision eliminates the player:
    - If a player collides with a wall (their own or the opponent's) or exits the grid, they are eliminated.

3. The game continues until only one player remains alive.
4. The last surviving player is declared the **winner!**

## Project Architecture
- `AppTron.java` : Main entry point of the game.
- **Core Classes:**
    - `Grid` : Manages the game grid, rendering, and collision detection.
    - `Player` : Abstract base class for all players.
    - `Human` : Human-controlled player using keyboard input.
    - `Clu` : AI-controlled player with random behavior.
    - `Bike` : Represents a bike and its movement logic.
    - `Wall` : Walls generated as a bike moves.
    - `Heading` : Enum defining movement directions (UP, DOWN, LEFT, RIGHT).
    - `Element` : Abstract class for spatial objects (walls, bikes).

- **External Libraries:**
    - `StdDraw` : A lightweight library for graphical rendering.

## Contributing

We welcome all contributions! Follow these steps to contribute:
1. Fork the repository.
2. Create a feature branch: `git checkout -b my-feature`.
3. Once your changes are ready, submit a pull request.

Please follow best coding practices (clean, well-documented code).

## License
This project is licensed under the **MIT License**. See the `LICENSE` file for more information.
