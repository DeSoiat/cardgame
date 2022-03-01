package com.csc439teamFlamingo.cardgame;



public class creatCard extends card{

    private int cardNumber,suit,upORdown;

    /*
    For color
    0 = red
    1 = black

    For face up or down
    0 = up
    1 = down

    0 - clubs black, 1 - spades black, 2 - heart red 3 - diamond red

    For card number 0 - 12

     */

    public creatCard(int upORdown,int suit,int cardNumber) {

        this.upORdown = upORdown;
        this.suit = suit;
        this.cardNumber = cardNumber;


    }

    public Boolean isRed() {
        if(suit == 2 || suit == 3 )
            return true;
        else
            return false;
    }

    public Boolean isBlack(){
        if(suit == 0 || suit == 1)
            return true;
        else
            return false;
    }

    public Boolean isFaceDown(){
        if(upORdown == 1)
            return true;
        else
            return false;
    }

    @Override
    void compareTo() {





    }

    @Override
    int getCardNumber() {
        return cardNumber;
    }


}
