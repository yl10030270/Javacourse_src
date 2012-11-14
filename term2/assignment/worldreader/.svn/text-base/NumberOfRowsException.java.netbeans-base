/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


/**
 * Thrown when there are not the proper number of rows in world data.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class NumberOfRowsException
    extends WorldDataException
{
    /**
     * the number of rows required.
     */
    private final int requiredValue;

    /**
     * the actual number of rows provided.
     */
    private final int actualValue;

    /**
     * Construct an ExtraRowsException with the specified data.
     *
     * @param adjective - "many" or "few".
     * @param required  - the number of rows required.
     * @param actual    - the actual number of rows provided.
     */
    protected NumberOfRowsException(final String adjective,
                                    final int required,
                                    final int actual)
    {
        super("Too " + adjective + " rows must be: " + required + ", was: " + actual);
        requiredValue = required;
        actualValue = actual;
    }

    /**
     * The required number of rows.
     *
     * @return required number of rows.
     */
    public int getRequiredValue()
    {
        return requiredValue;
    }

    /**
     * The actual number of rows.
     *
     * @return actual number of rows.
     */
    public int getActualValue()
    {
        return actualValue;
    }

}
