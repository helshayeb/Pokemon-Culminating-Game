package LocationHierarchy;

public class Route extends Location {
    /**
    * An array of pokemon IDs in the Location
    */
    String[] pokemonInLocation = new String[200];
    /**
    * The number of the Pokemons in the Array
    */
    int numPokemon = 0;
    /**
    * The unique Identification number of the Route
    */
    int routeNum;

    /**
     * Constructs a new Route object with specified type, name, id, pokes(list of pokemon).
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public Route(String type, String name, int routeNum, int id, String[] pokes){
        super(type, name, id);
        for (int i = 0; i < pokes.length; i++) {
            if(pokes[i] != null) {
                pokemonInLocation[numPokemon] = pokes[i];
                numPokemon++;
            }
        }
        this.routeNum = routeNum;
    }

    /**
     * Constructs a new Route object with specified type, name, id.
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param id The unique identifier for the location.
     */
    public Route(String type, String name, int routeNum, int id){
        super(type, name, id);
        this.routeNum = routeNum;
    }

    /**
     * Constructs a new Route object with specified type, name, id.
     * 
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public Route(int id, int routeNum, String [] pokes){
        super(id);
        for (int i = 0; i < pokes.length; i++) {
            if(pokes[i] != null) {
                pokemonInLocation[numPokemon] = pokes[i];
                numPokemon++;
            }
        }
        this.routeNum = routeNum;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     *
     */
    public String[] getPokemonInLocation() {
        return pokemonInLocation;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     * return: numPokemon
     */
    public int getNumPokemon(){
        return numPokemon;
    }

    /**
     * Accesses routeNum.
     * return: routeNum
     */
    public int getRouteNum() {
        return routeNum;
    }

    // Mutators (Setters)
    /**
     * Changes pokemonInLocation.
     * 
     */
    public void setPokemonInLocation(String [] pokemonInLocation) {
        this.pokemonInLocation = pokemonInLocation;
    }

    /**
     * Changes routeNum.
     * @param routeNum
     */
    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }

    /**
     * This method returns information about the Route
     * in the form of a String
     * @return String Information about the Route
     */
    public String toString(){
        String str = super.toString();
        str += ( "\nRoute Number: "+ routeNum);
        str += ("\nPokemon IDs: ");
        for(int i = 0; i< pokemonInLocation.length; i++){
            str+= pokemonInLocation[i]+", ";
        }
        return str;
    }
    
}
