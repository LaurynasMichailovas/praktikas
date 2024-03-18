package lt.viko.eif.lmichailovas.logseverity;

import lt.viko.eif.lmichailovas.logseverity.db.DBLoader;
import lt.viko.eif.lmichailovas.logseverity.menu.Menu;

public class Main {
    /**
     * The Main class is the entry point of the Log Severity application.
     * It initializes the database loader and displays the main menu
     */
    public static void main(String[] args) {
        // Initialize database loader
        //new DBLoader();

        // Display the main menu
        Menu.showMenu();
    }
}