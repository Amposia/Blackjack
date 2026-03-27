import java.util.*;

public class WeAreInTheEndgameNow {
    public static void main(String[] args) throws Exception {

        boolean guess = true;
        Scanner userInput = new Scanner(System.in);
        int points = 0;
        Deck deck = new Deck();
    
        //Draw a card 
        Card currentCard = deck.draw();

        while (guess == true)
        {
            System.out.println("Card drawn: " + currentCard);
            //Ask higher or lower 
            System.out.println("Higher or Lower?");
            String input = userInput.nextLine();
            while (!input.equalsIgnoreCase("Higher") && !input.equalsIgnoreCase("Lower"))
            {
                System.out.println("Enter either 'higher' or 'lower'");
                input = userInput.nextLine();
            }
            Card nextCard = deck.draw();
            System.out.println("Next Card: " + nextCard);
            int currentCardValue = currentCard.getCardValue();
            int nextCardValue = nextCard.getCardValue();
            
            //If they are right, draw another card 
            if (currentCardValue < nextCardValue && input.equalsIgnoreCase("Lower"))
            {
                System.out.println("You lost! );");
                guess = false;
            }
            else if (currentCardValue > nextCardValue && input.equalsIgnoreCase("Higher"))
            {
                System.out.println("You lost! );");
                guess = false;
            }
            else if (currentCardValue == nextCardValue)
            {
                System.out.println("Neither higher nor lower");
                guess = false;
            }
            else
            {
                points++;
                currentCard = nextCard;
                System.out.println("\n");
            }
                        
        }
    }
}