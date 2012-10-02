package q3;

import java.util.Scanner;

/**
 * <p>
 * instantiate and update book objects..
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class Bookshelf {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        String title;
        String author;
        String publisher;
        String date;
        String input;
        System.out.print("Add  a new books.");
        Scanner scan = new Scanner(System.in);
            
        //read the input and update an new book object
        Book b6 = new Book();
        System.out.println();
        System.out.print("Please enter the book name:");
        title = scan.nextLine();
        b6.setTitle(title);
        System.out.print("Please enter the book author:");
        author = scan.nextLine();
        b6.setAuthor(author);
        System.out.print("Please enter the book publisher:");
        publisher = scan.nextLine();
        b6.setPublisher(publisher);
        System.out.print("Please enter the copyrith date:");
        date = scan.nextLine();
        b6.setDate(date);
        
        //print out the book info. using getter method
        System.out.println();
        System.out.println("You added a new book.");
        System.out.println("Book name is: " + b6.getTitle());
        System.out.println("The author is: " + b6.getAuthor());
        System.out.println("The publisher is: " + b6.getPublisher());
        System.out.println("The copyright date is: " + b6.getDate());
        
        System.out.println();
        System.out.print("You want to see the book list?(y/n)");
        input = scan.nextLine();
        if (input.equalsIgnoreCase("y")) {
            //instantiates and updates 5 book objects using setter method
            Book b1 = new Book();
            Book b2 = new Book();
            Book b3 = new Book();
            Book b4 = new Book();
            Book b5 = new Book();
    
            b1.setTitle("Vanishing Wildlife of North America");
            b1.setAuthor("Allen, Thomas B");
            b1.setPublisher("Washington,D.C.: National Geographic Society");
            b1.setDate("1974");
            b2.setTitle("A History of the Heroes of the Imagination");
            b2.setAuthor("Boorstin,Daniel J");
            b2.setPublisher("New York: Random");
            b2.setDate("1992");
            b3.setTitle("The Oxford Book of American Literacy Anecdotes");
            b3.setAuthor("Hall,Donald,ed");
            b3.setPublisher("New York: Oxford UP");
            b3.setDate("1981");
            b4.setTitle("A Reader's Guide to Science Fiction");
            b4.setAuthor("Searles,Baird,and Martin Last");
            b4.setPublisher("New York: Facts on File, Inc.");
            b4.setDate("1979");
            b5.setTitle("Cane");
            b5.setAuthor("Toomer, Jean");
            b5.setPublisher("New York: Norton");
            b5.setDate("1988");
        
        //print out a formatted booklist using toString method
            System.out.println();
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            System.out.println(b6);
            
        } else if (input.equalsIgnoreCase("n")) {

            // your code will go here!!!
            System.out.println();
        } else {
        
            //If the input neither "y" nor "no",print out a notice.
            System.out.println();
            System.out.println("Invalid input detected."
                    + " Please check your inputs.");
        }
        System.out.println();
        System.out.println("Question three was called and ran sucessfully.");
    }
};
