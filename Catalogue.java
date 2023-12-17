/**
 * Catalogue.java
 * @author Nishanth Palanisamy
 */

import java.io.IOException;
import java.util.Scanner;

public interface Catalogue<T extends Comparable<T>> {
    /**
     * Reads from a file and populates the catalogue
     * @param input the Scanner used to read in the data
     */
    void populateCatalogue(Scanner input) throws IOException;
   
    /**
     * Searches for an element in the catalogue
     * @param t the element to locate
     * @return the location of the element in
     * the catalogue
     */
    int binarySearch(T t);
   
    /**
     * Sorts the catalogue into
     * ascending order using the
     * bubble sort algorithm
     */
    void bubbleSort();
   
    /**
     * Prints a menu of options to interact
     * with the catalogue
     */
    void printMenu();
   
    /**
     * Prints out the current catalogue
     */
    void printStock();
    
    /**
     * Prints out the names of the stock
     * in the catalogue in a numerical list
     */
    void printNames();
    
    /**
     * Inserts an element at the end of the catalogue
     * @param element the new element to insert
     */
     
    void appendElement(T element);
    
    /**
     * Removes an element from the catalogue
     * @param element the element to remove
     * @return whether the element was in the catalogue
     * and was successfully removed
     */
    boolean removeElement(T element);
    
    /**
     * Removes an element from the catalogue
     * @param index the location of the element in the catalogue
     * @throws IndexOutOfBoundsException when the index < 0 
     * or index >= numElements
     * @return the removed element
     */
    T removeElement(int index) throws IndexOutOfBoundsException;
    
    /**
     * Access the element at the specified index in 
     * the catalogue
     * @param index the index of the desired element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException for an invalid index
     */
    public T get(int index) throws IndexOutOfBoundsException;
    
    /**
     * Updates the element at a specified index
     * to be a new element
     * @param index the index to update
     * @param element the new element to replace the
     * existing element at the index
     * @throws IndexOutOfBoundsException for an invalid index
     */
    public void set(int index, T element) throws IndexOutOfBoundsException;
    
}
