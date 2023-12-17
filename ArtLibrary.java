/**
 * @author Nishanth Palanisamy
 */

import java.io.IOException;
import java.util.Scanner;

public class ArtLibrary implements Catalogue<Art> { 
    
    private Art[] artworks;
    private int numWorks;
    
    /**
     * Initializes artworks to a default size of 10
     * and numWorks to 0
     */
    public ArtLibrary() {
       artworks = new Art[10];
       numWorks = 0;
        
    }
 
    /**
     * Initializes artworks to the given size
     * and numWorks to 0
     * @param size the size of the array
     * @throws IllegalArgumentException if size
     * is negative
     */
    public ArtLibrary(int size) throws IllegalArgumentException{
       if(size >= 0) {
          this.artworks = new Art[size];
       } else {
          throw new IllegalArgumentException("ArtLibrary constructor; Enter a non-negative number!");  
       }
    }
    
    /**
     * Increases the size of artworks by 10
     * more than its current length by creating
     * a new array, copying the data from the old
     * array into the new array and then assigning
     * the new array to become artworks.
     * numWorks remains unchanged
     * Used when array is full and a new element
     * needs to be added
     */
    private void resize() {
       
       final int TEN = 10;
       int newLength = artworks.length + TEN;
       Art[] artworks2 = new Art[newLength];
       
       for(int i = 0; i < artworks.length; i++) {
          artworks2[i] = artworks[i];
       } 
       artworks = artworks2; 
    }
    
    /**
     * Reads from a file and populates the catalogue
     * @param input the Scanner used to read in the data
     */
    @Override public void populateCatalogue(Scanner input) throws IOException {
       String name, artist, medium = "";
       int year = 0;  
       boolean humanForm= false;
       
       int index = 0; //for count
       
       while(input.hasNextLine()) {
          
          if(input.nextLine().equalsIgnoreCase("sculpture")) { 
             name = input.nextLine(); //1. name
             artist = input.nextLine(); //2. artist
             year = Integer.parseInt(input.nextLine()); //3. year
             //input.nextLine(); //catch the enter key
             medium = input.nextLine(); //4. medium
             humanForm = Boolean.parseBoolean(input.nextLine());//input.nextBoolean(); //5. if human form
            
             
             //create a new object of Sculpture class with the 5 member vars
             Art sculpture = new Sculpture(name, artist, year, medium, humanForm); //polymorphism
             
             artworks[index] = sculpture;
          } else {
             name = input.nextLine(); //1. name
             artist = input.nextLine(); //2. artist
             year = Integer.parseInt(input.nextLine());//input.nextInt(); //3. year
             //input.nextLine(); //catch the enter key
             medium = input.nextLine(); //4. medium
             //input.nextLine(); //catch the enter key not needed bc see line 76
             
             //create a new object of Painting class with the 4 member vars
             Art painting = new Painting(name, artist, year, medium);
             
             artworks[index] = painting;
          }
          index++; //advance this index to create object in next position in array named artworks
       }  
       numWorks = index; //sets the number of works
    }
   
    /**
     * Searches for an element in the catalogue
     * @param t the element to locate
     * @return the location of the element in
     * the catalogue
     */
    @Override public int binarySearch(Art t) { 
       int low = 0; //changed T to Art above, in order to even compile
       int mid = 0;
       int high = numWorks - 1; //artworks.length - 1 or numWorks - 1?
       
       while(low <= high) {
          mid = (low + high) / 2;
          
          if (artworks[mid].compareTo(t) > 0) { //comparing Art object in artworks[] vs Art object
             high = mid - 1;
          } else if(artworks[mid].compareTo(t) < 0) {
             low = mid + 1;
          } else {
             return mid;
          }
       }
       return -1;
    }
   
    /**
     * Sorts the catalogue into
     * ascending order using the
     * bubble sort algorithm
     */
    @Override public void bubbleSort() {
       for(int i = 0; i < numWorks - 1; i++) {
          for(int j = 0; j < numWorks - i - 1; j++) {
             if(artworks[j].compareTo(artworks[j + 1]) > 0) { 
                Art temp = artworks[j]; //create temp object because you're working with objects
                artworks[j] = artworks[j + 1];
                artworks[j + 1] = temp;
             }             
          }  
       } 
    }
   
    /**
     * Prints a menu of options to interact
     * with the catalogue
     */
    @Override public void printMenu() {
       System.out.println("\nPlease select from one of the options: \n");
       System.out.println("V. View Entire Catalogue");
       System.out.println("A. Add a New Work");
       System.out.println("R. Remove a Work ");
       System.out.println("F. Find a Work of Art");
       System.out.println("U. Update a Work of Art ");
       System.out.println("X. Exit\n");
    }
   
    /**
     * Prints out the current catalogue
     */
    @Override public void printStock() { 
       System.out.println("Our Catalogue: ");
       for(int i = 0; i < numWorks; i++) {
          System.out.print(artworks[i].toString() + "\n\n");
       }
    }
    
    /**
     * Prints out the names of the stock
     * in the catalogue in a numerical list
     */
    @Override public void printNames() {
       for(int i = 0; i < numWorks; i++) {
          System.out.println(i + ". " + artworks[i].getName() + " by " + artworks[i].getArtist());
       }
    }
    
    /**
     * Inserts an element at the end of the catalogue
     * @param element the new element to insert
     */
     
    @Override public void appendElement(Art element) { 
       if(numWorks >= artworks.length) { 
          //artworks[artworks.length - 1] = element;
          resize(); //not artworks.resize();?
       } 
       int indexToAdd = numWorks; //index that's one position after the last (filled) position
       artworks[indexToAdd] = element; //add the element in that index
   
       numWorks++;
    }
    
    /**
     * Removes an element from the catalogue
     * @param element the element to remove
     * @return whether the element was in the catalogue
     * and was successfully removed
     */
    @Override public boolean removeElement(Art element) {
       
       bubbleSort();
       int find = binarySearch(element);
       if(find == -1){
          return false;
       }
       else {
          removeElement(find); 
          return true;
       }
    }
       
    /**
     * Removes an element from the catalogue
     * @param index the location of the element in the catalogue
     * @throws IndexOutOfBoundsException when the index < 0 
     * or index >= numElements
     * @return the removed element
     */
    @Override public Art removeElement(int index) throws IndexOutOfBoundsException { //option 1 in main
       Art elementToRemove = null;
       if(index < 0 || index >= numWorks) { // use numWorks instead of artworks.length
          throw new IndexOutOfBoundsException("Could not remove the artwork at index " + index + "." 
            + "\nPlease try again.");
       } else {
          elementToRemove = artworks[index];
          for(int i = index; i < numWorks; i++) {
             artworks[i] = artworks[i + 1]; 
          }
       }
       numWorks--; //only need to do this once because this method is being called by other removeElement
       return elementToRemove; //return this Art object into Art object named art in main, where called    
    }

    /**
     * Access the element at the specified index in 
     * the catalogue
     * @param index the index of the desired element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException for an invalid index
     */
    @Override public Art get(int index) throws IndexOutOfBoundsException { //changed T to Art
       if(index < 0 || index >= numWorks) {
          throw new IndexOutOfBoundsException("Could not access the artwork at index " + index + "."
            + "\nPlease try again.");
       } else {
          return artworks[index]; //returning an object of Art type from the array named artworks[]
       }
    }
    
    /**
     * Updates the element at a specified index
     * to be a new element
     * @param index the index to update
     * @param element the new element to replace the
     * existing element at the index
     * @throws IndexOutOfBoundsException for an invalid index
     */
    @Override public void set(int index, Art element) throws IndexOutOfBoundsException { 
       if(index < 0 || index >= artworks.length) {
          throw new IndexOutOfBoundsException("Could not update the artwork at index " + index + "."
            + "\nPlease try again.");
       } else {
          artworks[index]= element; //setting an object of Art type in array named artworks[]
          //artworks[index].set(element); //but what if original object of that index is Sculpture type
       }
    }
}
