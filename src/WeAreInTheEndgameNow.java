import java.util.*;
/* Sourish Brahma - K2504417
   Mohamed Gaballah - K2548027 */
public class WeAreInTheEndgameNow
{
  public static void main(String[] args)
  {
    Deck paulsDeckOfCards = new Deck();
    Scanner input = new Scanner(System.in);
    Hand p1 = new Hand("Player1");
    Hand p2 = new Hand("Player2");
    Hand[] players = {
      p1, p2
    };
    boolean endgame = false;
    boolean player1Stuck = false;
    boolean player2Stuck = false;

    // Draw a card for each player
    for (int i = 0; i <= 1; i++)
    {
      System.out.println("Player " + (i+1) + " drawing card");
      Card currentCard = paulsDeckOfCards.drawCard();
      System.out.println("Player "+ (i+1) + " drew " +currentCard);
      players[i].getCards().add(currentCard);
    }

    // Add an empty line to make it more clear
    System.out.print("\n");

    // Each player takes turns
    int index = 0;
    while (endgame == false)
    {
      if (player1Stuck == true && player2Stuck == true) // If both stick
      {
        System.out.println("Player 1 got " + players[0].getPoints());
        System.out.println("Player 2 got " + players[1].getPoints()); 
        if(players[0].getPoints() < players[1].getPoints())
        {
          System.out.println("Player 2 won!");
        }
        else if (players[0].getPoints() == players[1].getPoints())
        {
          System.out.println("Neither player wins, both have the same amount of points!");
        }
        else 
        {
          System.out.println("Player 1 won!");
        }
        endgame = true; //End game
      }
      else if (player1Stuck == true && players[index].getPlayerName().equalsIgnoreCase("Player1")) // If it's player 1 who stuck, switch to player 2
      {
        index++;
      }
      else if (player2Stuck == true && players[index].getPlayerName().equalsIgnoreCase("Player2")) // If it's player 2 who stuck, switch to player 1
      {
        index--;
      }
      else
      {
        players[index].calculatePoints(); 
        System.out.println("Player " + (index+1) + "'s turn");
        System.out.println("Your cards are: " + players[index].getCards());

        System.out.println("Stick or Twist?");
        String option = input.nextLine();

        while (!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"))
        {
          System.out.println("Please enter either 'Stick' or 'Twist'");
          option = input.nextLine();
        }

        if (option.equalsIgnoreCase("Twist"))
        {
          Card newCard = players[index].twist(paulsDeckOfCards);
          System.out.println("Card drawn: " + newCard);
          players[index].getCards().add(newCard);
          System.out.println("Your cards are: " + players[index].getCards());
          System.out.println();

          players[index].calculatePoints();
          int tempPointOnPlayerStorage = players[index].getPoints();
          for (Card card : players[index].getCards())
          {
            if (card.getWorth() == 1 && (tempPointOnPlayerStorage + 10 <= 21))
            {
              card.setWorth(11);
            }
            else if (card.getWorth() == 11 && (tempPointOnPlayerStorage > 21))
            {
              card.setWorth(1);
            }
            players[index].calculatePoints();
            tempPointOnPlayerStorage = players[index].getPoints();
          }

          if (tempPointOnPlayerStorage > 21) //Bust logic
          {
            System.out.println("Sorry! You're busted!");
            System.out.println();
            endgame = true;
            
            System.out.println("Player 1 got " + players[0].getPoints());
            System.out.println("Player 2 got " + players[1].getPoints()); 
            System.out.println();
            if (players[index].getPlayerName().equalsIgnoreCase("Player1"))
            {
              System.out.println("Player 2 won!");
            }
            else 
            {
              System.out.println("Player 1 won!");
            }
          }
        }
        else if (option.equalsIgnoreCase("Stick")) //If they choose stick, move onto next player 
        {
          System.out.println("You will receive no more cards");
          System.out.println();
          if (players[index].getPlayerName() == "Player1")
            {
              player1Stuck = true;
            }
            else
            {
              player2Stuck = true;
            }
        }
        if (index % 2 == 0)
        {
          index++;
        }
        else
        {
          index--;
        }
      }
    }
  }
}