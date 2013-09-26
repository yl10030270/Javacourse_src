package lab6;

public class Item {
    private String name;
    private double price;
    private int quantity;
    
    public Item(String n, double p, int q){
        name = n;
        price = p;
        quantity = q;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

}
