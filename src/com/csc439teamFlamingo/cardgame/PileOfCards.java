package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;

/**
 * This is for the draw/discard piles.
 */
public class PileOfCards {
    private LinkedList<Card> drawPile = new LinkedList<>();
    private LinkedList<Card> discardPile = new LinkedList<>();

    public LinkedList<Card> returnDrawPile(){
        return drawPile;
    }
    public LinkedList<Card> returnDiscardPile(){
        return discardPile;
    }


    public Card drawCard(LinkedList<Card> drawPile){

        return drawPile.get(0);

    }

    public Card drawDiscardPile(LinkedList<Card> discardPile){

        return discardPile.get(0);

    }

    public void displayDrawPile(){
        System.out.println("displayDrawPile : ");
        for(int i=0;i< drawPile.size();i++){
            System.out.print(drawPile.get(i).getCardNumber()+" ");
        }
    }

    public void displayDiscardPile(){
        System.out.println("displayDrawPile : ");
        for(int i=0;i< discardPile.size();i++){
            System.out.print(discardPile.get(i).getCardNumber()+" ");
        }
    }















}
