import java.io.*;
public class MoveDex{
  private int numMoveData;
  private Move[] moveList;
  public boolean readMoves(String fileName){
    try {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      numMoveData = in.readLine();
      moveList = new Move[numMoveData];
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
}
