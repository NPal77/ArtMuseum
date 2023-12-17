/**
 * @author Nishanth Palanisamy
 * CIS 36B
 * write your abstract Art class here
 * 
 */ 
 
public abstract class Art implements Comparable<Art> { //inherits Comparable so must have a compareTo()!
   private String name = "";
   private String artist = "";
   private int year = 0;
   
   /**
    * Default constructor that assigns the values "No name" to name,
    * "No artist" to artist, and -1 to year
    * This default constructor calls the 3-argument constructor
    */
   public Art(){
      this("No name", "No artist", -1);
   }
   
   
   /**
    * 3-argument constructor 
    * @param name    the painting name
    * @param artist  the artist name
    * @param year    the year of completion
    */
   public Art(String name, String artist, int year){
      this.name = name;
      this.artist = artist;
      this.year = year;
   }
   
   /**
    * Copy constructor that makes a copy of another non-null Art object 
    * @param art  the object of Art class that we want to make a copy of
    * 
    * //remember, creating a deep copy is for when the object contains a class 
    * inside it, so an object of a class within an object of a class!
    */
   public Art(Art art){
      if(art != null) {
         this.name = art.name;
         this.artist = art.artist;
         this.year = art.year;   
      }   
   }
   
   /**
    * Getter method for name
    * @return name   the name of the painting
    */
    
   public String getName() {
      return this.name;
   }
    
   /**
    * Getter method for artist
    * @return artist the artist's name
    */
    
   public String getArtist() {
      return this.artist;
   }
    
   /**
    * Getter method for year
    * @return year   the year of the painting
    */
   public int getYear() {
      return this.year;
   }
   
   /**
    * Setter method for name
    */
    
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Setter method for artist
    * @param artist the name of the artist
    */
    
   public void setArtist(String artist) {
      this.artist = artist;
   }
   
   /**
    * Setter method for year
    * @param year the year of the painting
    */
    
   public void setYear(int year) {
      this.year = year;
   }
   
   /**
    * Overriden toString() method that 
    * creates a String of artist, with name and 
    * year tabbed once on subsequent lines
    * @return the String to display
    */
   @Override public String toString() {
      return "\nArtist: " + this.artist + "\n\tName: " + this.name
         + "\n\tYear: " + this.year;
   }
   
   /**
    * Overriden equals() method that compares this Art 
    * to another Object
    * @param obj  the Object object
    * @return boolean whether equality is true or false
    */
   @Override public boolean equals(Object obj) {
      //use the == operator to check if the argument is a reference to this object
      if (this == obj) { //if memory address is the same then no need to check for anything further
         return true;
      } else if (!(obj instanceof Art)) { //if obj is not an Art object, we return false
         return false;
      } else { //now return whether variables within these objects are the same. Cast first!
         Art art = (Art)obj;
         return this.artist.equals(art.artist) && this.name.equals(art.name) 
            && this.year == art.year;
      }  
   }
   /**
    * compares Art object with Art object to test for equality
    * @param a          the Art object
    * @return integer   positive if greater than, negative if less than
    * 
    */
   @Override public int compareTo(Art a) {
      if (this.equals(a)) { //check object vs object for equality
         return 0;
      } else if (!(this.artist.equals(a.artist))) {
         return this.artist.compareTo(a.artist);
      } else if (!(this.name.equals(a.name))) {
         return this.name.compareTo(a.name); 
      } else { //if (this.year != a.year)
         return Integer.compare(year, a.year); //does the order matter?
      } //this method will return 0 if all are equal
   }
}
