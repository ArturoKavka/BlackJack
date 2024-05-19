package blackjack;

import java.util.LinkedList;
import java.util.Queue;

public class Deck {
    private String value;
    private String suit;

    public Deck(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public static Queue<Deck> shuffle() {
        Queue<Deck> deck = new LinkedList<Deck>();
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"H", "S", "D", "C"};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Deck card = new Deck(values[j], suits[i]);
                deck.add(card);
            }
        }
        return deck;
    }

    public int obtainCardValue(Deck card) {
        int cardValue = 0;
        String value = card.getValue();
        switch (value) {
            case "A":
                cardValue = 11;
                return cardValue;
            case "2":
                cardValue = 2;
                return cardValue;
            case "3":
                cardValue = 3;
                return cardValue;
            case "4":
                cardValue = 4;
                return cardValue;
            case "5":
                cardValue = 5;
                return cardValue;
            case "6":
                cardValue = 6;
                return cardValue;
            case "7":
                cardValue = 7;
                return cardValue;
            case "8":
                cardValue = 8;
                return cardValue;
            case "9":
                cardValue = 9;
                return cardValue;
            case "10":
                cardValue = 10;
                return cardValue;
            case "J":
                cardValue = 10;
                return cardValue;
            case "Q":
                cardValue = 10;
                return cardValue;
            case "K":
                cardValue = 10;
                return cardValue;
        }
        return cardValue;
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

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value='" + value + '\'' +
                '}';
    }
}
