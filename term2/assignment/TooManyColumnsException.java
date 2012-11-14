/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there are many columns specified for a world.
 *
 * @author Leon
 * @version 1.0
 */
public class TooManyColumnsException
    extends WorldSizeException
{
    /**
     * Construct a TooFewRowsException with the specified data.
     *
     * @param maximum - the biggest allowed value.
     * @param cols    - the actual value.
     */
    public TooManyColumnsException(final int maximum,
                                   final int cols)
    {
        super("many",
              "columns",
              "<=",
              maximum,
              cols);
    }

}
