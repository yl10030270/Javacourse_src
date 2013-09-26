/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


import ca.bcit.cst.comp2526.assign3.a00811101.Location;


/**
 * Thrown when there is an unknown entity type in the world data.
 *
 * @author leon
 * @version 1.0
 */
public class UnknownEntityTypeException
        extends WorldDataException
{
    /**
     * The return value of getRow and getColumn when location is null.
     */
    private static final int INVALID_ROW_AND_COLUMN_NUMBER = -1;

    /**
     * The character represent the entity.
     */
    private final char type;

    /**
     * The row of Entity location.
     */
    private final int row;

    /**
     * The column of Entity location.
     */
    private final int column;

    /**
     * Construct a UnknownEntityTypeException with the character and location.
     *
     * @param c        - the message describing the error.
     * @param location - the root cause of the error.
     */
    public UnknownEntityTypeException(final char c,
                                      final Location location)
    {

        super("Unknown entity type \"" + c + "\" @ " + ((location == null) ?
                                                        "null" :
                                                        location.toString()));
        this.type = c;
        if(location == null)
        {
            row = INVALID_ROW_AND_COLUMN_NUMBER;
            column = INVALID_ROW_AND_COLUMN_NUMBER;
        }
        else
        {
            row = location.getRow();
            column = location.getColumn();
        }
    }

    /**
     * Get the character representing the entity.
     *
     * @return c representing the entity.
     */
    public char getKey()
    {
        return type;
    }

    /**
     * Get the row that the unknown entity is on.
     *
     * @return the row that the unknown entity is on.
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Get the column that the unknown entity is on.
     *
     * @return the column that the unknown entity is on.
     */
    public int getColumn()
    {
        return column;
    }

}
