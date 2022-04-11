package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;

/**
 * This is for the draw/discard piles.
 */
public class PileOfCards {
    private LinkedList<Card> drawPile = new LinkedList<>();
    private LinkedList<Card> discardPile = new LinkedList<>();



    public Card drawCard(LinkedList<Card> drawPile){

        return drawPile.get(0);

    }

    public Card drawDiscardPile(LinkedList<Card> discardPile){

        return discardPile.get(0);

    }















}
