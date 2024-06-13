package PokeDex;

import ItemHierarchy.*;
import java.io.*;

/**
* Creates a PokeDex which can be accessed and used to 
* manipulate Items
*/
public class ItemDex {

    /**
 	* Amount of items in the database
	*/
   private int numItemData; 

   /**
 	* Array of items
	*/
   private Item[] itemList;

   /**
	* This method is a constructor that initializes the fields of
	* the ItemDex class
 	*/
   public ItemDex () {
      numItemData = 0;
   }

   /**
	* This method is an accessor that gets the number of items in
	* the ItemDex class
 	*/
   public int getNumItemData() {
      return numItemData;
   }

   /**
	* This method is an mutator that sets the number of items in
	* the ItemDex class
 	*/
   public void setNumItemData(int num) {
      numItemData = num;
   }

   /**
	* This method is an accessor that gets the list of items in
	* the ItemDex class
 	*/
   public Item[] getItemList () {
      return itemList;
   }

   /**
 	* This method uses BufferedReader to read in information from a text file given
   * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
   public boolean readItems (String fileName) {
      try {
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         numItemData = in.readLine();
         itemList = new Item[PokeDex.MAX_SIZE];
         String itemTypeName, ItemName;
         int id, price;
         double modifier;
         
         for (int i = 0; i < numItemData; i++) {
            itemTypeName = (in.readLine());
            itemName = (in.readLine());
            id = (Integer.parseInt(in.readLine()));
            price = (Integer.parseInt(in.readLine()));
            modifer = (Double.parseDouble(in.readLine());
            itemList[i] = Item (itemTypeName, name, id, price, modifier);
         }
         in.close();
      }
      catch (IOException iox) {
         System.out.println("Error accessing file");
         return false;
      }
      return true;
   }

   /**
 	* This method uses BufferedWriter to write information from moveList to the given
   * @param fileName Name of the file being read
	* @return True if successful, false if it fails to fully read the text file
	*/
   public boolean saveItems (String fileName) {
      try {
         BufferedWriter out = new BufferedWriter (new FileWriter (fileName));
         out.write(numItemData);
         for (int i = 0; i <= numItemData; i++) {
            out.write(itemList[i].getItemTypeName());
            out.write(itemList[i].getItemName());
            out.write(itemList[i].getId());
            out.write(itemList[i].getPrice());
            out.write(itemList[i].getModifier());
         }
         out.close();
         return true;
      }
      catch (IOException iox) {
         System.out.println("Error reading file");
         return false;
      }
   }

   /**
 	* This method uses sequential search to search for an item given
	* @param name Name of the item being searched for
	* @return Item if successful, null if not
	*/
   public Item searchItemByName (String name) {
      for (int i = 0; i < numItemData; i++) {
         if ((itemList[i].getItemName()).equals(name)) {
            return itemList[i];
         }
      }
   }

   /**
 	* This method is a wrapper method used to search for an item given
	* @param id ID of the item being searched for
	* @return Item if successful, null if not
	*/
   public Item searchItemById (int id) {
      return searchItemById (id, numItemData-1, 0);
   }

   /**
 	* This method uses recursive binary search to search for an item given
	* @param id ID of the Move being searched
 	* @param top Top bound
 	* @param bot Bottom bound
	* @return Item if successful, null if not
	*/
   public Item searchItemById (int id, int top, int bot) {
      int middle = (top + bot) / 2;
      if (itemList[middle] == id) {
         return itemList[middle];
      } else if (top == bot) {
         return null;
      }else if (itemList[middle] < id) {
         searchItemById(id, middle - 1, bot);
      } else {
         searchItemById(id, top, middle + 1);
         }
   }

   /**
* This method adds an item to the list of items when given
* @param type Type of the Item 
* @param name Name of the Item 
* @param price Price of the Item
* @param modifier Modifier of the Item
* @return true if successful, false if not
*/
   public boolean addItems (String type, String name, int price, double modifier) {
      int newId = numItemData;
      if (price < 0 || modifier < 0) {
         return false;
      }
      else {
         itemList[newId] = Item (type, name, newId, price, modifier);
         numItemData ++;
         return true;
      }
   }           
   }
