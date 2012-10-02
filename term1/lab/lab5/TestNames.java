package lab5;
import java.util.Scanner;

public class TestNames {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Name name1;
        Name name2;
        Scanner scan= new Scanner(System.in);
        System.out.print("Please enter the first name:");
        name1 = new Name(scan.next(), scan.next(),scan.next());
        System.out.print("Please enter the second name:");
        name2 = new Name(scan.next(), scan.next(),scan.next());
        System.out.println();
        System.out.println(name1.firstMiddleLast());
        System.out.println(name1.lastFirstMiddle());
        System.out.println(name1.initials());
        System.out.println(name1.length());
        System.out.println();
        System.out.println(name2.firstMiddleLast());
        System.out.println(name2.lastFirstMiddle());
        System.out.println(name2.initials());
        System.out.println(name2.length());
        System.out.println();
        if (name1.equals(name2)) {
            System.out.println("They are same name.");
        }
        else {
            System.out.println("They are not same name.");            
        }
        // TODO Auto-generated method stub

    }

}
