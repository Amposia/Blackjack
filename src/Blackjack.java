/* Co-developed by Sourish Brahma and Mohamed Gaballah */

import java.util.Scanner;

public class Blackjack
{
  public static void main(String[] args)
  {
    Scanner userInput = new Scanner(System.in); // Create a Scanner object to read user input
    Deck gameDeck = new Deck(); // Create a new deck of cards for the game

    System.out.println("Welcome to Blackjack!");
    System.out.println("The goal of the game is to get as close to 21 points as possible without going over");
    System.out.println("The player with the highest points wins!");
    System.out.println("If a player goes over 21 points, they are 'busted' and lose the game");
    System.out.println("If both players have the same amount of points, neither player wins");
    System.out.println();

    System.out.println("The worth of the cards are as follows:");
    System.out.println("Ace: 1 or 11 points");
    System.out.println("2-10: Face value");
    System.out.println("Jack, Queen, King: 10 points");
    System.out.println();
    
    System.out.println("Let's start the game!");
    System.out.println();
  
    System.out.println("Player 1, please enter your name: ");
    Hand player1 = new Hand(userInput.nextLine());

    System.out.println();

    System.out.println("Player 2, please enter your name: ");
    Hand player2 = new Hand(userInput.nextLine());
    System.out.println();

    Hand[] players = {
      player1, player2
    };

    boolean endgame = false; // Variable to track if the game has ended
    boolean player1Stuck = false; // Variable to track if player 1 has chosen to stick
    boolean player2Stuck = false; // Variable to track if player 2 has chosen to stick

    for (Hand player : players) // Draw a card for each player
    {
      System.out.println((player.getPlayerName()) + " drawing a card");
      Card cardDrawn = gameDeck.drawCard();

      System.out.println((player.getPlayerName()) + " drew " +cardDrawn);
      player.getCards().add(cardDrawn); // Add the drawn card to the player's hand
      player.calculatePoints();

      System.out.println();
    }

    int playerTurn = 0; // Variable to track which player's turn it is (0 for player 1, 1 for player 2)
    while (!endgame) // While the game has not ended, continue the game loop
    {
      if (player1Stuck && player2Stuck) // If both players have stuck, determine the winner based on their points
      {
        System.out.println(player1.getPlayerName() + " got " + player1.getPoints());
        System.out.println(player2.getPlayerName() + " got " + player2.getPoints()); 

        if (player1.getPoints() > player2.getPoints())
        {
          System.out.println(player1.getPlayerName() + " won!");
        }
        else if (player2.getPoints() > player1.getPoints())
        {
          System.out.println(player2.getPlayerName() + " won!");
        }
        else
        {
          System.out.println("Neither player wins, both have the same amount of points!");
        }
        endgame = true;
      }

      else if (player1Stuck && playerTurn == 0) // If it's player 1 who stuck, switch to player 2
      {
        playerTurn++;
      }
      else if (player2Stuck && playerTurn == 1) // If it's player 2 who stuck, switch to player 1
      {
        playerTurn--;
      }

      else // If neither player has stuck, continue the game loop
      {
        System.out.println(players[playerTurn].getPlayerName() + "'s turn"); // Display the current player's turn
        System.out.println("Your cards are: " + players[playerTurn].getCards()); // Display the current player's cards

        System.out.println("Stick or Twist?");
        String option = userInput.nextLine();

        while (!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"))
        {
          System.out.println("Please enter either 'Stick' or 'Twist'"); // Prompt the player to enter a valid option if they entered an invalid one
          option = userInput.nextLine();
        }

        if (option.equalsIgnoreCase("Twist")) // If the player chooses to twist, draw a card from the deck and add it to their hand
        {
          Card newCard = players[playerTurn].twist(gameDeck);
          System.out.println("Card drawn: " + newCard);
          
          System.out.println("Your cards are: " + players[playerTurn].getCards());
          players[playerTurn].calculatePoints();

          System.out.println();

          // Bust logic
          if (players[playerTurn].getPoints() > 21) // If the current player's points exceed 21, they are busted and lose the game
          {
            System.out.println("Sorry! You're busted!");
            System.out.println();
            endgame = true;
            
            System.out.println(players[0].getPlayerName() + " got " + players[0].getPoints());
            System.out.println(players[1].getPlayerName() + " got " + players[1].getPoints()); 
            System.out.println();

            if (playerTurn == 0) // If player 1 is busted, player 2 wins
            {
              System.out.println(player2.getPlayerName() + " won!");
            }
            else // If player 2 is busted, player 1 wins
            {
              System.out.println(player1.getPlayerName() + " won!");
            }
          }
        }

        else if (option.equalsIgnoreCase("Stick")) // If they choose stick, switch to the other player's turn 
        {
          System.out.println("You will receive no more cards");
          System.out.println();
          
          if (playerTurn == 0) // If it's player 1's turn, set player 1 as stuck
            {
              player1Stuck = true;
            }
          else // If it's player 2's turn, set player 2 as stuck
            {
              player2Stuck = true;
            }
        }

        if (playerTurn == 0) // If it's player 1's turn, switch to player 2's turn
        {
          playerTurn++;
        }
        else // If it's player 2's turn, switch to player 1's turn
        {
          playerTurn--;
        }
      }
    }
  }
}