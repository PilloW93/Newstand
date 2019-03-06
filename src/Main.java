/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 *
 * @author Sondre
 * @version 0.2
 */
public class Main
{
    /**
     * The main entry for the application.
     * @param args arguments provided during startup of the application
     */
    public static void main(String[] args)
    {
        UserInterface userInt = new UserInterface();
        userInt.start();
    }
}