import java.util.ArrayList;

class Hand
{
  private ArrayList<Card> cards = new ArrayList();
  private int points;
  private String playerName;

  public Hand(String pn)
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

  public void setCards(ArrayList<Card> cards)
  {
     this.cards = cards;
  }

  public ArrayList<Card> getCards()
  {
     return this.cards;
  }

  public void setPlayerName(String pn)
  {
    this.playerName = pn;
  }

  public String getPlayerName()
  {
    return this.playerName;
  }

  public Card twist(Deck deckOfCards)
  {
    return deckOfCards.drawCard();
  }

  public void calculatePoints()
  {
    int points = 0;
    for (Card playerCard : this.getCards())
    {
      points += playerCard.getWorth(); //base card values
    }

    for (Card playerCard : this.getCards())
    {
      if (playerCard.getName().equalsIgnoreCase("ace") && (points + 10 <= 21))
      {
        points += 10; //if adding 10 to the ace keeps points under or equal to 21, add 10 to points
      }
    }

   this.setPoints(points); 
  }
}