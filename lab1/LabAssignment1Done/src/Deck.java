import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private final LinkedList<Card> deck = new LinkedList<Card>();

    Deck(boolean shuffled) {
        String[] suits = {"Clubs", "Hearts", "Diamonds", "Spades"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String s : suits) {
            for (String v : values) {
                deck.add(new Card(v, s));
            }
        }
        if (shuffled) {
            Collections.shuffle(deck);
        }
    }

    public Card deal() {
        return deck.pop();
    }

    public Card dealSpecificCard(String value, String suit) {
        for (int i = 0; i < deck.size(); i++) {
            Card c = deck.get(i);
            if (c.getValue().equals(value) && c.getSuit().equals(suit)) {
                return deck.remove(i);
            }
        }

        return null;
    }

    public String toString() {
        String output = "";
        for (Card c : deck) {
            if (c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            } else {
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }

        return output;
    }

}
