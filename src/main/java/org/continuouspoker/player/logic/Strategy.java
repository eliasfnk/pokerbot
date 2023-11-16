package org.continuouspoker.player.logic;

import java.util.Random;

import org.continuouspoker.player.model.Bet;
import org.continuouspoker.player.model.Table;

public class Strategy {

      int bet;
      Random rnd = new Random(100);

   public Bet decide(final Table table) {
      System.out.println(table);
      try{
            Evaluation evaluation = new Evaluation(table);
      
            //wenn cardvalue unter minimum bet ist ist bet = minimum bet
            bet = evaluation.cardValue < table.getMinimumBet()? table.getMinimumBet() : evaluation.cardValue;
      }catch(Exception e){
            bet = rnd.nextInt();
      }

      return new Bet().bet(bet);
   }

}
