package q3;

/**
 * <p>
 * Represents one book which contains instance data for the title, author,
 * publisher, and copyright date.
 * </p>
 * 
 * @author Liang yang
 * @version 1
 */
public class Book {
    /** Book name. */
    private String title;
    /** Book writer. */
    private String author;
    /** publisher. */
    private String publisher;
    /** copyright date. */
    private String crdate;

    /**
     * Constructor.
     */
    public Book() {
    }

    /**
     * Book Title mutator.
     * 
     * @param t
     *            The name for the book
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * Book author mutator.
     * 
     * @param a
     *            The author for the book
     */
    public void setAuthor(String a) {
        author = a;
    }

    /**
     * Book publisher mutator.
     * 
     * @param p
     *            The publisher for the book
     */
    public void setPublisher(String p) {
        publisher = p;
    }

    /**
     * Book copyright date mutator.
     * 
     * @param date
     *            The publisher for the book
     */
    public void setDate(String date) {
        crdate = date;
    }

    /**
     * Book title accessor.
     * 
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Book author accessor.
     * 
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Book publisher accessor.
     * 
     * @return The publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Book copyright date accessor.
     * 
     * @return The copyright date of the book
     */
    public String getDate() {
        return crdate;
    }

    /**
     * Returns a string representation of this book.
     * 
     * @return The representation of the book
     */
    public String toString() {

        return "Book Author:" + getAuthor() + "\n" + "Book Name:" + getTitle()
                + "\n" + "Book publisher:" + getPublisher() + "\n"
                + "Book Copyright Date:" + getDate() + "\n";
    }
}
