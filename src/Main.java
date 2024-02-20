import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Lav Film objekt
        Scanner input = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        System.out.println("Input movie title");
        String title = input.nextLine();

        System.out.println("Input the name of director");
        String director = input.nextLine();

        System.out.println("Input year of creation");
        int yearCreated = input.nextInt();

        System.out.println("Input the color of movie");
        boolean isInColor = input.nextBoolean();

        System.out.println("Input the length of the movie");
        double lengthInMinutes = input.nextDouble();

        System.out.println("The genre of the movie");
        String genre = input.nextLine();


        collection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);




    }
}