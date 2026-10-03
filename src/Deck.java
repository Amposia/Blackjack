import java.util.*;

public class Deck
{
  private ArrayList<Card> cards;

  public Deck()
  {
    this.cards = new ArrayList();
    String[] suits = {
      "diamonds", "hearts", "clubs", "spades"
    };
    int[] numericValue = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };
    String[] cardName = {
      "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"
    };

    for (String suit: suits)
    {
      for (int i = 0; i <= 12; i++)
      {
        String name = cardName[i];
        int worth = numericValue[i];
        Card currentCard = new Card(suit, name, worth);
        this.cards.add(currentCard);
      }
    }
    
    Collections.shuffle(this.getCards());
  }

  public void setCards(ArrayList<Card> cards)
  {
    this.cards = cards;
  }

  public ArrayList<Card> getCards()
  {
    return this.cards;
  }

  public Card drawCard()
  {
    return this.getCards().remove(0);
  }
}