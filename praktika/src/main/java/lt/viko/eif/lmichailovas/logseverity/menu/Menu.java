package lt.viko.eif.lmichailovas.logseverity.menu;

import lt.viko.eif.lmichailovas.logseverity.db.DBLoader;
import lt.viko.eif.lmichailovas.logseverity.db.ObjectLoader;
import lt.viko.eif.lmichailovas.logseverity.model.User;
import lt.viko.eif.lmichailovas.logseverity.server.Server;
import lt.viko.eif.lmichailovas.logseverity.util.JaxbUtil;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class Menu {
    public static int displayMenu(Scanner input){
        System.out.println("Make a selection");
        System.out.println("-----------------");
        System.out.printf("| 1) %20s \n" , "load account logs");
        System.out.printf("| 2) %20s \n" , "Marsheling");
        System.out.printf("| 3) %20s \n" , "Unmarshaling");
        System.out.printf("| 4) %20s \n" , "Server Up");
        System.out.printf("| 5) %20s \n" , "quit");
        return input.nextInt();
    }
    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            userChoice = displayMenu(input);
            switch (userChoice) {
                case 1:
                    DBLoader.loadAccountLogs();
                    break;
                case 2:
                    JaxbUtil.convertToXML(ObjectLoader.objectLoad(User.class,1));
                case 3:
                    try {
                        JaxbUtil.Unmarshaling(ObjectLoader.objectLoad(User.class, 1),"logs.xml");
                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                case 4:
                    Server server = new Server();
                    server.start(7777, "logs.xml");
                case 5:
                    System.out.println("thanks and goodbye");
                    System.exit(0);
                    break;
                default:


            }
        }while (userChoice != 5);
    }
}
