package org.continuouspoker.player.logic;

import java.util.List;

import org.continuouspoker.player.model.Player;
import org.continuouspoker.player.model.Table;

public class Risk {



    public Risk(Table table){
        List<Player> players = table.getPlayers();
        Player player = players.get(table.getActivePlayer());
        player.getCards();
    }
}
