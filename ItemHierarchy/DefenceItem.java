public class DefenceItem extends Item {

public DefenceItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

public void useItem(Pokemon p) {
  p.changeDefenceStat(this.modifier); //Multiplies the pokemon's defence stat by the item's modifier
}
}
