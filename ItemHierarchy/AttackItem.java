/**
 * Class representing an attack item that can be used to modify a Pokemon's attack stat.
 */
public class AttackItem extends Item {

  /**
   * Constructs an AttackItem with the specified type, name, ID, price, and modifier.
   *
   * @param type the type name of the item
   * @param name the name of the item
   * @param idNum the ID number of the item
   * @param priceNum the price of the item
   * @param mod the modifier value of the item
   */
  public AttackItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

  /**
   * Uses the attack item on the specified Pokemon to modify its attack stat.
   *
   * @param p the Pokemon to use the attack item on
   */
  @Override
  public void useItem(Pokemon p) {
    p.changeAttackStat(getModifier()); // Multiplies the Pokemon's attack stat by the item's modifier
  }
}
