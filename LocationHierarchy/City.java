public class City extends Location {
    private boolean hasPokeCentre;
    private boolean hasPokestop;

    public City(String type, String name, int id, boolean pokeCenter, boolean store){
        super(type, name, id);
        hasPokeCentre = pokeCenter;
        hasPokestop = store;
    }

    public City(int id, boolean pokeCenter, boolean store){
        super(id);
        hasPokeCentre = pokeCenter;
        hasPokestop = store;
    }

    public City(int id){
        super(id);
        hasPokeCentre = false;
        hasPokestop = false;
    }



    // Accessors (Getters)

    public boolean getHasPokeCentre() {
        return hasPokeCentre;
    }
    public boolean getHasStore() {
        return hasStore;
    }
    // Mutators (Setters)

    public void setHasPokeCentre(boolean hasPokeCentre) {
        this.hasPokeCentre = hasPokeCentre;
    }
    public void setHasStore(boolean hasStore) {
        this.hasStore = hasStore;
    }

}

