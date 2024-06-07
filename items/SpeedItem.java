public class SpeedItem extends Item {

public void useItem(Pokemon p) {
  p.changeSpeedStat(this.modifier); //Multiplies the pokemon's speed stat by the item's modifier
}
} 
