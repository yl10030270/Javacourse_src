package q4;

import java.util.Arrays;

/**
 * represents a course taken at a school.
 * 
 * @author Liang Yang
 * @version 1
 */

public class Course {
    /** Initial size of testScore. */
    public static final int INITIAL_SIZE = 5;

    /** The total number of students in this course. */
    private static int stuCount;

    /** The name of this course. */
    private String courseName;

    /** First name of this student. */
    private Student[] stu;

    /**
     * Constructor: Sets up this course.
     */
    public Course() {
        stu = new Student[INITIAL_SIZE];
    }

    /**
     * Constructor: Sets up this course with name.
     * 
     * @param name
     *            The name of this course.
     */
    public Course(String name) {
        courseName = name;
        stu = new Student[INITIAL_SIZE];
    }

    /**
     * Return the name of the course.
     * 
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set up the name of the Course.
     * 
     * @param courseName
     *            the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * return the reference of student array.
     * 
     * @return the stu
     */
    public Student[] getStu() {
        return stu;
    }

    /**
     * Return the how many students in this course.
     * 
     * @return the stuCount
     */
    public int getStuCount() {
        return stuCount;
    }

    /**
     * add students to this course.
     * 
     * @param s
     *            the student
     */
    public void addStudent(Student s) {
        if (getStuCount() < INITIAL_SIZE) {
            this.stu[getStuCount()] = s;
            stuCount++;
        } else {
            throw new IllegalArgumentException(
                    "The course is full, up to 5 students");
        }
    }

    /**
     * computes and returns the average of all students¡¯ test score averages.
     * 
     * @return the average
     */
    public double average() {
        double total = 0;
        for (int i = 0; i < getStuCount(); i++) {
            total += stu[i].average();
        }
        return total / getStuCount();
    }

    /**
     * Print out the name list of students.
     */
    public void roll() {
        for (int i = 0; i < getStuCount(); i++) {
            System.out.println(stu[i]);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Course [courseName=" + courseName + ", stu="
                + Arrays.toString(stu) + "]";
    }

}
