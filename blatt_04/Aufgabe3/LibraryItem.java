package Aufgabe3;
/**
 * The abstract class that defines a standar LibraryItem
 * @author Carlos A. Parra F.
 */
public abstract class LibraryItem {
    /**
     * We need to know whether the Item isBorrowed.
     */
    private boolean isBorrowed;

    /**
     * The Constructor
     */
    public LibraryItem() {}

    /**
     * Returns true, if the LibraryItem is currently burrowed.
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Toggles the isBorrwed state of this item.
     */
    public void setBorrowed() {
        this.isBorrowed = !this.isBorrowed;
    }

    /**
     * Returns a brief description of this LibraryItem
     */
    public abstract String getDescription();
}