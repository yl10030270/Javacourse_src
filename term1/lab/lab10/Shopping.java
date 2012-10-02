package lab10;

import java.text.NumberFormat;
import java.util.Scanner;

public class Shopping {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String keepdoing = "";
        Scanner scan = new Scanner(System.in);
        String itemname;
        double price;
        int quantity;
        ShoppingCart list = new ShoppingCart();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        while (!keepdoing.equalsIgnoreCase("n")) {
            System.out.println("Please enter the name of the item: ");
            itemname = scan.nextLine();
            System.out.println("Please enter the price of the item: ");
            price = scan.nextDouble();
            scan.nextLine();
            System.out.println("Please enter the quantity of the item: ");
            quantity = scan.nextInt();
            scan.nextLine();
            list.addToCart(itemname, price, quantity);
            System.out.println(list);
            System.out
                    .println("More item?(type 'n' to stop, anything else will continue): ");
            keepdoing = scan.nextLine();
            //System.out.println(keepdoing);
        }
        System.out.println("Please pay " + fmt.format(list.getTotalPrice())
                + ".");
    }

}
