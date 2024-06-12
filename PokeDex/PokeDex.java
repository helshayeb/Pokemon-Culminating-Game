public class PokeDex {
    

    ItemDex itDex;
    PokemonDex pmDex;
    LocationDex loDex;
    MoveDex mvDex;
    public final static int MAX_SIZE = 200;
    public PokeDex(ItemDex itDex,PokemonDex pmDex, LocationDex loDex,MoveDex mvDex){
        this.itDex = itDex;
        this.loDex = loDex;
        this.mvDex = mvDex;
        this.pmDex = pmDex;
    }

    public double getMultiplier(int typeMove, int typeDefender)P
        return typeChart[typeMove][typeDefender];
    }

}
