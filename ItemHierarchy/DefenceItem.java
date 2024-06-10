public class DefenceItem extends Item {

public void useItem(Pokemon p) {
  p.changeDefenceStat(this.modifier); //Multiplies the pokemon's defence stat by the item's modifier
}
} 
