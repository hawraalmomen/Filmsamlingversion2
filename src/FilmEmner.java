import java.util.Scanner;

public class FilmEmner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean isInColor = false;
        System.out.println("Er filmen i farve, skriv ja, ellers skriv nej");
        String erIFarve = scanner.next();
        erIFarve = erIFarve.toLowerCase();
        if(erIFarve.equals("ja")){
            isInColor=true;

        }

        while(true){
            break;
        }
        int menuChoice =0;
        final int SENTINEL=2;
        while (menuChoice!=SENTINEL){
            //klmiløfagjøalehig med en scanner

            MovieCollection collection = new MovieCollection();
            collection.addMovie();

        }
        ArrayList<String> Liste = new ArrayList<>();
        Liste.add("signe");
    }
}
