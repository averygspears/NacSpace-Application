public interface DeckOfCardsADT {
    
    public Card drawCard();
    public void returnCard(Card card);
    public void shuffle();
    public void cutDeck(int number);

}
