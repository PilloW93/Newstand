import java.util.ArrayList;
import java.util.Iterator;

/**
 *Creates an instance of MagazineRegister
 * Using an arraylist
 *
 * @author PilloW
 * @version 0.3
 */

public class MagazineRegister {
    ArrayList<Magazine> magazineCollection;

    /**
     * Creates a new instance of the Magazine register.
     */
    public MagazineRegister()
    {
        this.magazineCollection = new ArrayList<Magazine>();
    }


    /**
     * Adds a magazine to the magazine register.
     * @param magazine The magazine to add to the register
     */
    public boolean addMagazine(Magazine magazine)
    {
        boolean excisting = noDuplicates(magazine.getTitle());
        boolean wasAdded = false;

        if(!excisting){
            this.magazineCollection.add(magazine);
            wasAdded = true;
        }

        return wasAdded;

    }

    /**
     * Removes a magazine from the register
     * @param magazine The magazine to be removed
     */
    public void removeMagazine(Magazine magazine)
    {this.magazineCollection.remove(magazine); }

    public Iterator<Magazine> getIterator()
    {
        return this.magazineCollection.iterator();
    }

    /**
     * Search function to find magazines by title
     * @param title Title of the magazine
     * @return Returns the magazine which has been found, if found.
     */


    public Magazine findMagazineByTitle (String title) {
        Magazine foundMagazine = null;

        boolean found = false;

        Iterator<Magazine> it = this.magazineCollection.iterator();
        while (it.hasNext() && !found)
        {
            Magazine magazine = it.next();

            if (magazine.getTitle().toLowerCase().equals(title.toLowerCase()))
            {
                foundMagazine = magazine;
                found = true;
            }

        }
        return foundMagazine;
    }

    /**
     * Fills the register with dummies (FOR TESTING ONLY)
     */

    public void putInDummies() {
        Magazine dummy1 = new Magazine("fri flyt", 9);
        this.addMagazine(dummy1);
        Magazine dummy2 = new Magazine("Se og Hør", 19);
        this.addMagazine(dummy2);
        Magazine dummy3 = new Magazine("Vi menn", 23);
        this.addMagazine(dummy3);
    }

    /**
     * Function to check for duplicates in the register
      * @param title Title of the magazine
     * @return Returns true if duplicate is found, otherwise false.
     */

    public boolean noDuplicates(String title)
    {
        Magazine magazine = findMagazineByTitle(title);
        boolean result = false;

        if ( magazine != null) {
            result = true;
        }

        return result;


    }
}







