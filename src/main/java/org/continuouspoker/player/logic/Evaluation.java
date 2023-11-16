package org.continuouspoker.player.logic;

import java.util.List;
import org.continuouspoker.player.model.Card;
import org.continuouspoker.player.model.Table;

public class Evaluation {

    Table table;
    List<Card> handCards;
    List<Card> tableCards;
    int[] cardValues = new int[2];
    int cardValue;

    public Evaluation(Table table) {
        this.table = table;
        handCards = getHandCards();
        tableCards = getTableCards();

        cardValues[0] = cardToInt(handCards.get(0));
        cardValues[1] = cardToInt(handCards.get(1));

        cardValue = evaluateCardValue();
    }

    //methode die die Höhe unseren Karten Wert evaluiert
    public int evaluateCardValue(){
        //hier methoden einfügen die weitere andere Möglichkeiten, wie zB Zwilling 

        //methode zur evaluierung des fold werts
        int valueSum = cardValues[0] + cardValues[1];
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

    public int cardToInt(Card card) {
        return switch (card.getRank()) {
            case _2  ->  2;
            case _3  ->  3;
            case _4  ->  4;
            case _5  ->  5;
            case _6  ->  6;
            case _7  ->  7;
            case _8  ->  8;
            case _9  ->  9;
            case _10 -> 10;
            case J   -> 11;
            case Q   -> 12;
            case K   -> 13;
            case A   -> 14;
        };
    }

}