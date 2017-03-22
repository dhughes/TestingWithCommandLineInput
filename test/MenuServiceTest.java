import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by doug on 3/22/17.
 */
public class MenuServiceTest {

    ByteArrayOutputStream outputStream;

    @Before
    public void before(){
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(this.outputStream);
        System.setOut(printStream);
    }

    @Test
    /**
     * Given a menu service
     * When a user is prompted for a main menu selection and they choose 3
     * Then the value returned is 3
     */
    public void whenMenuSelectionIs3Then3(){
        // Arrange
        String input = "3";
        Scanner scanner = new Scanner(input);

        MenuService service = new MenuService(scanner);

        // Act
        int selection = service.promptForMainMenuSelection();

        // Assert
        assertThat(selection, equalTo(3));
    }

    @Test
    /**
     * Given a menu service
     * When a user is prompted for a main menu selection and they choose 2
     * Then the value returned is 2
     */
    public void whenMenuSelectionIs2Then2(){
        // Arrange
        String input = "2";
        Scanner scanner = new Scanner(input);

        MenuService service = new MenuService(scanner);

        // Act
        int selection = service.promptForMainMenuSelection();

        // Assert
        assertThat(selection, equalTo(2));
    }

    @Test
    /**
     * Give a menu service
     * When the user is prompted for a selection
     * Then the main menu is displayed
     */
    public void whenPromptedThenMenuDisplayed(){
        // Arrange
        String input = "2";
        Scanner scanner = new Scanner(input);

        MenuService service = new MenuService(scanner);

        // Act
        service.promptForMainMenuSelection();

        // Assert
        assertThat(outputStream.toString().trim(), containsString("Main Menu"));
        assertThat(outputStream.toString().trim(), containsString("1) List animals"));
        assertThat(outputStream.toString().trim(), containsString("2) Create an animal"));
        assertThat(outputStream.toString().trim(), containsString("3) View animal details"));
        assertThat(outputStream.toString().trim(), containsString("4) Edit an animal"));
        assertThat(outputStream.toString().trim(), containsString("5) Delete an animal"));
        assertThat(outputStream.toString().trim(), containsString("6) Quit"));
    }

    // todo Test prompting for main menu with string input
    // todo Test prompting for main menu with out of range number

    @Test
    /**
     * Given an menu service
     * When a user is prompted for an animal id
     * Then a prompt is output
     */
    public void whenPromptedForAnimalPromptIsDisplayed(){
        // Arrange
        String input = "2";
        Scanner scanner = new Scanner(input);

        MenuService service = new MenuService(scanner);

        // Act
        int animalId = service.promptForAnimalId();

        // Asserting
        assertThat(outputStream.toString().trim(), containsString("Please enter an animal id:"));
    }


}
