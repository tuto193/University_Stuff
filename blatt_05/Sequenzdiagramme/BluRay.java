package Aufgabe3;
/**
 * A BluRay is defined by its title and its director
 */
public class BluRay extends LibraryItem {
    /**
     * The defining attributes of the BluRay
     */
    private String title;
    private String director;

    /**
     * In the constructor one must state the title and the director of the BluRay
     * is to be instantiated
     * 
     * @param title a String that represents the title of this BluRay
     * @param director a String that represents the director of this BluRay
     */
    public BluRay( String title, String director ) {
        this.title = title;
        this.director = director;
    }

    /**
     * Returns the title String of this BluRay
     * 
     * @return title of this BluRay
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the director String of this BluRay
     * 
     * @return director of this BluRay 
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Returns a brief description String of this BluRay, based on its title
     * and its director
     * 
     * @return a brief description of this BluRay
     */
    public String getDescription() {
        return "The movie \"" + this.title + " \" was directed by: " + this.director + "\n My mom said it was O.K. .";
    }
}