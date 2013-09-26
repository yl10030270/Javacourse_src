/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there is an error with the size of the world.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class WorldSizeException
    extends InvalidWorldException
{
    /**
     * the expected value.
     */
    private final int expVal;

    /**
     * the actual value.
     */
    private final int actVal;

    /**
     * Construct a WorldSizeException with the specified message.
     *
     * @param adjective - "few" or "many".
     * @param type      - "rows" or "columns".
     * @param sign      - ">=" or "<=".
     * @param expected  - the expected value.
     * @param actual    - the actual value.
     */
    protected WorldSizeException(final String adjective,
                                 final String type,
                                 final String sign,
                                 final int expected,
                                 final int actual)
    {
        super("Too " + adjective + " " + type + " must be " + sign + " " + expected + ", was: " + actual);
        expVal = expected;
        actVal = actual;
    }

    /**
     * Get the expected number of rows or columns.
     *
     * @return the expected number of rows or columns.
     */
    public int getExpectedValue()
    {
        return expVal;
    }

    /**
     * Get the actual number of rows or columns.
     *
     * @return the actual number of rows or columns.
     */
    public int getActualValue()
    {
        return actVal;
    }

}
