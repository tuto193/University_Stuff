package Aufgabe3;

public class BluRay extends LibraryItem {
    private String title;
    private String director;

    public BluRay( String title, String director ) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public String getDescription() {
        return "The movie \"" + this.title + " \" was directed by: " + this.director + "\n My mom said it was O.K. .";
    }
}