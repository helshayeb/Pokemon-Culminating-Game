public class City extends Location {
  private boolean hasGym;
  private boolean hasPokeCentre;
  private boolean hasStore;

  public City(String type, String name, int id, boolean gym, boolean pokeCenter, boolean store){
    super(type, name, id);
    hasGym = gym;
    hasPokeCentre = pokeCenter;
    hasStore = store;
  }

 public City(int id, boolean gym, boolean pokeCenter, boolean store){
    super(id);
    hasGym = gym;
    hasPokeCentre = pokeCenter;
    hasStore = store;
 }

public City(int id){
    super(id);
    hasGym = false;
    hasPokeCentre = false;
    hasStore = false;
}



      // Accessors (Getters)
  public boolean hasGym() {
      return hasGym;
    }

   public boolean hasPokeCentre() {
     return hasPokeCentre;
   }
  public boolean hasStore() {
     return hasStore;
   }
    // Mutators (Setters)
   public void setHasGym(boolean hasGym) {
     this.hasGym = hasGym;
   }

  public void setHasPokeCentre(boolean hasPokeCentre) {
     this.hasPokeCentre = hasPokeCentre;
 }
  public void setHasStore(boolean hasStore) {
     this.hasStore = hasStore;
  }
  
}
  

