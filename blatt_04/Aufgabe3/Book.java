package Aufgabe3;
/**
 * Every instance of Book is represented through
 * its author and its title
 * 
 * @author Carlos A. Parra F.
 */
public class Book extends LibraryItem {
    /**
     * The defining attributes of a Book
     */
    private String title;
    private String author;

    /**
     * The Constructor sets the title and author attributes of the book
     * 
     * @param title a String that defines the books title
     * @param author a String that defines the books author
     */
    public Book ( String title, String author ) {
        this.title = title;
        this.author = author;
    }

    /**
     * Returns the title String of this book
     * 
     * @return the title of this book
     */
    public String getTile() {
        return this.title;
    }

    /**
     * Return the author String of this book
     * 
     * @return the author of this book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns a brief description of the book, using its title and author
     * 
     * @return a brief description of the book
     */
    public String getDescription() {
        return "The Book \"" + this.title + "\" was written by: " + this.author + ". \n Pretty good :D. ";
    }
}