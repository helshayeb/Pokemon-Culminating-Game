import java.io.*;
import java.util.*;
public class MoveDex{
  private int numMoveData;
  private Move[] moveList;

  public boolean readMoves(String fileName){
    try {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      numMoveData = in.readLine();
      moveList = new Move[PokeDex.MAX_SIZE];
      String objectID;  
      String moveName;
      int moveType;
      int moveID;
      int basePower;
      double hpMod;
      double atkMod;
      double defMod;
      double spdMod;
      double recipient;
      double conditionApplied;
      for (int i = 0; i < numItemData; i++) {
        objectID = in.readLine();
        if(objectID.equalsIgnoreCase("Damage")){
          moveName = in.readLine();
          moveType = Integer.parseInt(in.readLine());
          moveID = Integer.parseInt(in.readLine());
          basePower = Integer.parseInt(in.readLine());
          in.readLine();
          moveList[i] = new DamageMove(objectID, moveName, moveType, moveID, basePower);
        }else if(moveVariation.equalsIgnoreCase("Status")){
          moveName = in.readLine();
          moveType = Integer.parseInt(in.readLine());
          moveID = Integer.parseInt(in.readLine());
          hpMod = Double.parseDouble(in.readLine());
          atkMod = Double.parseDouble(in.readLine());
          defMod = Double.parseDouble(in.readLine());
          spdMod = Double.parseDouble(in.readLine());
          recipient = Integer.parseInt(in.readLine());
          in.readLine()
          moveList[i] = new StatusMove(objectID, moveName, moveType, moveID, hpMod, atkMod, defMod, spdMod, recipient);
        }else if(moveVariation.equalsIgnoreCase("Condition")){
          moveName = in.readLine();
          moveType = Integer.parseInt(in.readLine());
          moveID = Integer.parseInt(in.readLine());
          conditionApplied = Integer.parseInt(in.readLine());
          in.readLine();
          moveList[i] = new DamageMove(objectID, moveName, moveType, moveID, conditionApplied);
        }
      }
      in.close();   
    }catch (IOException iox) {
      System.out.println("Error accessing file");
    }
  }  

  public boolean saveMoves (String fileName) {
    try {
      BufferedWriter out = new BufferedWriter (new FileWriter (fileName));
      out.write(numMoveData);
      for (int i = 0; i <= numItemData; i++) {
        if(moveList[i] instancef DamageMove){
          out.write(moveList[i].getObjectID());
          out.write(moveList[i].getMoveName());
          out.write(moveList[i].getMoveType());
          out.write(moveList[i].getMoveID());
          out.write(moveList[i].getBasePower());
        }else if(moveList[i] instancef StatusMove){
          out.write(moveList[i].getObjectID());
          out.write(moveList[i].getMoveName());
          out.write(moveList[i].getMoveType());
          out.write(moveList[i].getMoveID());
          out.write(moveList[i].getHPMod());
          out.write(moveList[i].getAtkMod());
          out.write(moveList[i].getDefMod());
          out.write(moveList[i].getSpdMod());
          out.write(moveList[i].getRecipient());
        }else if(moveList[i] instancef ConditionMove){
          out.write(moveList[i].getObjectID());
          out.write(moveList[i].getMoveName());
          out.write(moveList[i].getMoveType());
          out.write(moveList[i].getMoveID());
          out.write(moveList[i].getConditionAppliedID());
        }
        out.newLine();
       }
       out.close();
       return true;
    }catch (IOException iox) {
      System.out.println("Error saving file");
      return false;
    }
  }
  
  searchMoveByID(int id){
    int left = 0;
    int right = numMoveData-1;
    searchMoveByID(moveList, id, left, right);
  }

  searchMoveByID(Move[] moveList, int id, int left, int right){
    int mid = left+(right-left)/2;
    if(left>right){
        return null;
    }
    if(moveList[mid] == id){
        return mid;
    }else if(moveList[mid} > target){
      return searchMoveByID(moveList, id, left, mid-1);
    }else{
        return searchMoveByID(moveList, id, mid+1, right);
    }
  }

  public Move searchMoveByName(String name){
    for(int i = 0; i < numMoveData; i++){
      if(moveList[i].equalsIgnoreCase(name)){
        return moveList[i];
      }
    }
    return null; 
  }

  }
// ok guys i think whatever calls this is gonna have to have a switch case that determines which one of these to call
  public boolean addDamageMove(String moveName, int moveType, int moveID, int basePower){
    if(numMoveData >= PokeDex.MAX_SIZE){
      return false;
    }
    mostList[numMoveData] = new DamageMove("Damage", moveName, moveType, moveID, basePower);
    numMoveData++;
    return true;
  }

  public boolean addStatusMove(String moveName, int moveType, int moveID, double hpMod, double atkMod, double defMod, double spdMod, int recipient){
    if(numMoveData >= PokeDex.MAX_SIZE){
      return false;
    }
    mostList[numMoveData] = new StatusMove("Status", moveName, moveType, moveID, hpMod, atkMod, defMod, spdMod, recipient);
    numMoveData++;
    return true;
  }

  public boolean addConditionMove(String moveName, int moveType, int moveID, int conditionAppliedID){
    if(numMoveData >= PokeDex.MAX_SIZE){
      return false;
    }
    mostList[numMoveData] = new StatusMove("Status", moveName, moveType, moveID, int conditionAppliedID);
    numMoveData++;
    return true;
  }
  
}
