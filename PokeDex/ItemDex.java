import java.io.*;
public class ItemDex {

   private int numItemData; //Stores the number of items
   private Item[] itemList;
   
   public boolean readItems (String fileName) {
      try {
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         numItemData = in.readLine();
         itemList[] = new Item[numItemData];
         
         for (int i = 0; i < numItemData; i++) {
            itemTypeName
   
   