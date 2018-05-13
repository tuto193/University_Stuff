package Aufgabe3;
/**
 * Every instance of Book is represented through
 * its author and its title
 * 
 * @author Carlos A. Parra F.
 */
public class Book extends LibraryItem {
    private String title;
    private String author;

    public Book ( String title, String author ) {
        this.title = title;
        this.author = author;
    }

    public String getTile() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDescription() {
        return "The Book \"" + this.title + "\" was written by: " + this.author + ". \n Pretty good :D. ";
    }
}