import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieCollection collection;

    public void startProgram() throws FileNotFoundException {
        char choice;
        do{
            displayMenu();
            choice = getUserChoice();
            processMenu(choice);
        } while(choice != '6');

        scanner.close();
    }
    private void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Add a movie");
        System.out.println("2. Delete a movie");
        System.out.println("3. Display all movies");
        System.out.println("4. Search for a movie");
        System.out.println("5. Edith the movie");
        System.out.println("6. Exit");
        System.out.println();
        System.out.println("Choose: ");
    }

    private char getUserChoice() {
        return scanner.next().charAt(0);
    }

public String getUserChoiceDisplay() {
        return scanner.next();
}
    private void processMenu(char choice) throws FileNotFoundException {
        switch (choice) {
            case '1':
                controller.addMovie();
                break;
            case '2':
                controller.deleteMovie();
                break;
            case '3':
                System.out.println("Do you want movies sorted by movie title? (yes/no)");
                String userChoice = getUserChoiceDisplay();
                while (!(userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("yes"))) {
                    System.out.println("Incorrect. Please enter 'yes' or 'no'." );
                    userChoice = getUserChoiceDisplay();
                }
                if (userChoice.equalsIgnoreCase("yes")) {
                    Collections.sort(movies, new NameComparator());
                    controller.displayAllMoves();
                } else {

                }

                System.out.println("Input movie title");
                String title = scanner.nextLine();

                String director;
                while (director == null) {
                    try {
                        System.out.println("Input the name of director");
                        director = scanner.nextLine();
                        if (containsNumbers(director)) {
                            throw new InputMismatchException("Director's name cannot contain numbers");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
