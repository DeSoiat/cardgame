package com.csc439teamFlamingo.cardgame;
import org.junit.jupiter.api.Test;
public class CardTest {
    @Test
    public void testCompareTo() {
        Card card = new Card(0, 0, 10);
        Card card1 = new Card(0, 1, 9);
        assert(card.compareTo(card1) == 1 && card1.compareTo(card) == -1 && card.compareTo(card) == 0);
    }

    @Test
    public void testGetCardNumber() {
        Card card = new Card(0, 0, 10);
        assert(card.getCardNumber() == 10);
    }

    @Test
    public void testGetSuit() {
        Card card = new Card(0, 0, 10);
        assert(card.getSuit() == 0);
    }

    @Test
    public void testIsRed() {
        Card card = new Card(0, 0, 10);
        Card card1 = new Card(0, 1, 10);
        Card card2 = new Card(0, 2, 2);
        Card card3 = new Card(0, 3, 3);
        assert(!card.isRed() && !card1.isRed() && card2.isRed() && card3.isRed());
    }

    @Test
    public void testIsBlack() {
        Card card = new Card(0, 0, 10);
        Card card1 = new Card(0, 1, 10);
        Card card2 = new Card(0, 2, 2);
        Card card3 = new Card(0, 3, 3);
        assert(card.isBlack() && card1.isBlack() && !card2.isBlack() && !card3.isBlack());
    }
}
