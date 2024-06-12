public class HealthItem extends Item {

public HealthItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }
  
public void useItem(Pokemon p) {
  if (p.getCurrentHp() + modifier <= p.getMaxHpStat()) {
    p.changeCurrentHp(0, this.modifier);
}
  else {
    p.changeCurrentHp(0, this.modifier); 
  }
}
}
