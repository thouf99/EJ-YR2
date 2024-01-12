public class Card {
    private String value;
    private String suit;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value='" + value + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }

    public int getNumericValue() {
        switch (value) {
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            case "A":
                return 14;
            default:
                return Integer.parseInt(value);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
