package org.continuouspoker.player.logic;

import java.util.List;

import org.continuouspoker.player.model.Card;
import org.continuouspoker.player.model.Table;

public class Evaluation {

    Table table;
    List<Card> handCards;
    List<Card> tableCards;
    int[] values = new int[2];
    int cardValue;

    public Evaluation(Table table) {
        this.table = table;
        handCards = getHandCards();
        tableCards = getTableCards();

        values[0] = getCardValue(handCards.get(0));
        values[1] = getCardValue(handCards.get(1));

        cardValue = evaluateCardValue();
    }

    //methode die die Höhe unseren Karten Wert evaluiert
    public int evaluateCardValue(){
        //hier methoden einfügen die weitere andere Möglichkeiten, wie zB Zwilling 

        //methode zur evaluierung des fold werts
        int valueSum = values[0] + values[1];
        if(valueSum <= 10){
            return 0;
        }
        else{
            return valueSum;
        }
    }


    // Handkarten
    public List<Card> getHandCards() {
        return table.getPlayers().get(table.getActivePlayer()).getCards();
    }

    // Tischkarten
    public List<Card> getTableCards() {
        return table.getCommunityCards();
    }

    //wenn cardValue zu niedrig ist gehen wir einfaqch aus der runde
    public boolean getFold(){
        if(cardValue < 10){
            return true;
        }
        else{
            return false;
        }
    }

    public int getCardValue(Card card){
        switch (card.getRank()) {
            case _2:
                return 2;
            case _3:
                return 3;
            case _4:
                return 4;
            case _5:
                return 5;
            case _6:
                return 6;
            case _7:
                return 7;
            case _8:
                return 8;
            case _9:
                return 9;
            case _10:
                return 10;
            case J:
                return 11;
            case Q:
                return 12;
            case K:
                return 13;
            case A:
                return 14;
            default:
                return 0;
        }
    }

    

}
