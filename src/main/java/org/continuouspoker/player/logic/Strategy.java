package org.continuouspoker.player.logic;

import java.util.Random;

import org.continuouspoker.player.model.Bet;
import org.continuouspoker.player.model.Table;

public class Strategy {

      int bet;
      Random rnd = new Random(100);
      Evaluation evaluation;

   public Bet decide(final Table table) {
      System.out.println(table);
      try{
            evaluation = new Evaluation(table);
      
            //wenn cardvalue unter minimum bet ist ist bet = minimum bet
            bet = evaluation.cardValue < table.getMinimumBet()? table.getMinimumBet() : evaluation.cardValue;

      }catch(Exception e){
            bet = rnd.nextInt();
      }

      
      if(evaluation.getFold()){
            return new Bet().bet(0);
      }
      else{
            return new Bet().bet(bet);
      }
   }

}
