import java.util.*;

public class WeAreInTheEndgameNow
{
  public static void main(String[] args)
  {
    Deck paulsDeckOfCards = new Deck();
    Scanner input = new Scanner(System.in);
    Hand playerOne = new Hand();
    Hand playerTwo = new Hand();
    Hand[] players = {
      playerOne, playerTwo
    };
    boolean endgame = false;

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
    while (endgame == false)
    {
      for (int i = 0; i <= 1; i++)
    {
      System.out.println("Player " + (i+1) + "'s turn");
      System.out.println("Starting card: " + players[i].getCards().get(0));

      System.out.println("Stick or Twist?");
      String option = input.nextLine();

      while (!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"))
      {
        System.out.println("Please enter either 'Stick' or 'Twist'");
        option = input.nextLine();
      }

      if (option.equalsIgnoreCase("Twist"))
      {
        Card newCard = players[i].twist(paulsDeckOfCards);
        System.out.println("Card drawn: " + newCard);
        players[i].getCards().add(newCard);
        System.out.println("Your cards are: " + players[i].getCards());

        System.out.println("Stick or Twist?");
        option = input.nextLine();

        /*while (!option.equalsIgnoreCase("Stick") && !option.equalsIgnoreCase("Twist"))
        {

          System.out.println("Please enter either 'Stick' or 'Twist'");
          option = input.nextLine();
        }*/ //Don't need this cuz we just have to ask once, then repeat until both players say 'Stick'
        
        //array.indexOf
        int temp = ;
        if(players[i].getCards().) //If player's tempTotal > 21 && there's an ace, switch ace value 
        {

        }
      }
      players[i].calculatePoints();
      
      else if (option.equalsIgnoreCase("Stick"))
      {
        
      }
    }

    System.out.println("Player 1 got " + players[0].getPoints());
    System.out.println("Player 2 got " + players[1].getPoints());
    }
  }
}