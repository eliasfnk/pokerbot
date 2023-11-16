package org.continuouspoker.player.logic;

import java.util.List;

import org.continuouspoker.player.model.Card;
import org.continuouspoker.player.model.Player;
import org.continuouspoker.player.model.Table;

public class Risk {

    Table table;
    List<Card> cards;
    List<Integer> values;

    public Risk(Table table){
        this.table = table;
        cards = extractHandCards();

        //werte der Karten zurückgeben
        values.add(getCardValue(cards.get(0)));
        values.add(getCardValue(cards.get(1)));
    }


    //methode um unsere Karten zu bekommen
    public List<Card> extractHandCards(){
        List<Player> players = table.getPlayers();
        Player player = players.get(table.getActivePlayer());
        return player.getCards();
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
