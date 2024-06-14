package PokeDex;

public class PokeDex {

    private ItemDex itDex;
    private PokemonDex pmDex;
    private LocationDex loDex;
    private MoveDex mvDex;

    public PokeDex (ItemDex iDex, PokemonDex pDex, LocationDex lDex, MoveDex mDex) {
        itDex = iDex;
        pmDex = pDex;
        loDex = lDex;
        mvDex = mDex;
    }

    public ItemDex getItemDex () {
        return itDex;
    }

    public PokemonDex getPokemonDex () {
        return pmDex;
    }

    public LocationDex getLocationDex () {
        return loDex;
    }

    public MoveDex getMoveDex () {
        return mvDex;
    }

    public final static int MAX_SIZE = 200;

}
