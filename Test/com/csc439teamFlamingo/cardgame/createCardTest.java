package com.csc439teamFlamingo.cardgame;
import org.junit.jupiter.api.Test;
public class createCardTest {
    @Test
    public void testCompareTo() {
        createCard card = new createCard(0, 0, 10);
        createCard card1 = new createCard(0, 1, 9);
        assert(card.compareTo(card1) == 1 && card1.compareTo(card) == -1 && card.compareTo(card) == 0);
    }

    @Test
    public void testGetCardNumber() {
        createCard card = new createCard(0, 0, 10);
        assert(card.getCardNumber() == 10);
    }

    @Test
    public void testGetSuit() {
        createCard card = new createCard(0, 0, 10);
        assert(card.getSuit() == 0);
    }

    @Test
    public void testIsRed() {
        createCard card = new createCard(0, 0, 10);
        createCard card1 = new createCard(0, 1, 10);
        createCard card2 = new createCard(0, 2, 2);
        createCard card3 = new createCard(0, 3, 3);
        assert(!card.isRed() && !card1.isRed() && card2.isRed() && card3.isRed());
    }

    @Test
    public void testIsBlack() {
        createCard card = new createCard(0, 0, 10);
        createCard card1 = new createCard(0, 1, 10);
        createCard card2 = new createCard(0, 2, 2);
        createCard card3 = new createCard(0, 3, 3);
        assert(card.isBlack() && card1.isBlack() && !card2.isBlack() && !card3.isBlack());
    }
}
