public class SpeedItem extends Item {

public SpeedItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }
  
public void useItem(Pokemon p) {
  p.changeSpeedStat(this.modifier); //Multiplies the pokemon's speed stat by the item's modifier
}
} 
