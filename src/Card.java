public class Card
{
  private String suit;
  private String name;
  private int worth;

  public Card(String s, String n, int w)
  {
    this.suit = s;
    this.name = n;
    this.worth = w;
  }

  public void setSuit(String suit)
  {
     this.suit = suit;
  }

  public String getSuit()
  {
     return this.suit;
  }

  public void setName(String name)
  {
     this.name = name;
  }

  public String getName()
  {
     return this.name;
  }

  public void setWorth(int worth)
  {
     this.worth = worth;
  }

  public int getWorth()
  {
     return this.worth;
  }

  @Override
  public String toString()
  {
    return name + " of " + suit;
  }
}