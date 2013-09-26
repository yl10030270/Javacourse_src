/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there are too many rows specified for a world.
 *
 * @author Leon
 * @version 1.0
 */
public class TooManyRowsException
    extends WorldSizeException
{
    /**
     * Construct a TooFewRowsException with the specified data.
     *
     * @param maximum - the biggest allowed value.
     * @param rows    - the actual value.
     */
    public TooManyRowsException(final int maximum,
                                final int rows)
    {
        super("many",
              "rows",
              "<=",
              maximum,
              rows);
    }

}
