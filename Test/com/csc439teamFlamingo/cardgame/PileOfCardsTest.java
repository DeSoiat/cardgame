package com.csc439teamFlamingo.cardgame;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class PileOfCardsTest {

    @Test
    public void generateDrawPileSingleDeckTest() {
        PileOfCards drawPileTest = new PileOfCards(4, true);
        LinkedList<Card> generatedSingleDeck = drawPileTest.fillPile(1);
        //First check that it is the right size
        assertEquals(52, generatedSingleDeck.size());
        //Now check that it has a full deck of cards
        System.out.println(drawPileTest);
    }

    @Test
    public void generateDrawPileMultiDecksTest() {
        PileOfCards p = new PileOfCards(10, true);
        LinkedList<Card> generatedMultiDeck = p.fillPile(3);
        //Check that it's the right size
        assertEquals(156, generatedMultiDeck.size());
        //Now check that it has 3 full decks of cards
        System.out.println(p);
    }

    @Test
    public void testShuffleOnDeckGeneration() {
        PileOfCards testDeck = new PileOfCards(4, true);
        assertEquals(52, testDeck.getCards().size());
        int totalOutOfOrder = 0;
        int totalInOrder = 0;
    }
}
