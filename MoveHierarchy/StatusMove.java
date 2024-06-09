public class StatusMove extends Move{
   private double hpMod;
   private double atkMod;
   private double defMod;
   private double spdMod;
   private int recipient;
   
   public StatusMove(String objectID, String moveName, int moveType, int moveID, double hpMod, double atkMod, double defMod, double spdMod, int recipient){
      super(objectID, moveName, moveType, moveID);
      this.hpMod = hpMod;
      this.atkMod = atkMod;
      this.defMod = defMod;
      this.spdMod = spdMod;
      this.recipient = recipient;
   }
   
   public void useMove(Pokemon p1, Pokemon p2){
      double max;
      if(recipient == 0){
         p1.changeCurrentHP(hpMod, 0);
         
         p1.setAttackStat(atkMod); // reminder to make it attackStat*atkMod inside the mutator in pokemon class
         p1.setDefenceStat(defMod); //same with everything here
         p1.setSpeedStat(spdMod);
      }else{
         p2.setCurrentHP(hpMod, 0);
         max = p2.getMaxHP;
         if(p2.getCurrentHP()>max){
            p2.setCurrentHP(max);
         }
         p2.setAttackStat(atkMod); // reminder to make it attackStat*atkMod inside the mutator in pokemon class
         p2.setDefenceStat(defMod); //same with everything here
         p2.setSpeedStat(spdMod);
      }
   }
}
