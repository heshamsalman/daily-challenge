/**
 * Created by heshamsalman on 10/20/15.
 *
 * A Card is an object with a rank and suit. A card can be face-up or face-down. Suit and Rank are defined as enumerable
 * values.
 */

enum Suit {
    DIAMONDS("♦"),
    HEARTS("♥"),
    SPADES("♠"),
    CLUBS("♣");

    private final String text;

    Suit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    static final int maxRank = 13;

    private final String description;

    Rank(int value) {
        switch (value) {
            case 1:
                description = "A";
                break;
            case 11:
                description = "J";
                break;
            case 12:
                description = "Q";
                break;
            case 13:
                description = "K";
                break;
            default:
                description = Integer.toString(value);
                break;
        }
    }

    @Override
    public String toString() {
        return description;
    }
}

public class Card {

    private final Rank rank;
    private final Suit suit;
    private boolean flipped;

    Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
        flipped = true;
    }

    public void flip() {
        flipped = !flipped;
    }

    public boolean isFaceUp() {
        return !flipped;
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
