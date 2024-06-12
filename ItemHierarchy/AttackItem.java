public class AttackItem extends Item {

public AttackItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }
  
public void useItem(Pokemon p) {
  p.changeAttackStat(this.modifier); //Multiplies the pokemon's attack stat by the item's modifier
}
}  
