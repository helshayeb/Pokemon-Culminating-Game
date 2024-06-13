package LocationHierarchy;

public class Route extends Location {
    int[] pokemonInLocation;
    int numPokemon = 0;
    int routeNum;

    /**
     * Constructs a new Route object with specified type, name, id, pokes(list of pokemon).
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public Route(String type, String name, int routeNum, int id,int[] pokes){
        super(type, name, id);
        pokemonInLocation = pokes;
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
        pokemonInLocation = new int[200];
        this.routeNum = routeNum;
    }

    /**
     * Constructs a new Route object with specified type, name, id.
     * 
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public Route(int id, int routeNum,int[] pokes){
        super(id);
        pokemonInLocation = pokes;
        this.routeNum = routeNum;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     * 
     * @param id The unique identifier for the location.
     * @param pokes The list of pokemon ids
     */
    public int[] getPokemonInLocation() {
        return pokemonInLocation;
    }

    // Accessors (Getters)
    /**
     * Accesses pokemonInLocation.
     * 
     */
    public int getNumPokemon(){
        return numPokemon;
    }

    /**
     * Accesses routeNum.
     * 
     */
    public int getRouteNum() {
        return routeNum;
    }

    // Mutators (Setters)
    /**
     * Changes pokemonInLocation.
     * 
     */
    public void setPokemonInLocation(int[] pokemonInLocation) {
        this.pokemonInLocation = pokemonInLocation;
    }

    /**
     * Changes routeNum.
     * 
     */
    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }

    /**
     * This method returns information about the Condition Move
     * in the form of a String
     * @return String Information about the Move
     */
    public String toString(){
        String str = super.toString();
        str += ( "\nRoute Number: "+ routeNum);
        str += ("\nPokemon IDs: ")
        for(int i = 0; i< pokemonInLocation.length; i++){
            str+= pokemonInLocation[i]+", ";
        }
    }
    
}
