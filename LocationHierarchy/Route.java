public class Route extends Location {
  String[] pokemonInLocation;
  int routeNum;

  public Route(String type, String name, int id,String[] pokes, int routeNum){
    super(type, name, id);
    pokemonInLocation = pokes;
    this.routeNum = routeNum;
  }
  
  public Route(int id,String[] pokes, int routeNum){
    super(id);
    pokemonInLocation = pokes;
    this.routeNum = routeNum;
  }
  
   // Accessors (Getters)
  public String[] getPokemonInLocation() {
    return pokemonInLocation;
  }

  public int getRouteNum() {
    return routeNum;
  }

  // Mutators (Setters)
  public void setPokemonInLocation(String[] pokemonInLocation) {
    this.pokemonInLocation = pokemonInLocation;
  }

  public void setRouteNum(int routeNum) {
    this.routeNum = routeNum;
  }
}
