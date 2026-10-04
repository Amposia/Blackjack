import java.util.ArrayList;

class Hand
{
  private ArrayList<Card> cards = new ArrayList<Card>(); // ArrayList to hold the cards in the hand
  private int points; // Variable to hold the total points of the hand
  private String playerName;

  public Hand(String pn) // Constructor for the Hand class, takes a player name as a parameter
  {
    this.playerName = pn;
  }

  public void setPoints(int points)
  {
     this.points = points;
  }

  public int getPoints()
  {
     return this.points;
  }

  public ArrayList<Card> getCards()
  {
     return this.cards;
  }

  public String getPlayerName()
  {
    return this.playerName;
  }

  public Card twist(Deck deckOfCards) // Method to draw a card from the deck and add it to the hand
  {
    Card cardDrawn = deckOfCards.drawCard();
    this.getCards().add(cardDrawn);
    return cardDrawn;
  }

  public void calculatePoints()
  {
    int points = 0; // Variable to hold the total points of the hand, intialized to 0
    for (Card playerCard : this.getCards()) // For each card in the hand, add its base worth to the total points
    {
      points += playerCard.getWorth();
    }

    for (Card playerCard : this.getCards()) // For each card in the hand, check if it is an ace
    {
      if (playerCard.getName().equalsIgnoreCase("ace") && (points + 10 <= 21))
      {
        points += 10; //if adding 10 to the ace keeps points under or equal to 21, add 10 to points
      }
    }

   this.setPoints(points); // Set the total points of the hand to the calculated value
  }
}