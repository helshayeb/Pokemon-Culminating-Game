import java.io.*;
public class ItemDex {

   private int numItemData; //Stores the number of items
   private Item[] itemList;

   public ItemDex () {
      numItemData = 0;
   }

   public int getNumItemData() {
      return numItemData;
   }
   public void setNumItemData(int num) {
      numItemData = num;
   }
   
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
   
   public Item searchItemByName (String name) {
      for (int i = 0; i < numItemData; i++) {
         if ((itemList[i].getItemName()).equals(name)) {
            return itemList[i];
         }
      }
   }

   public Item searchItemById (int id) {
      return searchItemById (id, numItemData-1, 0);
   }

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
   
   
   
