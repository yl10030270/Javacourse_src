package lab8;

public class Compare3 {
    public static Comparable largest(Comparable c1,Comparable c2,Comparable c3){
        if (c1.compareTo(c2)>= 0){
            if (c1.compareTo(c3)>=0){
                return c1;
            } else {
                return c3;
            }
        } else if (c2.compareTo(c3)>=0){
            return c2;
        } else {
            return c3;
        }
    }
}
