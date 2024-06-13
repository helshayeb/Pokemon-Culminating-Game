/**
 * Class representing a health item that can be used to heal a Pokemon.
 */
public class HealthItem extends Item {

  /**
   * Constructs a HealthItem with the specified type, name, ID, price, and modifier.
   *
   * @param type the type name of the item
   * @param name the name of the item
   * @param idNum the ID number of the item
   * @param priceNum the price of the item
   * @param mod the modifier value of the item
   */
  public HealthItem(String type, String name, int idNum, int priceNum, double mod) {
    super(type, name, idNum, priceNum, mod);
  }

  /**
   * Uses the health item on the specified Pokemon to heal it.
   *
   * @param p the Pokemon to use the health item on
   */
  @Override
  public void useItem(Pokemon p) {
    double newHp = p.getCurrentHp() + getModifier();
    if (newHp <= p.getMaxHpStat()) {
      p.changeCurrentHp(0, getModifier());
    } else {
      p.changeCurrentHp(0, p.getMaxHpStat() - p.getCurrentHp());
    }
  }
}
