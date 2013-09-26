/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


import ca.bcit.cst.comp2526.assign3.a00811101.InvalidWorldException;


/**
 * Thrown when there is an error with the world data.
 *
 * @author leon
 * @version 1.0
 */
public class WorldDataException
        extends InvalidWorldException
{
    /**
     * serialization ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Construct a WorldDataException with the specified message.
     *
     * @param msg - the message describing the error.
     */
    protected WorldDataException(final String msg)
    {
        super(msg);
    }

    /**
     * Construct a WorldDataException with the specified message.
     *
     * @param msg   - the message describing the error.
     * @param cause - the root cause of the error.
     */
    protected WorldDataException(final String msg,
                                 final Throwable cause)
    {
        super(msg,
              cause);
    }

}
