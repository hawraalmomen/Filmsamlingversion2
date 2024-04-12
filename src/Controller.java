import java.util.Scanner;

public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private MovieCollection collection = new MovieCollection();

    public void addMovie() {
        MovieCollection.addMovie(collection, scanner);

    }

    public void deleteMovie() {
        MovieCollection MovieCollection;
        MovieCollection.deleteMovie(collection, scanner);
    }

    public void displayAllMoves() {
        collection.displayMovies();

    }
}
