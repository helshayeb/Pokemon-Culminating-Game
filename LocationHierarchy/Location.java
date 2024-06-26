package LocationHierarchy;
/**
* Class Name: City
* Author: Kelvin Kim
* Date: June 14th 2024
* School: A. Y. Jackson SS
* Creates Locations that can be travelled to
*/
public class Location {
    /**
    *  Type of region where the location is situated
    */
    private String regionType; 
    /**
    *  Name of the location
    */
    private String name; 
    /**
    *  Unique identifier for the location
    */
    private int locationID; 

    /**
     * Constructs a new Location object with specified type, name, and id.
     * 
     * @param type The type of region where the location is situated.
     * @param name The name of the location.
     * @param id The unique identifier for the location.
     */
    public Location(String type, String name, int id) {
        regionType = type;
        this.name = name;
        locationID = id;
    }

    /**
     * Constructs a new Location object with the specified id.
     * 
     * @param id The unique identifier for the location.
     */
    public Location(int id) {
        locationID = id;
        regionType = null;
        name = null;
    }

    /**
     * Gets the type of region where the location is situated.
     * 
     * @return The region type.
     */
    public String getRegionType() {
        return regionType;
    }

    /**
     * Gets the name of the location.
     * 
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique identifier for the location.
     * 
     * @return The location ID.
     */
    public int getLocationID() {
        return locationID;
    }

    /**
        * This method returns information about the Location
        * in the form of a String
        * @return String Information about the Location
        */
    public String toString(){
        return ("Region Type: " +regionType + "\nName: " + name + "\nID: " +locationID);
    }
}
