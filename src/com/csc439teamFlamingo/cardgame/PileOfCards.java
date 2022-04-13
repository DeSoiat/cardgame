package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;

/**
 * This is for the draw/discard piles.
 */
public class PileOfCards {
    private LinkedList<Card> drawPile = new LinkedList<>();


    PileOfCards(LinkedList<Card> cardPile){
        this.drawPile = cardPile;
    }

    public LinkedList<Card> returnDrawPile(){
        return drawPile;
    }


    public Card drawCard(){

        Card newCard = drawPile.getFirst();
        drawPile.removeFirst();
        return newCard;

    }


    public void displayDrawPile(){
        System.out.print("displayDrawPile : ");
        for(int i=0;i < drawPile.size();i++){
            System.out.print(drawPile.get(i).getCardNumber()+" ");
        }
    }

}
