/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class Location
{
    private final int row;
    private final int column;

    Location(final int r,
             final int c)
    {
        if(r < 0)
        {
            throw new IllegalArgumentException("Row number can't smaller than 0.");
        }
        if(r < 0)
        {
            throw new IllegalArgumentException("Columns number can't smaller than 0.");
        }
        row = r;
        column = c;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }
}
