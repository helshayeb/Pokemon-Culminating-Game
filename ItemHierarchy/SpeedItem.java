/**
 * Class representing a speed item that can be used to modify a Pokemon's speed stat.
 */
public class SpeedItem extends Item {

  /**
   * Constructs a SpeedItem with the specified type, name, ID, price, and modifier.
   *
   * @param type the type name of the item
   * @param name the name of the item
   * @param idNum the ID number of the item
   * @param priceNum the price of the item
   * @param mod the modifier value of the item
   */
  public SpeedItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

  /**
   * Uses the speed item on the specified Pokemon to modify its speed stat.
   *
   * @param p the Pokemon to use the speed item on
   */
  @Override
  public void useItem(Pokemon p) {
    p.changeSpeedStat(getModifier()); // Multiplies the Pokemon's speed stat by the item's modifier
  }
}
