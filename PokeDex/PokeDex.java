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
