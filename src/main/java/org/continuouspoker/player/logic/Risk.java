package org.continuouspoker.player.logic;

import java.util.List;

import org.continuouspoker.player.model.Card;
import org.continuouspoker.player.model.Player;
import org.continuouspoker.player.model.Table;

public class Risk {

    Table table;
    List<Card> cards;

    public Risk(Table table){
        this.table = table;
        cards = extractCards();
    }

    public List<Card> extractCards(){
        List<Player> players = table.getPlayers();
        Player player = players.get(table.getActivePlayer());
        return player.getCards();
    }
}
