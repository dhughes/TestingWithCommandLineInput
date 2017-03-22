import java.util.Scanner;

/**
 * Created by doug on 3/22/17.
 */
public class MenuService {

    private Scanner scanner;

    public MenuService(Scanner scanner) {

        this.scanner = scanner;
    }

    public int promptForMainMenuSelection() {

        System.out.println("-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit");

        return scanner.nextInt();
    }

    public int promptForAnimalId() {

        System.out.println("Please enter an animal id: ");

        return 0;
    }
}
