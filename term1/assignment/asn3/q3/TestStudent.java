package q3;

/**
 * <p>
 * Student test drive.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class TestStudent {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        final int t1 = 87;
        final int t2 = 50;
        final int t3 = 75;
        final int newT2 = 99;
        Student s = new Student("jion", "cash", t1, t2, t3);
        try {
            System.out.println("Before change,the test2 score is :"
                    + s.getTestScore(-1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("Before change,the test 2 score is :"
                + s.getTestScore(2));
        System.out.println("The average is :" + s.average());
        try {
            s.setTestScore(-1, newT2);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        s.setTestScore(2, newT2);
        System.out.println("After change");
        System.out.println(s);
        System.out.println();

        System.out.println("Question three was called and ran sucessfully.");
    }

};
