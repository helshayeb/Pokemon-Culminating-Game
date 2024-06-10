import java.io.*;
public class MoveDex{
  private int numMoveData;
  private Move[] moveList;
  public boolean readMoves(String fileName){
    try {
      BufferedReader in = new BufferedReader(new FileReader(fileName));
      numMoveData = in.readLine();
      moveList = new Move[numMoveData];
         
      for (int i = 0; i < numItemData; i++) {
        MoveList[i].setMoveTypeName(in.readLine());
        MoveList[i].setMoveName(in.readLine());
        MoveList[i].setId(Integer.parseInt(in.readLine()));
        MoveList[i].setPrice(Double.parseDouble(in.readLine()));
        MoveList[i].setModifer(Double.parseDouble(in.readLine());
      }
      in.close();   
    }catch (IOException iox) {
      System.out.println("Error accessing file");
    }
  }  
}
