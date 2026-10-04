# Blackjack Game - Java
A console-based Blackjack game co-developed using Java. The project was created as part of a university programming module and focuses on applying object-oriented programming concepts to a playable card game.

## Features
- Two-player console-based Blackjack game
- Stick or Twist gameplay
- Blackjack scoring with Aces dynamically counted as 1 or 11
- Bust detection and winner determination

## Technologies
- Java
- Object-Oriented programming

## How It Works
The game creates and shuffles a standard 52-card deck before dealing an initial card to each player.

Players take turns choosing between:
- **Twist**: draw another card and recalculate the hand's score.
- **Stick**: stop drawing cards and allow the other player to continue.

The game ends when both player stick (the player closest to 21 points wins, or no-one wins if there is a tie) or a player busts (then the other player wins).

### Ace handling
Aces have a base value of 1. When calculating a hand's score, the program checks whether an Ace can instead contribute an additional 10 points without taking the hand above 21. This allows an Ace to effectively count as either 1 or 11 without changing the card object's stored value.

## Collaboration
This project was co-developed with Sourish Brahma (Sikronic) using a paired-programming approach. Both developers worked together on the implementation, debugging, testing, and improvement of the game.

## Project Structure
- Card: Represents an individual playing card, including its suit, name, and base value.
- Deck: Creates, stores, shuffles, and draws cards from the deck.
- Hand: Stores a player's cards and calculates their points.
- Blackjack: Controls the game flow, player turns, input, and win/loss conditions.

## Running the Project
1. Clone the repository
2. Open the project in a Java-compatible IDE such as Visual Studio Code.
3. Run _Blackjack.java_.
4. Follow the instructions displayed in the console.
