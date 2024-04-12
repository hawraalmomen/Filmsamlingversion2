public class Movie {
    //Attributter
     String title;
     String director;
     int yearCreated;
     boolean isInColor;
     double lengthInMinutes;
     String genre;

    //Konstruktør
    public Movie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;

    }
    //Getter-metoden

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearCreated() {
        return this.yearCreated;

    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;

    }

    public boolean IsInColor() {
        return this.isInColor;

    }

    public void setIsInColor(boolean isInColor) {
            this.isInColor = isInColor;

    }

    public double getLengthInMinutes() {
        return lengthInMinutes;

    }

    public void setLengthInMinutes(double newLengthMinutes) {
        this.lengthInMinutes = newLengthMinutes;
    }

    public String getGenre() {
        return this.genre;

    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Director:'" + director + "\n" +
                "Year Created: " + yearCreated + "\n" +
                "Color: " + (isInColor? "Yes" : "No") + "\n" +
                "Length (Minutes): " + lengthInMinutes + "\n" +
                "Genre: " + genre + "\n";
    }
}
