package lab12;

import lab11.Average;

//****************************************************************
//DogTest.java
//
//A simple test class that creates a Dog and makes it speak.
//
//****************************************************************
public class DogTest {
    public static void main(String[] args) {
        // Dog dog = new Dog("Spike");
        // System.out.println(dog.getName() + " says " + dog.speak());
        Labrador labrador = new Labrador("poppy", "yellow");
        System.out.println(labrador.getName() + " says " + labrador.speak());
        Yorkshire yorkshire = new Yorkshire("york");
        System.out.println(yorkshire.getName() + " says " + yorkshire.speak());
        System.out.println("The average breedweight of labrador is "
                + labrador.avgBreedWeight());
        System.out.println("The average breedweight of yorkshire is "
                + yorkshire.avgBreedWeight());
    }
}
