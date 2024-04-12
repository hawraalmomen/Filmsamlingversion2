import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MovieCollection {
    static List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public static void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movies.add(movie);

    }

    public void deleteMovie(String title) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Movie '" + title + "' deleted successfully!");
                return;
            }
        }
        System.out.println("Movie '" + title + "' is not found!");
    }

    public static List<Movie> searchMovies(String title) {
        List<Movie> searchResult = new ArrayList<>();

        if (movies.isEmpty()) {
            return null;
        } else {
            boolean found = false;
            for (Movie movie : movies) {
                if (movie.getTitle().toLowerCase().contains(title.toLowerCase()) || title.equalsIgnoreCase("all")) {
                    searchResult.add(movie);
                    found = true;
                }
            }
            if (!found) {
                return new ArrayList<>();
            }
        }
        return searchResult;
    }

    public static List<Movie> seachMoviesByGenre(String genre) {
        List<Movie> searchResult = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {

            }
        }
        return searchResult;
    }

    public static Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public static void displayMoviesSortedByTitle() {
        ArrayList<Movie> movies = loadMoviesFromTheFile("movies,csv");
        if (movies.isEmpty()) {
            System.out.println("There are no moves in the collection.");
        } else {
            Collections.sort(movies, new NameComparator());
            System.out.println("Movies in the collection (sorted by name");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }

    public static void displayMoviesSortedByAttributes(String primaryAttribute, String secondaryAttribute) {
        ArrayList<Movie> movies = loadMoviesFromTheFile("movies.csv");
        if (movies.isEmpty()) {
            System.out.println("There are no movies in the collection.");
        } else {
            Comparator<Movie> primaryComparator = new MovieComparator(primaryAttribute, secondaryAttribute);

            Collections.sort(movies, primaryComparator);

            System.out.println("Movies in the collection (sorted by  + primaryAttribute + "then by" + secondaryAttribute + ");
            for (Movie movie : movies) {
                System.out.println(movie.toString());

            }
        }
    }

    private static Comparator<Movie> getComparatorForAttribute(String attribute) {
        switch (attribute.toLowerCase()) {
            case "title":
                return new NameComparator();
            case "director":
                return new DirectorComparator();
            case "genre":
                return new GenreComparator();
            case "year":
                return new YearComparator();
            case "color":
                return new ColorComparator();
            case "length":
                return new LengthComparator();
            default:
                return new NameComparator();

        }
    }
}

public static void displayMoviesSortedByChoice(String choice) {
    List<Movie> movies = loadMoviesFromTheFile("movies.csv");
    if (movies.isEmpty()) {
        System.out.print("There are no movies in the collection.");
    }else{
        Collections.sort(movies, new Comparator(choice));
        System.out.print("Movies in the collection (sorted by " + choice +")");
        for (Movie movie : movies) {
            System.out.print(movie.toString());

        }
    }
}

public static void displayMovies() {
    ArrayList<Movie> movies = loadMoviesFromTheFile("movies.csv");
    if (movies.isEmpty()) {
        System.out.print("There are no movies in the collection");
    }else {
       System.out.print("Movies in the collection:");
       for (Movie movie : movies {
           System.out.print(movies.toString());
        }
    }
}
public static ArrayList<Movie> loadMoviesFromTheFile(String fileName) {
    ArrayList<Movie> movies = new ArrayList<>();
    File file = new File(fileName);
    if (!file.exists()) {
        System.out.print("This file does not exist.");
        return movies;

    }
    try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
        String[] parts = line.split(";");
        if (parts.length >= 6) {
            String title = parts[0];
            String director = parts[1];
            int yearCreated = Integer.parseInt(parts[2]);
            boolean isInColor = Boolean.parseBoolean([3]);
            double lengthInMinutes = Double.parseDouble([4]);
            String genre = parts[5];
            Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
            movies.add(movie);
        } else {
            System.out.print("Invalid data format: " + line);
        }
    }

} catch (FileNotFoundException e) {
    System.out.print("File not found: " + fileName);
} catch (IOException e) {
        throw new RuntimeException(e);
}
 return movies;

}

public static void addMovie(MovieCollection collection, Scanner scanner) {
    System.out.println();
    System.out.println("Enter the title of the movie: ");
    String title = scanner.nextLine();

    System.out.println();
    String director;
    while (true) {
        try {
            System.out.println("Enter the name of the director: ");
            director = scanner.nextLine();
            if (containsNumbers(director)) {
                throw new InputMismatchException("The name of the director cannot contain numbers");
            }
            break;
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    System.out.println();
    int yearCreated;
    while (true) {
        try {
            System.out.println("Enter the year the movies was released");
            yearCreated = scanner.nextInt();
            scanner.nextLine();
            break;
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Not valid. Kindly, enter a valid year.");
            scanner.nextLine();
        }
    }

    System.out.println();
    boolean isInColor;
    while (true) {
        System.out.println("Is the movie in color? (yes/no):");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("yes")) {
            isInColor = true;
            break;
        } else if (input.equals("no")) {
            isInColor = false;
            break;
        } else {
            System.out.println();
            System.out.println("Invalid input. Kindly enter 'yes' or 'no'.");
            System.out.println();
        }
    }

    System.out.println();
    double lengthInMinutes;
    while (true) {
        try {
            System.out.println("How long the movie take?: ");
            lengthInMinutes = scanner.nextDouble();
            scanner.nextLine();
            break;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Kindly enter a valid length in minutes.");
            scanner.nextLine();

        }
    }

    System.out.println();
    System.out.println("What is the genre of this movie?: ");
    String genre = scanner.nextLine();

    collection.addMovie(title,director, yearCreated, isInColor, lengthInMinutes, genre);
    System.out.println("Movie added successfully!");
    System.out.println();
    saveMoviesToTheFile();
}

public static void saveMoviesToTheFile() {
    try (PrintWriter output = new PrintWriter(new FileWriter("movies.csv", true))) {
        for (Movie movie : movies) {
            output.print(movie.getTitle() + ";");
            output.print(movie.getDirector() + ";");
            output.print(movie.getYearCreated() + ";");
            output.print((movie.isInColor() ? "yes" : "no") + ";");
            output.print(movie.getLengthInMinutes() + ";");
            output.println(movie.getGenre());
            System.out.println(movie.getTitle() + " has been saved to movies.csv");
        }
    }

    static void deleteMovie (MovieCollection collection, Scanner scanner){
        System.out.println();
        System.out.println("Enter the title of the movie to delete it: ");
        String title = scanner.nextLine();
        collection.deleteMovie(title);
        System.out.print();

    }
    static void searchMovie (MovieCollection collection, Scanner scanner){
        System.out.println();
        System.out.println("Do you want to search the by the 'title' or 'genre'?: ");
        String searchType = scanner.nextLine().toLowerCase();

        if (searchType.equals("title")) {
            System.out.println("Enter the title of the movie: ");
            String title = scanner.nexLine();
            String searchResult = collection.searchMovies(title).toString();
            System.out.println(searchResult);
        } else if (searchType.equals("genre")) {
            System.out.println("Enter the genre of the movies: ");
            String genre = scanner.nextLine();
            String searchResult = collection.searchMoviesByGenre(genre).toString();
            System.out.println(searchResult);
        }
        System.out.println();
    }
    static void editMovie (MovieCollection collection, Scanner scanner){
        System.out.println("Enter the title of the movie: ");
        String title = scanner.nextLine();
        System.out.println();

        Movie movie = collection.getMovieByTitle(title);
        if (movie != null) {
            System.out.println("Enter new title: ");
            String newTitle = scanner.nextLine();
            movie.setTitle(newTitle);
            System.out.println();

            System.out.println("Enter the new director's name: ");
            String newDirector = scanner.nextLine();
            movie.setDirector(newDirector);
            System.out.println();

            System.out.println("Enter new release year: ");
            int newYearCreated = scanner.nextInt();
            movie.setYearCreated(newYearCreated);
            System.out.println();

            System.out.println("Is the movie in color? (Yes/No): ");
            boolean newIsInColor;
            while (true) {
                String colorInput = scanner.next().toLowerCase();
                if (colorInput.equals("yes") || colorInput.equals("no")) {
                    newIsInColor = colorInput.equals("yes");
                    break;
                } else {
                    System.out.println("Incorrect. Please enter 'Yes' or 'No'.");
                }
                movie.setIsInColor(newIsInColor);
                System.out.println();

                System.out.println("Enter the length of the new movie: ");
                double newLengthInMinutes;
                while (true) {
                    try {
                        newLengthInMinutes = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect! Enter the valid length in minutes.");
                        scanner.nextLine();
                    }
                }
                movie.setLengthInMinutes(newLengthInMinutes);
                System.out.println();

                System.out.println("Enter the genre of the new movie: ");
                String newGenre = scanner.nextLine();
                movie.setGenre(newGenre);

                System.out.println("The movie '" + title + "' has been edited.");
            } else {
                System.out.println("The movie '" + title + "' is not found.");

            }
       }
        private static boolean containsNumbers(String input) {
            for (char c : input.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
            return false;
        }
    }
}