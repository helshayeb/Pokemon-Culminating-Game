package LocationHierarchy;

public class City extends Location {
    private boolean hasPokeCentre; //If the city has the pokecenter to heal pokemons
    private boolean hasPokestop; // If the city has the pokestop to buy items

    /**
     * Constructs a new City object with specified type, name, id, pokeCenter, and pokeStop.
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param id The unique identifier for the location.
     * @param pokecenter If the city has the pokecenter to heal pokemons
     * @param pokeStop  If the city has the pokestop to buy items
     */
    public City(String type, String name, int id, boolean pokeCenter, boolean pokeStop){
        super(type, name, id);
        hasPokeCentre = pokeCenter;
        hasPokestop = pokeStop;
    }

    /**
     * Constructs a new City object with specified id, pokeCenter, and pokeStop.
     * 
     * @param id The unique identifier for the location.
     * @param pokecenter If the city has the pokecenter to heal pokemons
     * @param pokeStop  If the city has the pokestop to buy items
     */
    public City(int id, boolean pokeCenter, boolean pokeStop){
        super(id);
        hasPokeCentre = pokeCenter;
        hasPokestop = pokeStop;
    }

    /**
     * Constructs a new City object with id.
     * 
     * @param id The unique identifier for the location.
     */
    public City(int id){
        super(id);
        hasPokeCentre = false;
        hasPokestop = false;
    }



    // Accessors (Getters)

    /**
     * Gets if the city has the pokecenter to heal pokemons.
     * 
     */
    public boolean getHasPokeCentre() {
        return hasPokeCentre;
    }
    /**
     * Gets if the city has the pokeStop to heal pokemons.
     * 
     */
    public boolean getHasPokeStop() {
        return haspokeStop;
    }
    // Mutators (Setters)
    /**
     * Sets if the city has the pokeCentre to buy items.
     * @param updated information of if the city has the pokeCentre to buy items.
     */
    public void setHasPokeCentre(boolean hasPokeCentre) {
        this.hasPokeCentre = hasPokeCentre;
    }
    /**
     * Sets if the city has the pokeStop to heal pokemons.
     * @param updated information of if the city has the pokeStop to heal pokemons.
     */
    public void setHaspokeStop(boolean haspokeStop) {
        this.haspokeStop = haspokeStop;
    }

    public String toString(){
        String str = super.toString();
        if(hasPokeCentre){
            str += "\nIt has a PokeCentre";
        }
        if(hasPokeStop){
            str += "\nIt has a PokeStop";
        }
        return str; 
    }

}

