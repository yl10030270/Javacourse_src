package q4;

import java.util.Random;

/**
 * <p>
 * Course test driver class.
 * </p>
 * 
 * @author Liang Yang
 * @version 1.0
 */
public class TestCourse {

    /** Test score base. */
    private static final int SBASE = 100;
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
        Random ran = new Random();
        Course c = new Course("JAVA");
        try {
            for (int i = 1; i <= Course.INITIAL_SIZE + 1; i++) {
                c.addStudent(new Student("student" + i, "tester", ran
                        .nextDouble() * SBASE, ran.nextDouble() * SBASE, ran
                        .nextDouble() * SBASE));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        
        c.roll();      
        
        System.out.println();
        System.out.println("The overall course test average is:" + c.average());
        System.out.println();
        System.out.println("Question four was called and ran sucessfully.");
    }
};
