public class PokeDex {
    double[][] typeChart = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 0.5, 1},
            {1, 1, 0.5, 0.5, 1, 1, 2, 1, 1},
            {1, 0, 2, 1, 2, 1, 0.5, 2, 1},
            {1, 1, 1, 1, 0.5, 0.5, 2, 1,  1},
            {1, 1, 1, 2, 2, 0.5, 0.5, 1, 1},
            {1, 0.5, 0.5, 2, 0.5, 2, 0.5, 1, 1},
            {1, 2, 1, 0, 1, 2, 0.5, 0.5, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 0.5}};

    private ItemDex itDex;
    private PokemonDex pmDex;
    private LocationDex loDex;
    private MoveDex mvDex;

    public ItemDex getItemDex () {
        return itDex;
    }

    public ItemDex getPokemonDex () {
        return pmDex;
    }

    public ItemDex getLocationDex () {
        return loDex;
    }

    public ItemDex getMoveDex () {
        return mvDex;
    }

    public final static int MAX_SIZE = 200;
    public PokeDex(ItemDex itDex,PokemonDex pmDex, LocationDex loDex,MoveDex mvDex){
        this.itDex = itDex;
        this.loDex = loDex;
        this.mvDex = mvDex;
        this.pmDex = pmDex;
    }

    public double getMultiplier(int typeMove, int typeDefender) {
        return typeChart[typeMove][typeDefender];
    }

}
