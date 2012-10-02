package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAccount2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Account> user = new ArrayList<Account>();
        Scanner scan = new Scanner(System.in);
        String name;
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter the username.");
            name = scan.nextLine();
            user.add(new Account(100, name));
            System.out.println("Created account " + user.get(i));
            System.out.println("Now there are " + Account.getNumAccounts()
                    + " accounts");
        }
        user.get(0).close();
        user.add(Account.consolidate(user.get(1), user.get(2)));
        for (Account x : user) {
            if (x != null)
            System.out.println(x);
        }
        System.out.println("Now there are " + Account.getNumAccounts()
                + " accounts");

    }

}
