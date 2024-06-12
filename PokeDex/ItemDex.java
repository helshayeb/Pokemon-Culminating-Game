import java.io.*;

/**
 * Represents a database of items with various operations such as reading from file, saving to file, searching by name or ID, and adding items.
 */
public class ItemDex {
   
    /**
    * Number of Items in the program
    */
    private int numItemData; 
   /**
    * List of all items in the program
    */
    private Item[] itemList;

    /**
     * Constructs an ItemDex object with initial number of items set to 0.
     */
    public ItemDex() {
        numItemData = 0;
    }

    /**
     * Retrieves the number of items stored in the ItemDex.
     * 
     * @return The number of items.
     */
    public int getNumItemData() {
        return numItemData;
    }

    /**
     * Sets the number of items in the ItemDex.
     * 
     * @param num The number of items to set.
     */
    public void setNumItemData(int num) {
        numItemData = num;
    }

    /**
     * Retrieves the list of items stored in the ItemDex.
     * 
     * @return The array of Item objects.
     */
    public Item[] getItemList() {
        return itemList;
    }

    /**
     * Reads item data from a file and populates the ItemDex.
     * 
     * @param fileName The name of the file to read from.
     * @return True if reading operation is successful, false otherwise.
     */
    public boolean readItems(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            numItemData = Integer.parseInt(in.readLine()); // Read number of items
            itemList = new Item[PokeDex.MAX_SIZE]; // Initialize itemList array
            String itemTypeName, itemName;
            int id, price;
            double modifier;

            for (int i = 0; i < numItemData; i++) {
                itemTypeName = in.readLine(); // Read item type
                itemName = in.readLine(); // Read item name
                id = Integer.parseInt(in.readLine()); // Read item ID
                price = Integer.parseInt(in.readLine()); // Read item price
                modifier = Double.parseDouble(in.readLine()); // Read item modifier

               if (itemTypeName.equals("AttackItem")) {
                  itemList[i] = new AttackItem(itemTypeName, itemName, id, price, modifier); // Create new AttackItem object and store in itemList
               }
               else if (itemTypeName.equals("DefenceItem")) {
                  itemList[i] = new DefenceItem(itemTypeName, itemName, id, price, modifier); // Create new DefenceItem object and store in itemList
               }
               else if (itemTypeName.equals("HealthItem")) {
                  itemList[i] = new HealthItem(itemTypeName, itemName, id, price, modifier); // Create new HealthItem object and store in itemList
               }
               else if (itemTypeName.equals("SpeedItem")) {
                  itemList[i] = new SpeedItem(itemTypeName, itemName, id, price, modifier); // Create new SpeedItem object and store in itemList
               }
            }
            in.close();
        } catch (IOException iox) {
            System.out.println("Error accessing file");
            return false;
        }
        return true;
    }

    /**
     * Saves the items in the ItemDex to a file.
     * 
     * @param fileName The name of the file to save to.
     * @return True if saving operation is successful, false otherwise.
     */
    public boolean saveItems(String fileName) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(numItemData); // Write number of items to file
            for (int i = 0; i < numItemData; i++) {
                out.write(itemList[i].getItemTypeName()); // Write item type to file
                out.write(itemList[i].getItemName()); // Write item name to file
                out.write(String.valueOf(itemList[i].getId())); // Write item ID to file
                out.write(String.valueOf(itemList[i].getPrice())); // Write item price to file
                out.write(String.valueOf(itemList[i].getModifier())); // Write item modifier to file
            }
            out.close();
            return true;
        } catch (IOException iox) {
            System.out.println("Error writing to file");
            return false;
        }
    }

    /**
     * Searches for an item by its name.
     * 
     * @param name The name of the item to search for.
     * @return The Item object if found, null otherwise.
     */
    public Item searchItemByName(String name) {
        for (int i = 0; i < numItemData; i++) {
            if (itemList[i].getItemName().equals(name)) {
                return itemList[i];
            }
        }
        return null;
    }

    /**
     * Searches for an item by its ID.
     * 
     * @param id The ID of the item to search for.
     * @return The Item object if found, null otherwise.
     */
    public Item searchItemById(int id) {
        return searchItemById(id, numItemData - 1, 0);
    }

    /**
     * Searches for an item by its ID within a specified range.
     * 
     * @param id  The ID of the item to search for.
     * @param top The upper bound index for the search range.
     * @param bot The lower bound index for the search range.
     * @return The Item object if found, null otherwise.
     */
    public Item searchItemById(int id, int top, int bot) {
        int middle = (top + bot) / 2;
        if (itemList[middle].getId() == id) {
            return itemList[middle];
        } else if (top == bot) {
            return null;
        } else if (itemList[middle].getId() < id) {
            return searchItemById(id, middle - 1, bot);
        } else {
            return searchItemById(id, top, middle + 1);
        }
    }

    /**
     * Adds a new item to the ItemDex.
     * 
     * @param type     The type of the item.
     * @param name     The name of the item.
     * @param price    The price of the item.
     * @param modifier The modifier of the item.
     * @return True if addition is successful, false otherwise.
     */
    public boolean addItems(String type, String name, int price, double modifier) {
        if (price < 0 || modifier < 0) {
            return false;
        } else {
            int newId = numItemData;
            itemList[newId] = new Item(type, name, newId, price, modifier); // Create new Item object and add to itemList
            numItemData++;
            return true;
        }
    }
}
