public class PokeDex {
    double[][] typeCharrt = {{1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 2, 0.5, 1},
            {1, 1, 0.5, 0.5, 1, 1, 2, 1, 1},
            {1, 0, 2, 1, 2, 1, 0.5, 2, 1},
            {1, 1, 1, 1, 0.5, 0.5, 2, 1,  1},
            {1, 1, 1, 2, 2, 0.5, 0.5, 1, 1},
            {1, 0.5, 0.5, 2, 0.5, 2, 0.5, 1, 1},
            {1, 2, 1, 0, 1, 2, 0.5, 0.5, 1},
            {1, 1, 2, 1, 1, 1, 1, 1, 0.5}};

    ItemDex itDex;
    PokemonDex pmDex;
    LocationDex loDex;
    MoveDex mvDex;

    public PokeDex(ItemDex itDex,PokemonDex pmDex, LocationDex loDex,MoveDex mvDex){
        this.itDex = itDex;
        this.loDex = loDex;
        this.mvDex = mvDex;
        this.pmDex = pmDex;
    }



}
