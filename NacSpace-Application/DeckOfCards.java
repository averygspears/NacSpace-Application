/* Avery Spears 12/14/2024
 * 
 * This class creates a deck of cards and performs operations such as
 * drawing a hand, cutting the deck, shuffling it, and etc. 
 * 
 * This class uses the Card object and an ArrayList in which it operates
 * on as a queue. Cards are drawn from the top of the stack and replaced 
 * at the bottom. 
 */

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards implements DeckOfCardsADT {
    public ArrayList<Card> cards;                                   // An ArrayList stores a list of Card objects representing
                                                                    // the deck of cards. 

    // Constructor for the Deck of Cards class
    public DeckOfCards() { 
        cards = new ArrayList<Card>();                              // Instantiates the cards list with objects of type Card.
        for(int i = 0; i < 4; i++) {                                // Adds new cards of the different suits, represented 0-3. 
            for (int j = 1; j < 14; j++) {                          // Adds new cards based on values of cards, represented 1-14. 
                Card card = new Card(j, i);                         // Adds one card for every value for every suit. 
                cards.add(card);
            }
        }
    }

    /**
     * Draws a specified number of cards from the deck; removing them from 
     * the deck and adding them to a personal hand. 
     * 
     * @param num : The number of cards to draw. 
     * @throws CardException : If the number of cards to draw is larger than the deck. 
     */
    public Card drawCard() throws CardException {
        if (cards.size() < 1) {                                     // If deck size is smaller than the number of cards to draw, 
            throw new CardException("Cannot draw from an empty deck of cards.");        // Throw an exception. 
        }
        Card myCard = cards.remove(0);                        // Remove the top card, and return it
        return myCard;
    }

    /**
     * Returns a card to the bottom of the deck. 
     * @param myCard : The card to be returned. 
     * @throws CardException : If the card is already in the deck.  
     */
    public void returnCard(Card myCard) throws CardException{
        if (cards.contains(myCard)) {                               // If the card is already in the deck, 
            throw new CardException("This card is already in the deck.");           // Throw an exception
        }
        cards.add(myCard);                                          // Add the card to the end of the ArrayList.
    }

    /**
     * Shuffles the deck : Uses the java Collections class.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Cuts the deck at a specified point within the deck. 
     * @param num : the number card at which to cut the deck.
     * @throws CardException : If the point to cut the deck at exceeds the number of cards in the deck.
     */
    public void cutDeck(int num) throws CardException {
        if (num > cards.size()) {                                   // If the number to cut the deck at exceeds the size of the deck, 
            throw new CardException("Cannot cut deck of " + cards.size() + " cards at card " + num);    // Throw an exception.
        }

        for (int i = 0; i > num; i++) {                             // Loop through the deck 
            Card myCard = cards.get(i);                             // Retrieve the top card, 
            cards.remove(i);                                        // remove it, 
            cards.add(myCard);                                      // And place it at the bottom of the deck. 
        }

    }

    /**
     * Converts the deck into a string. 
     * @return String : returns the deck of cards converted to a String.
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < cards.size(); i++) {
            s+= cards.get(i).toString();
            s+= "\n";
        }
        return s;
    }

    /* The following method also converts the deck to a string, but in a more concise manner. 
    protected String write() {
        String s = "";
        int x = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 3; j++) {
                s+= cards.get(x).write();
                s+= ", ";
                x++;
            }
            s+= "\n";
        }
        return s;
    }
     */

}