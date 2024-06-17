package LocationHierarchy;
/**
* Class Name: City
* Author: Kelvin Kim
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates Cities that can be travelled to
*/
public class City extends Location {
    /**
    *If the city has the pokecenter to heal pokemons
    */
    private boolean hasPokeCentre; 
    /**
    * If the city has the pokestop to buy items
    */
    private boolean hasPokestop; //

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
        return hasPokestop;
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
    public void setHasPokeStop(boolean haspokeStop) {
        this.hasPokestop = haspokeStop;
    }

    /**
   	* This method returns information about the City
   	* in the form of a String
   	* @return String Information about the City
   	*/
    public String toString(){
        String str = super.toString();
        if(hasPokeCentre){
            str += "\nIt has a PokeCentre";
        }
        if(hasPokestop){
            str += "\nIt has a PokeStop";
        }
        return str; 
    }

}

