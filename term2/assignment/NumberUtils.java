/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class NumberUtils
{
    public static boolean isInt(String value)
    {
        try
        {
            Integer.parseInt(value);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
