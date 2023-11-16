package org.continuouspoker.player.logic;

import java.util.Random;
import org.continuouspoker.player.model.Bet;
import org.continuouspoker.player.model.Table;

public class Strategy {

   int bet;
   Evaluation evaluation;
   Random random = new Random();

   public Bet decide(final Table table) {
      System.err.println("Hallo liest das hier jmd???");
      try {
         evaluation = new Evaluation(table);
         bet = evaluation.cardValue < table.getMinimumBet()? table.getMinimumBet() : evaluation.cardValue;
      } catch (Exception e) {
         bet = random.nextInt(100);
      }
      return new Bet().bet(bet);
   }

}