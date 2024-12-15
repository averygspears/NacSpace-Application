/* Avery Spears 12/14/2024
 * 
 * This class creates an object, "myHand", representing a player's hand
 * in a card game. Operations on the object include drawing a hand from
 * a deck of cards, and discarding cards. 
 * 
 * This class utilizes an ArrayList to operate on the Hand as a list data
 * structure. A deck of cards object must be created and passed to create
 * an object of myHand.
 */

import java.util.ArrayList;

public class MyHand {
    
    public ArrayList<Card> myHand = new ArrayList<Card>();          // An array list stores a list of Card objects representing 
                                                                    // a user's hand. 
    public DeckOfCards myDeck;                                      // The deck from which the hand operates on. 
    
    // Constructor for the myHand class; requires an instantiated deckOfCards object. 
    public MyHand(DeckOfCards deckOfCards) {
        myDeck = deckOfCards;
    }
    
    /* Draws a specified number of cards from the deck; removing them from 
     * the deck and adding them to a personal hand. 
     * 
     * @param num : The number of cards to draw. 
     * @throws CardException : If the number of cards to draw is larger than the deck. 
     */
    public void drawHand(int num) throws CardException {
        for (int i = 0; i < num; i++) {                         
            myHand.add(myDeck.drawCard());                      // Remove the top cards from the deck and add them to the hand.  
        }
    }

    /**
     * Discards a specified card from the hand at places it at the bottom of the deck. 
     * @param myCard : The card to be discarded. 
     * @throws CardException : If the card specified is not in the hand.
     */
    public void discard(Card myCard) throws CardException {
        if (!myHand.contains(myCard)) {                         // If the hand does not contain the specified card, 
            throw new CardException("The card specified is not in your hand.");         // Throw an exception. 
        }
        myHand.remove(myCard);                                  // Use the remove method in the ArrayList class. 
        myDeck.returnCard(myCard);                              // Return the card to the deck. 
    }

    /**
     * Convert the hand into a readable output. 
     * @return String : the hand converted into a string. 
     */
    public String handToString() {
        String s = "";
        for (int i = 0; i < myHand.size(); i++) {
            s+= myHand.get(i).toString();
            s+= "\n";
        }
        return s;
    }

    /* The following method also converts the hand to a string, but in a more concise manner. 
    protected String write() {
        String s = "";
        for (int i = 0; i < myHand.size(); i++) {
            s += myHand.get(i).write();
            s+= ", ";
        }
        return s;
    }
    */

}
