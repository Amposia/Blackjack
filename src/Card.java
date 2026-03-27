public class Card {
    private String suit;
    private int value;
    private String name;

    public Card(String s, int v, String n)
    {
        this.value = v;
        this.suit = s;
        this.name = n;
    }
    
    public int getCardValue()
    {
        return this.value;       
    }

    @Override
    public String toString()
    {
        return suit + " of " + name;
    }
}
