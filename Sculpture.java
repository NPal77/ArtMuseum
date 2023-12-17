/**
 * @author Nishanth Palanisamy
 */
public class Sculpture extends Painting {
    private boolean humanForm;
    
    /**
     * A default constructor that assigns the values "No name" to name, 
     * "No artist" to artist, -1 to year, and "No medium" to the medium variable, 
     * and false to the humanForm variable. 
     * This default constructor calls the five argument constructor.
     */
    public Sculpture() {
       this("No name", "No artist", -1, "No medium", false);
    }
    
    /**
     * A five-argument constructor to assign values to the name, artist, year, 
     * medium, and humanForm variables.
     */
    public Sculpture(String name, String artist, int year, String medium, boolean humanForm) {
       super(name, artist, year, medium);
       this.humanForm = humanForm;
    }
    
    /**
     * Accessor method for the private boolean humanForm
     * @return humanForm
     */
    public boolean getHumanForm() {
       return humanForm;
    }
    
    /**
     * Mutator method for the private boolean humanForm
     * @param humanForm    the boolean for if the sculpture is of a human
     */
    public void setHumanForm(boolean humanForm) {
       this.humanForm = humanForm;
    }
    
    /**
     * Overriden toString() method to display output
     * @return String output to this time include humanForm
     */
     
     @Override public String toString() {
        return super.toString() + "\n\tHuman Form: " + this.humanForm;
     }
}
