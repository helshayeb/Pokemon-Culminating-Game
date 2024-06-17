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

    /**
 	* Itemdex
	*/
    private ItemDex itDex;

    /**
 	* Pokemondex
	*/
    private PokemonDex pmDex;

    /**
 	* LocationDex
	*/
    private LocationDex loDex;

    /**
 	* MoveDex
	*/
    private MoveDex mvDex;

    /**
 	* Constructor that initializes the fields of the Pokedex class when given its
    * @param ItemDex
    * @param PokemonDex
    * @param LocationDex
    * @param MoveDex
	*/
    public PokeDex (ItemDex iDex, PokemonDex pDex, LocationDex lDex, MoveDex mDex) {
        itDex = iDex;
        pmDex = pDex;
        loDex = lDex;
        mvDex = mDex;
    }

    /**
 	* Accessor for the ItemDex field
    * @return itDex
	*/
    public ItemDex getItemDex () {
        return itDex;
    }

    /**
 	* Accessor for the PokemonDex field
    * @return pmDex
	*/
    public PokemonDex getPokemonDex () {
        return pmDex;
    }

    /**
 	* Accessor for the LocationDex field
    * @return loDex
	*/
    public LocationDex getLocationDex () {
        return loDex;
    }

    /**
 	* Accessor for the MoveDex field
    * @return mvDex
	*/
    public MoveDex getMoveDex () {
        return mvDex;
    }

    /**
 	* Maximum size for databases
	*/
    public final static int MAX_SIZE = 200;

}
