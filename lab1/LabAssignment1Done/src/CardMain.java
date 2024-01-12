public class CardMain {
    public static void main(String[] args) {
        Deck d = new Deck(true);
//        System.out.println(d);
//        d.dealSpecificCard("7","Diamonds");
//        d.dealSpecificCard("8", "Clubs");
//
        Hand h = new Hand();
        for (int i = 0; i < 5; i++) {
//            h.addCard(d.deal());
//            7D, 7H, 4S, 6H, 8H
            h.addCard(d.dealSpecificCard("J", "Diamonds"));
            h.addCard(d.dealSpecificCard("Q", "Diamonds"));
            h.addCard(d.dealSpecificCard("K", "Diamonds"));
            h.addCard(d.dealSpecificCard("A", "Diamonds"));
            h.addCard(d.dealSpecificCard("10", "Diamonds"));


//            h.addCard(d.dealSpecificCard("7","Diamonds"));
//            h.addCard(d.dealSpecificCard("7", "Spades"));
//            h.addCard(d.dealSpecificCard("5", "Hearts"));
//            h.addCard(d.dealSpecificCard("6", "Clubs"));
//            h.addCard(d.dealSpecificCard("3", "Hearts"));
        }
        System.out.println(h);
        System.out.println(h.getHandRank());
    }
}
