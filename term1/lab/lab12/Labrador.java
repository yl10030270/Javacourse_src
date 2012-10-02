package lab12;

//****************************************************************
//Labrador.java
//
//A class derived from Dog that holds information about
//a labrador retriever. Overrides Dog speak method and includes
//information about avg weight for this breed.
//
//****************************************************************
public class Labrador extends Dog {
    private String color; // black, yellow, or chocolate?
    private static int breedWeight = 75;

    public Labrador(String name, String color) {
        super(name);
        this.color = color;
    }

    // ------------------------------------------------------------
    // Big bark -- overrides speak method in Dog
    // ------------------------------------------------------------
    public String speak() {
        return "WOOF";
    }

    // ------------------------------------------------------------
    // Returns weight
    // ------------------------------------------------------------
    public int avgBreedWeight() {
        return breedWeight;
    }
}