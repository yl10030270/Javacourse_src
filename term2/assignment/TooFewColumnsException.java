/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there are too few columns specified for a world.
 *
 * @author Leon
 * @version 1.0
 */
public class TooFewColumnsException
    extends WorldSizeException
{
    /**
     * Construct a TooFewRowsException with the specified data.
     *
     * @param minimum - the smallest allowed value.
     * @param cols    - the actual value.
     */
    public TooFewColumnsException(final int minimum,
                                  final int cols)
    {
        super("few",
              "columns",
              ">=",
              minimum,
              cols);
    }

}
