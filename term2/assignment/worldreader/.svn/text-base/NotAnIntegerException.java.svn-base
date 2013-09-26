/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


/**
 * Thrown when the rows or columns in the data source are not an integer.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class NotAnIntegerException
    extends WorldDataException
{
    /**
     * the value that was not an integer.
     */
    private final String value;

    /**
     * Construct an NotAnIntegerException with the specified data.
     *
     * @param name - "rows" or "columns".
     * @param val  - the value that was not an integer.
     */
    protected NotAnIntegerException(final String name,
                                    final String val)
    {
        super(name + " must be an integer, was: " + val);
        value = val;
    }

    /**
     * Get the value that was not an integer.
     *
     * @return the value that was not an integer.
     */
    public String getValue()
    {
        return value;
    }

}
