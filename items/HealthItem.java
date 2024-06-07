public class HealthItem extends Item {

public void useItem(Pokemon p) {
  //checks if the pokemon's hp will overflow after taking the item
  if (p.getCurrentHp + modifier <= p.getMaxHpStat) {
    p.changeCurrentHp(0, this.modifier); //heals the pokemon 
}
  else {
    p.changeCurrentHp(0, this.modifier); //brings the pokemon to full health instead of overflowing
  }
}

}
