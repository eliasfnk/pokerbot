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

        return values[0] + values[1];
    }


    // Handkarten
    public List<Card> getHandCards() {
        return table.getPlayers().get(table.getActivePlayer()).getCards();
    }

    // Tischkarten
    public List<Card> getTableCards() {
        return table.getCommunityCards();
    }

    public int getCardValue(Card card){
        switch (card.getRank()) {
            case _2:
                return 1;
            case _3:
                return 2;
            case _4:
                return 3;
            case _5:
                return 4;
            case _6:
                return 5;
            case _7:
                return 6;
            case _8:
                return 7;
            case _9:
                return 8;
            case _10:
                return 9;
            case J:
                return 10;
            case Q:
                return 11;
            case K:
                return 12;
            case A:
                return 13;
            default:
                return 0;
        }
    }

    

}
