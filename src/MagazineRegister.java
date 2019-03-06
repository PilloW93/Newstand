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

            if (magazine.getTitle().contains(title))
            {
                foundMagazine = magazine;
                found = true;
            }

        }
        return foundMagazine;
    }
}







