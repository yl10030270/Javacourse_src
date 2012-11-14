/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


import java.util.Scanner;


/**
 * A set of utility methods for working with numbers.
 *
 * @author Leon
 * @version 1.0
 */
public final class NumberUtils
{
    /**
     * Private Constructor to deal with pmd warning.
     */
    private NumberUtils()
    {
    }

    /**
     * Check that a number is an integer.
     *
     * @param value - the value to check.
     *
     * @return true if value is an int, false if it is not.
     */
    public static boolean isInt(final String value)
    {
        boolean retVal = false;

        if(value == null)
        {
            throw new IllegalArgumentException("value cannot be null");
        }

        final Scanner scan;
        scan = new Scanner(value);

        if(scan.hasNextInt())
        {
            scan.nextInt();
            retVal = true;
        }

        if(scan.hasNext())
        {
            retVal = false;
        }
        return retVal;

    }

}