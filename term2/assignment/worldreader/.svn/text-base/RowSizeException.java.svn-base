/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


/**
 * Thrown when the wrong number of columns are on a row.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class RowSizeException
    extends WorldDataException
{
    /**
     * the number of columns that is supposed to be on the row.
     */
    private final int expectedColumns;

    /**
     * the number of columns that are on the row.
     */
    private final int actualColumns;

    /**
     * the row number.
     */
    private final int row;

    /**
     * Construct a RowSizeException with the specified values.
     *
     * @param adjective - "many" or "few", used when creating the message.
     * @param r         - the row number.
     * @param expected  - the number of columns that is supposed to be on the row.
     * @param actual    - the number of columns that are on the row.
     */
    protected RowSizeException(final String adjective,
                               final int r,
                               final int expected,
                               final int actual)
    {
        super("Too " + adjective + " columns on row: " + r + ", expected: " + expected + ", was: " + actual);
        expectedColumns = expected;
        actualColumns = actual;
        row = r;
    }

    /**
     * The the actual columns that were on the row.
     *
     * @return the actual columns that were asked for.
     */
    public int getActualColumns()
    {
        return actualColumns;
    }

    /**
     * Get the expected columns.
     *
     * @return the expected columns.
     */
    public int getExpectedColumns()
    {
        return expectedColumns;
    }

    /**
     * Get the row that has the wrong number of columns on it.
     *
     * @return the row that has the wrong number of columns on it.
     */
    public int getRow()
    {
        return row;
    }

}
