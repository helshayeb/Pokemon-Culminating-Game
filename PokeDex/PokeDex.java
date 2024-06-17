package PokeDex;
/**
* Class Name: Pokedex
* Author: Joint Effort
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates a PokeDex which can be accessed and used to 
* manipulate Moves
*/
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
