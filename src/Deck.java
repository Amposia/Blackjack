import java.util.*;

public class Deck
{
  private ArrayList<Card> cards;

  public Deck() // Constructor for the Deck class
  {
    this.cards = new ArrayList<Card>();
    String[] suits = {
      "diamonds", "hearts", "clubs", "spades"
    };
    int[] numericValue = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10
    };
    String[] cardName = {
      "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"
    };

    for (String suit: suits) // For each suit, create 13 cards with the corresponding names and values
    {
      for (int i = 0; i <= 12; i++)
      {
        String name = cardName[i];
        int worth = numericValue[i];

        Card currentCard = new Card(suit, name, worth);
        this.cards.add(currentCard);
      }
    }

    Collections.shuffle(this.getCards()); // Shuffle the deck of cards
  }

  public void setCards(ArrayList<Card> cards)
  {
    this.cards = cards;
  }

  public ArrayList<Card> getCards()
  {
    return this.cards;
  }

  public Card drawCard() // Method to draw the top card from the deck
  {
    return this.getCards().remove(0);
  }
}