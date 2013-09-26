package lab6;

//***************************************************************
//Shop.java
//
//Uses the Item class to create items and add them to a shopping
//cart stored in an ArrayList.
//***************************************************************
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        ArrayList<Item> cart = new ArrayList<Item>();
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        do {
            System.out.print("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print("Enter the quantity: ");
            quantity = scan.nextInt();
            // *** create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            // *** print the contents of the cart object using println
            System.out.println();
            // System.out.println(cart);
            double totalprice = 0;
            for (Item myitem : cart) {
                System.out.println(myitem.getName() + ":  "
                        + myitem.getQuantity() + "*"
                        + fmt.format(myitem.getPrice()));
                totalprice += myitem.getQuantity() * myitem.getPrice();
            }
            System.out.println("Total price: " + fmt.format(totalprice));
            System.out.println();
            System.out.print("Continue shopping (y/n)?");
            scan.nextLine(); // go to next line.
            keepShopping = scan.nextLine();
            System.out.println();
        } while (keepShopping.equals("y"));
        System.out.print("done");
    }
}
