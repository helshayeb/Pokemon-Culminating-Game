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
         numItemData = Integer.parseInt(in.readLine());
         itemList = new Item[PokeDex.MAX_SIZE];
         String itemTypeName, itemName;
         int id, price;
         double modifier;
         
         for (int i = 0; i < numItemData; i++) {
	         in.readLine();
            in.readLine();
            itemTypeName = (in.readLine());
            itemName = (in.readLine());
            id = (Integer.parseInt(in.readLine()));
            price = (Integer.parseInt(in.readLine()));
            modifier = (Double.parseDouble(in.readLine()));
            if (itemTypeName.equals("HealthItem")) {
               itemList[i] = new HealthItem(itemTypeName, itemName, id, price, modifier);
            }
            else if (itemTypeName.equals("AttackItem")) {
               itemList[i] = new AttackItem(itemTypeName, itemName, id, price, modifier);
            }
            else if (itemTypeName.equals("DefenceItem")) {
               itemList[i] = new DefenceItem(itemTypeName, itemName, id, price, modifier);
            }
            else if (itemTypeName.equals("SpeedItem")) {
               itemList[i] = new SpeedItem(itemTypeName, itemName, id, price, modifier);
            }
            else {
               return false;
            }
               
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
	 out.newLine();
         for (int i = 0; i <= numItemData; i++) {
            out.write(itemList[i].getItemTypeName());
	    out.newLine();
            out.write(itemList[i].getItemName());
            out.newLine();
	    out.write(itemList[i].getId());
	    out.newLine();
            out.write(itemList[i].getPrice());
	    out.newLine();
            out.write(String.format("%.2f", itemList[i].getModifier()));
	    out.newLine();
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
      return null;
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
      if (itemList[middle].getId() == id) {
         return itemList[middle];
      } else if (top == bot) {
         return null;
      }else if (itemList[middle].getId() > id) {
         return searchItemById(id, middle - 1, bot);
      } else {
         return searchItemById(id, top, middle + 1);
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
         if (itemList[newId].getItemTypeName().equals("HealthItem")) {
            itemList[newId] = new HealthItem(type, name, newId, price, modifier);
         }
         else if (itemList[newId].getItemTypeName().equals("AttackItem")) {
            itemList[newId] = new AttackItem(type, name, newId, price, modifier);
         }
         else if (itemList[newId].getItemTypeName().equals("DefenceItem")) {
            itemList[newId] = new DefenceItem(type, name, newId, price, modifier);
         }
         else if (itemList[newId].getItemTypeName().equals("SpeedItem")) {
            itemList[newId] = new SpeedItem(type, name, newId, price, modifier);
         }
         else {
            return false;
         }
      
         numItemData ++;
         return true;
      }
   }           
}
