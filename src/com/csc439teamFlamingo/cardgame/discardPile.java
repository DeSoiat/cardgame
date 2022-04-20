package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;

/**
 * This is for the discard piles.
 */

public class discardPile {
    private static LinkedList<Card> discardPile = new LinkedList<>();

    discardPile(LinkedList<Card> cardPile){
        this.discardPile = cardPile;
    }


    public LinkedList<Card> returnDiscardPile(){
        return discardPile;
    }

    public static Card drawDiscard(){

        Card newCard = discardPile.getFirst();
        discardPile.removeFirst();
        return newCard;

    }

    public void displayDiscard(){
        System.out.print("displayDiscard : ");
        for(int i=0;i < discardPile.size();i++){
            System.out.print(discardPile.get(i).getCardNumber()+" ");
        }
    }

}





