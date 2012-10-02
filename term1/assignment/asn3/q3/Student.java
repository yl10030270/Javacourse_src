package q3;

/**
 * Represents a college student.
 * 
 * @author Lewis
 * @author Loftus
 * @version 1
 */
public class Student {
    /** Initial size of testScore. */
    private static final int INITIAL_SIZE = 3;

    /** First name of this student. */
    private String firstName;

    /** Last name of this student. */
    private String lastName;

    /** Score of test. */
    private double[] testScore;

    /**
     * Constructor: Sets up this student with 3 score equal 0.
     */
    public Student() {
        testScore = new double[INITIAL_SIZE];
        for (int i = 0; i < testScore.length; i++) {
            testScore[i] = 0;
        }
    }

    /**
     * Constructor: Sets up this student with the specified values.
     * 
     * @param first
     *            The first name of the student
     * @param last
     *            The last name of the student
     * @param t1
     *            The score of test1
     * @param t2
     *            The score of test2
     * @param t3
     *            The score of test3
     */
    public Student(String first, String last, double t1, double t2, double t3) {
        firstName = first;
        lastName = last;
        testScore = new double[INITIAL_SIZE];
        testScore[0] = t1;
        testScore[1] = t2;
        testScore[2] = t3;
    }

    /**
     * Set the firstname of the student.
     * 
     * @param fn
     *            The first name of the student.
     */
    public void setFirstName(String fn) {
        firstName = fn;
    }

    /**
     * Set the last name of the student.
     * 
     * @param sn
     *            The last name of the student.
     */
    public void setLastName(String sn) {
        lastName = sn;
    }

    /**
     * return the first name of the student.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * return the last name of the student.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the score of a specified test.
     * 
     * @param id
     *            The number of test
     * @param score
     *            the score of that test
     */
    public void setTestScore(int id, double score) {
        if (id > INITIAL_SIZE || id < 1) {
            throw new IllegalArgumentException(
                    "Test number must between 1 to 3");
        } else {
            testScore[id - 1] = score;
        }
    }

    /**
     * return the score of a specified test.
     * 
     * @param id
     *            The number of test
     * @return the score of that test
     * @throws ArrayIndexOutOfBoundsException
     *             If id > 3 or id < 1.
     */
    public double getTestScore(int id) {
        if (id >= 1 && id < testScore.length) {
            return testScore[id - 1];
        } else {
            throw new IllegalArgumentException(
                    "Test number must between 1 to 3");
        }
    }

    /**
     * Returns the average of 3 tests of this student.
     * 
     * @return the average
     */
    public double average() {
        return (testScore[0] + testScore[1] + testScore[2]) / testScore.length;
    }

    /**
     * Returns a string description of this Student object.
     * 
     * @return formatted name and addresses of student
     */
    public String toString() {
        String result;
        result = firstName + " " + lastName + "\n";
        result += "The score of test 1 is " + testScore[0] + "\n";
        result += "The score of test 2 is " + testScore[1] + "\n";
        result += "The score of test 3 is " + testScore[2] + "\n";
        result += "The average is " + this.average();
        return result;
    }
}
