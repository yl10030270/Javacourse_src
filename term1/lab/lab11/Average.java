package lab11;

public class Average {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        if (args.length == 0){
            System.out.println("No arguments");
        } else {
            int sum = 0;
            for (int i = 0;i < args.length; i++){
                //System.out.println(args[i]);
                sum += Integer.parseInt(args[i]);
            }
            System.out.println((double)sum/args.length);
        }
    }

}
