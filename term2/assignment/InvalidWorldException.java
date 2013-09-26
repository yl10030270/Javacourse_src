/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Thrown when there is an error with world data.
 *
 * @author leon
 * @version 1.0
 */
public abstract class InvalidWorldException
        extends Exception
{
    /**
     * Construct an InvalidWorldException with the specified message.
     *
     * @param msg - the message describing the error.
     */
    protected InvalidWorldException(final String msg)
    {
        super(msg);
    }

    /**
     * Construct an InvalidWorldException with the specified
     * message and cause.
     *
     * @param msg   - the message describing the error.
     * @param cause - the root cause of the error.
     */
    protected InvalidWorldException(final String msg,
                                    final Throwable cause)
    {
        super(msg,
              cause);
    }

}
