import java.io.*;
public class ItemDex {

   private int numItemData; //Stores the number of items
   private Item[] itemList;

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
         itemList[] = new Item[numItemData];
         
         for (int i = 0; i < numItemData; i++) {
            itemList[i].setItemTypeName(in.readLine());
            itemList[i].setItemName(in.readLine());
            itemList[i].setId(Integer.parseInt(in.readLine()));
            itemList[i].setPrice(Double.parseDouble(in.readLine()));
            itemList[i].setModifer(Double.parseDouble(in.readLine());
         }
         in.close();
      }
      catch (IOException iox) {
         System.out.println("Error accessing file");
      }
   }
   
   
   
