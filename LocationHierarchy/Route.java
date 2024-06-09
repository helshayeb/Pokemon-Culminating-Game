
public class Route extends Location {
    int[] pokemonInLocation;
    int numPokemon = 0;
    int routeNum;

    public Route(String type, String name, int routeNum, int id,int[] pokes){
        super(type, name, id);
        pokemonInLocation = pokes;
        this.routeNum = routeNum;
    }

    public Route(String type, String name, int routeNum, int id){
        super(type, name, id);
        pokemonInLocation = new int[10];
        this.routeNum = routeNum;
    }

    public Route(int id, int routeNum,int[] pokes){
        super(id);
        pokemonInLocation = pokes;
        this.routeNum = routeNum;
    }

    // Accessors (Getters)
    public int[] getPokemonInLocation() {
        return pokemonInLocation;
    }

    public int getNumPokemon(){
        return numPokemon;
    }

    public int getRouteNum() {
        return routeNum;
    }

    // Mutators (Setters)
    public void setPokemonInLocation(int[] pokemonInLocation) {
        this.pokemonInLocation = pokemonInLocation;
    }

    public void setRouteNum(int routeNum) {
        this.routeNum = routeNum;
    }
}
