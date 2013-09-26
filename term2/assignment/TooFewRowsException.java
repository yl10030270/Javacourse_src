/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there are too few rows specified for a world.
 *
 * @author Leon
 * @version 1.0
 */
public class TooFewRowsException
    extends WorldSizeException
{
    /**
     * Construct a TooFewRowsException with the specified data.
     *
     * @param minimum - the smallest allowed value.
     * @param rows    - the actual value.
     */
    public TooFewRowsException(final int minimum,
                               final int rows)
    {
        super("few",
              "rows",
              ">=",
              minimum,
              rows);
    }

}
