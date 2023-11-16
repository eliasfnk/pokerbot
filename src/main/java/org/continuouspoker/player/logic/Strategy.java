package org.continuouspoker.player.logic;

import org.continuouspoker.player.model.Bet;
import org.continuouspoker.player.model.Table;

public class Strategy {

      int bet;

   public Bet decide(final Table table) {
      System.out.println(table);
      Evaluation evaluation = new Evaluation(table);

      //wenn cardvalue unter minimum bet ist ist bet = minimum bet
      bet = evaluation.cardValue < table.getMinimumBet()? table.getMinimumBet() : evaluation.cardValue;

      return new Bet().bet(bet);
   }

}
