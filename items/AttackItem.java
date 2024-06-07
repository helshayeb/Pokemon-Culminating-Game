public class AttackItem extends Item {

public void useItem(Pokemon p) {
  p.changeAttackStat(this.modifier); //Multiplies the pokemon's attack stat by the item's modifier
}
}  
