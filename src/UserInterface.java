/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * @author PilloW
 * @version 0.3
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;


public class UserInterface {

    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
            "1. List all magazines",
            "2. Add magazine",
            "3. Find a magazine by title",
            "4. TEST:Fill with dummy magazines",
            "5. Remove magazine"
    };

    private MagazineRegister magazineReg;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public UserInterface()
    {
        this.magazineReg = new MagazineRegister();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {
                int menuSelection = this.showMenu();
                switch (menuSelection)
                {
                    case 1:
                        this.listAllMagazines();
                        break;

                    case 2:
                        this.addNewMagazine();
                        break;

                    case 3:
                        this.findMagazineByTitle();
                        break;

                    case 4:
                        fillWithDummies();
                        break;

                    case 5:
                        deleteMagazine();
                        break;

                    case 6:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException
    {
        //System.out.println("\n**** Application v0.2 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber))
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     * checks if register is empty, and if it is prints error.
     */
    private void listAllMagazines()
    {
        int magazineCount = magazineReg.magazineCollection.size();
        System.out.println("There is a total of: " + magazineCount + " magazines in the register");

        Iterator<Magazine> magplistIt = this.magazineReg.getIterator();
        while ( magplistIt.hasNext() )
        {
            Magazine magazine = magplistIt.next();

            System.out.println("//#################\\\n"
                    + "Title: " + magazine.getTitle()
                    + "\n No of issues: " + magazine.getNumberOfYearlyIssues());
        }

        if (! magplistIt.hasNext()) {
            System.out.println("\"//#################\\\n" + "* No/ no more magazines in the register *");
        }

    }


    /**
     * Adds a new literature to the register by input from user
     * Check for duplicates, if duplicate found no add.
     * @param title Title of the magazine
     * @param numberOfIssuePrYear The issue number of the magazine
     */
    private void addNewMagazine()
    {
        // User have chosen to add a Magazine
        System.out.println("Enter title: ");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();

        System.out.println("Please enter the number of issues: ");
        int numberOfIssuesPrYear = reader.nextInt();
        /* Adds magazine to the register */
        Magazine magazine = new Magazine(title, numberOfIssuesPrYear);

        /* Check if it has already been added */
        boolean wasAdded = this.magazineReg.addMagazine(magazine);
        //If it gets added (no duplicates) print message.
        if (wasAdded) {
            System.out.println("Magazine successfully added with title: " +
                    title +
                    " and number of issue: "
                    + numberOfIssuesPrYear);
        }
        // if it doesn't get added (because there is duplicate in register) print message:
      else {
            System.out.println("Magazine is already existing, please try a different one");
        }

    }

    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findMagazineByTitle()   {
        System.out.println("Enter search word: ");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine().toLowerCase();
        Magazine found = this.magazineReg.findMagazineByTitle(title);

        if (found == null){
            System.out.println("Search result: No magazine found");
        } else {
            System.out.println("Search result: " + found.getTitle() + "\n   No of issues: " + found.getNumberOfYearlyIssues());
        }

    }
    /**
     * Removes a magazine to the register by input from user
     * by input from user.
     */
    private void deleteMagazine()
    {
        System.out.println("Enter magazine title to delete: ");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine().toLowerCase();
        Magazine found = this.magazineReg.findMagazineByTitle(title);

        if (found == null){
            System.out.println("Search result: No magazine found to delete");
        } else {
            System.out.println(found.getTitle() + " was successfully deleted ");
            magazineReg.removeMagazine(found);
        }

    }

    /**
     * Fills the register with dummy magazines (FOR TESTING ONLY)
     * Prints message to confirm that dummies are added.
     */

private void fillWithDummies()
{
    this.magazineReg.putInDummies();
    System.out.println("* Dummies successfully added to register *");
}


}

