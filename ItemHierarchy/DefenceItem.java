/**
 * Class representing a defence item that can be used to modify a Pokemon's defence stat.
 */
public class DefenceItem extends Item {

  /**
   * Constructs a DefenceItem with the specified type, name, ID, price, and modifier.
   *
   * @param type the type name of the item
   * @param name the name of the item
   * @param idNum the ID number of the item
   * @param priceNum the price of the item
   * @param mod the modifier value of the item
   */
  public DefenceItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

  /**
   * Uses the defence item on the specified Pokemon to modify its defence stat.
   *
   * @param p the Pokemon to use the defence item on
   */
  @Override
  public void useItem(Pokemon p) {
    p.changeDefenceStat(getModifier()); // Multiplies the Pokemon's defence stat by the item's modifier
  }
}
