package blackjack;

import java.util.*;

public class Hand {
    private Queue<Deck> deck = Deck.shuffle();
    private ArrayList<Deck> dealerInitialHand = new ArrayList<>();
    private ArrayList<Deck> gamblerInitialHand = new ArrayList<>();

    public Deck drawRandomCard() {
        ArrayList<Deck> draw = new ArrayList<>(deck);
        Random random = new Random();
        int index = random.nextInt(draw.size());

        Deck randomCard = draw.get(index);
        deck.remove(randomCard);

        return randomCard;
    }

    public ArrayList<Deck> getDealerInitialHand() {
        for (int i = 0; i < 2; i++) {
            dealerInitialHand.add(drawRandomCard());
        }
        return dealerInitialHand;
    }

    public ArrayList<Deck> getGamblerInitialHand() {
        for (int i = 0; i < 2; i++) {
            gamblerInitialHand.add(drawRandomCard());
        }
        return gamblerInitialHand;
    }
}
