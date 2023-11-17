package org.continuouspoker.player.logic;

import java.util.List;
import java.util.Random;

import org.continuouspoker.player.model.Card;
import org.continuouspoker.player.model.Table;

public class Evaluation {

    Table table;
    List<Card> handCards;
    int[] handCardValues;
    int result;

    public Evaluation(Table table) {
        this.table = table;
        handCards = getHandCards();
        handCardValues = getHandCardValues(handCards);
        result = evaluateHandCardValues();
    }

    // Handkarten als Card Liste
    public List<Card> getHandCards() {
        return table.getPlayers().get(table.getActivePlayer()).getCards();
    }

    // Handkarten als Integer Array
    public int[] getHandCardValues(List<Card> handCards) {
        return new int[] { cardToInt(handCards.get(0)), cardToInt(handCards.get(1)) };
    }

    // Handkarten evaluieren
    public int evaluateHandCardValues() {
        Random rnd = new Random();

        int sum = handCardValues[0] + handCardValues[1];

        int currentChipCount = table.getPlayers().get(table.getActivePlayer()).getStack();
        double percentValue = (double) sum / 56;
        float magic = rnd.nextFloat(0.9f, 1.1f);

        int bet = (int)(currentChipCount * percentValue * magic);

        //falls zwilling einsatz erhöhen
        if ( handCardValues[0] == handCardValues[1] ){
            sum *= 2;
        }
        //falls einsatz == chipcount karten wert zum aussteigen erhöhen
        else if( table.getMinimumBet() == table.getPlayers().get(table.getActivePlayer()).getStack() && table.getRound() == 1){
            //bet wenn hand hoch genug ist
            if(sum <= 16){
                return bet;
            }
            else{
                return 0;
            }
        }
        //falls karten zu schlecht steigen wir aus
        else if (sum <= 10) {
            return 0;
        }

        //falls all dies nicht eintritt bet zurpckgeben
        return bet;
    }

    // hier könnte ein sinnvoller Kommentar stehen

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
            default -> 0;
        };
    }

}