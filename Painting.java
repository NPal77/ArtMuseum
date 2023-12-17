/**
 * @author Nishanth Palanisamy
 */
public class Painting extends Art {
    private String medium;
    
    /**
     * default constructor that assigns the values "No name" to name, 
     * "No artist" to artist, -1 to year, 
     * and "No medium" to the medium variable.
     * This default constructor calls the four-argument constructor.
     */
    public Painting() {
       this("No name", "No artist", -1, "No medium");  
    }
    
    /**
     * A four-argument constructor to assign values to the name, 
     * artist, year, and medium variables.
     */
    public Painting(String name, String artist, int year, String medium) {
       super(name, artist, year); //calling the constructor from parent class
       this.medium = medium;
    }
    
    /**
     * Accessor method for private String variable medium
     */
    public String getMedium() {
       return medium;
    }
    
    /**
     * Mutator method for private String variable medium
     * @param medium    the String for the medium of the art
     */
    public void setMedium(String medium) {
       this.medium = medium;
    }
    
    /**
     * Overriden toString() method to display data to now include medium
     * @return the String output in list format
     */
    @Override public String toString() {
       return super.toString() + "\n\tMedium: " + this.medium;
    }
}
