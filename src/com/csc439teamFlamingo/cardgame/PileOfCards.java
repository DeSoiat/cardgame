package com.csc439teamFlamingo.cardgame;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This is for the draw/discard piles.
 */
public class PileOfCards {

    private LinkedList<Card> cards = new LinkedList<>();

    public PileOfCards(int numPlayers, boolean isDrawPile) {
        if(isDrawPile) {
            int numOfDecks = 1;
            if(numPlayers > 4) {
                numOfDecks += numPlayers / 4;
            }
            this.fillPile(numOfDecks);
            this.shufflePile();
        }
    }

    public LinkedList<Card> fillPile(int numOfDecks) {
        cards.clear();
        for(int deck = 0; deck < numOfDecks; deck++) {
            for(int suit = 0; suit < 4; suit++) {
                for(int number = 0; number < 13; number++) {
                    cards.push(new Card(1, suit, number));
                }
            }
        }
        return cards;
    }

    public Card drawCard(){

        Card newCard = cards.getFirst();
        cards.removeFirst();
        return newCard;

    }

    public void shufflePile() {
        ArrayList<Card> tempPile = new ArrayList<>(cards);
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < tempPile.size(); y++) {
                int indexOther = (int)(Math.random() * tempPile.size());
                shuffleHelper(y, indexOther, tempPile);
            }
        }
        cards.clear();
        cards.addAll(tempPile);
    }

    private void shuffleHelper(int indexOne, int indexTwo, ArrayList<Card> pile) {
        Card tc = pile.get(indexOne);
        pile.set(indexOne, pile.get(indexTwo));
        pile.set(indexTwo, tc);
    }

    public void displayDrawPile(){
        System.out.print("displayDrawPile: " + cards.peekFirst());
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

}
