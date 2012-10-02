package lab8;

public class ChangingPeople {
    /*
     * Instantiate two person objects that will be sent to the changePeople
     * method.
     */

    public static void main (String[] args) {
        Person person1 = new Person ("Sally", 13);
        Person person2 = new Person ("Sam", 15);

        System.out.println ("\nValues BEFORE calling changePeople...");
        System.out.println ("Original values...");
        System.out.println ("person1: " + person1);
        System.out.println ("person2: " + person2);

        changePeople (person1, person2);

        System.out.println ("\nValues AFTER calling changePeople...");
        System.out.println ("person1: " + person1);
        System.out.println ("person2: " + person2);

    }

    /*
     * Attempt to swap the two person objects.
     */
    public static void changePeople (Person p1, Person p2) {
        System.out.println ("\nInside changePeople... Original parameters...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);

        // Make changes
        Person temp = new Person("a",1);
//        p1 = p2;
//        p2 = temp;

        temp.setName(p1.getName());
        temp.setAge(p1.getAge());
        p1.setName(p2.getName());
        p1.setAge(p2.getAge());
        p2.setName(temp.getName());
        p2.setAge(temp.getAge());
        
        // Print changes
        System.out.println ("\nInside changePeople... Changed values...");
        System.out.println ("person1: " + p1);
        System.out.println ("person2: " + p2);
    }
}


class Person {

    private int age;

    private String name;

    public Person(String n, int a) {
        name = n;
        age = a;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }



}

