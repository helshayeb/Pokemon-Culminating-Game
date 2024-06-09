public class Location{
  private String regionType;
  private String name;
  private int locationID;

  public Location(String type, String name, int id){
    regionType = type;
    this.name = name;
    locationID = id;
  }

  public Location(int id){
    locationID = id;
    regionType = null;
    name = null;
  }

  public String getRegionType(){
    return regionType;
  }

  public String getName(){
    return name;
  }

  public int getLocationID(){
    return locationID;
  }

}
