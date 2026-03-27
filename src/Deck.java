import java.util.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList();

    public Deck()
    {
        String[] names = {"ace","two","three","four","five","six","seven","eight","nine","ten","Jack","King","Queen"};
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        String[] suits = {"diamonds","hearts","clubs","spades"};
        for (String suit : suits) //For each and every suit
        {
            for (int value : values) //For each and every value 
            {
                //Create a card and add it to deck
                String nameOfCard = names[value - 1];
                Card card = new Card(nameOfCard,value,suit);
                this.deck.add(card);
            }
        }
        Collections.shuffle(this.deck); //Shuffles deck
    }

    public ArrayList<Card> getCards()
    {
        return this.deck;
    }

    public Card draw()
    {
        return this.getCards().remove(1);
    }
}
