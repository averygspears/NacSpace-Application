/* Avery Spears 12/14/2024
 * 
 * This class creates a playing card with limited operations. 
 * 
 * The card object has a suit type, defined by a string, and
 * a value, defined by an integer. These variables cannot be
 * changed. 
 */

public class Card {

    final int number;                               // The value of the card: 1 - 13 for all values of a playing card. 
    final String suit;                              // The suit of the card; being Spades, Clubs, Diamonds, or Hearts. 

    // Constructor for the card class. 
    public Card(int num, int suitNumber) {          // Takes an integer value representing the suit of the card.
        this.number = num;                          // Set the card value to the number given. 
        if (suitNumber == 0) {                      // Depending on the value of the suit number, the suit is changes accordingly.
            this.suit = "Spades";                   // Spades is 0,
        }
        else if (suitNumber == 1) {                 // Clubs is 1, 
            this.suit = "Clubs";
        }
        else if (suitNumber == 2) {                 // Diamonds is 2, 
            this.suit = "Diamonds";
        }
        else {                                      // Hearts is 3. 
            this.suit = "Hearts";
        }
    }

    /**
     * Returns the value of the card. 
     * @return : the integer value of the card. 
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Returns the suit of the card. 
     * @return : the String suit of the card. 
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * Converts the Card into a String. 
     * @return : A string value containing the card in a readable format. 
     */
    @Override
    public String toString() {
        String s = " _______________";
        for (int i = 0; i < 12; i++) {
            if (i == 0) {
                if (this.suit.equals("Spades")) {
                    s += "\n|Spades         |";
                }
                else if (this.suit.equals("Clubs")) {
                    s += "\n|Clubs          |";
                }
                else if (this.suit.equals("Diamonds")) {
                    s += "\n|Diamonds       |";
                }
                else {
                    s += "\n|Hearts         |";
                }
            }
            else if (i == 5) {
                if (this.number > 9) {
                    if (this.number == 11) {
                        s += "\n|     Jack      |";
                    }
                    else if (this.number == 12) {
                        s += "\n|     Queen     |";
                    }
                    else if (this.number == 13) {
                        s += "\n|     King      |";
                    }
                    else {
                        s += "\n|      10       |";
                    }
                }
                else if (this.number == 1) {
                    s += "\n|      A        |";
                }
                else {
                    s += "\n|      " + this.number + "        |";
                }
            }
            else if (i == 11) {
                if (this.suit.equals("Spades")) {
                    s += "\n|         Spades|";
                }
                else if (this.suit.equals("Clubs")) {
                    s += "\n|          Clubs|";
                }
                else if (this.suit.equals("Diamonds")) {
                    s += "\n|       Diamonds|";
                }
                else {
                    s += "\n|         Hearts|";
                }
            }
            else {
                s += "\n|               |";
            }

        }
        s += "\n _______________";
        return s;
    }

    protected String write() {
        String s = this.suit + " " + this.number;
        return s;
    }

}
