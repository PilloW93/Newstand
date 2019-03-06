import java.util.ArrayList;
import java.util.Iterator;

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
    public void addMagazine(Magazine magazine)
    {
        this.magazineCollection.add(magazine);
    }

    public void removeMagazine(Magazine magazine) {this.magazineCollection.remove(magazine); }

    public Iterator<Magazine> getIterator()
    {
        return this.magazineCollection.iterator();
    }



    public Magazine findMagazineByTitle (String title) {
        Magazine foundMagazine = null;

        boolean found = false;

        Iterator<Magazine> it = this.magazineCollection.iterator();
        while (it.hasNext() && !found)
        {
            Magazine magazine = it.next();

            if (magazine.getTitle().toLowerCase().contains(title))
            {
                foundMagazine = magazine;
                found = true;
            }

        }
        return foundMagazine;
    }


    public void putInDummies() {
        Magazine dummy1 = new Magazine("fri flyt", 9);
        this.addMagazine(dummy1);
        Magazine dummy2 = new Magazine("Se og Hør", 19);
        this.addMagazine(dummy2);
        Magazine dummy3 = new Magazine("Vi menn", 23);
        this.addMagazine(dummy3);
    }
}







