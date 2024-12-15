public class Test {

    public static void main(String[] args) {
        DeckOfCards myCards = new DeckOfCards();
        System.out.println("My cards: " + myCards.toString());
        myCards.shuffle();
        MyHand myHand = new MyHand(myCards);
        myHand.drawHand(7);
        System.out.println("My cards after shuffle: " + myCards.toString());
        System.out.println("My hand: " + myHand.toString());
        myCards.shuffle();

    }
    
}
