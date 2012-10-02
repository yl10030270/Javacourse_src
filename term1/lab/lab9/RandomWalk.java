package lab9;

import java.util.Random;

public class RandomWalk {
    private int xcd;
    private int ycd;
    private int maxsteps;
    private int numsteps;
    private int edge;
    private int maxDistance;

    public RandomWalk(int max, int e) {
        maxsteps = max;
        edge = e;
        xcd = 0;
        ycd = 0;
        numsteps = 0;
        maxDistance = 0;
    }

    public RandomWalk(int max, int e, int startX, int startY) {
        maxsteps = max;
        edge = e;
        xcd = startX;
        ycd = startY;
        numsteps = 0;
        maxDistance = 0;
    }

    public int getX() {
        return xcd;
    }

    public int getY() {
        return ycd;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public String toString() {
        return "steps: " + numsteps + "; Position: (" + xcd + "," + ycd + ")";
    }

    public void takeStep() {
        int step;
        Random walk = new Random();
        step = walk.nextInt(4);
        switch (step) {
        case 0:
            xcd++;
            maxDistance = max(maxDistance, xcd);
            numsteps++;
            break;
        case 1:
            ycd++;
            maxDistance = max(maxDistance, ycd);
            numsteps++;
            break;
        case 2:
            xcd--;
            maxDistance = max(maxDistance, xcd);
            numsteps++;
            break;
        case 3:
            ycd--;
            maxDistance = max(maxDistance, ycd);
            numsteps++;
            break;
        }
    }

    public boolean moreSteps() {
        return (numsteps < maxsteps) ? true : false;
    }

    public boolean inBounds() {
        return (xcd <= edge && xcd >= edge * (-1) && ycd <= edge && ycd >= edge
                * (-1)) ? true : false;
    }

    public void walk() {
        while (this.moreSteps() && this.inBounds()) {
            this.takeStep();
        }
    }

    private int max(int num1, int num2) {
        return Math.abs((Math.abs(num1) >= Math.abs(num2)) ? num1 : num2);
    }

}
