package lab9;

public class Collisions {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int times = 0;
        RandomWalk particle1 = new RandomWalk(100000, 2000000, -3, 0);
        RandomWalk particle2 = new RandomWalk(100000, 2000000, 3, 0);
        for (int i = 1; i <= 100000; i++) {
            particle1.takeStep();
            particle2.takeStep();
            if (samePosition(particle1,particle2)) {
                times++;
            }
        }
        System.out.println("the number of times the two particles collide is: "
                + times);
    }

    public static boolean samePosition(RandomWalk p1, RandomWalk p2) {
        return (p1.getX() == p2.getX() && p1.getY() == p2.getY()) ? true
                : false;
    }

}
