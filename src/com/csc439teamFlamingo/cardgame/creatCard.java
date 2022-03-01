package com.csc439teamFlamingo.cardgame;



public class creatCard extends card{

    private int cardNumber,color,upORdown;

    /*
    For color
    0 = red
    1 = black

    For face up or down
    0 = up
    1 = down

    For card number 0 - 12

     */

    public creatCard(int upORdown,int color,int cardNumber) {

        this.upORdown = upORdown;
        this.color = color;
        this.cardNumber = cardNumber;


    }

    public Boolean isRed() {
        if(color == 0)
            return true;
        else
            return false;
    }

    public Boolean isBlack(){
        if(color == 1)
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
        return 0;
    }


}
