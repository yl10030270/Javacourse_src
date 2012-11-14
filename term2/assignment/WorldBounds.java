/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * The minimum and maximum size of a world.
 *
 * @author Leon
 * @version 1.0
 */
public class WorldBounds
{
    /**
     * The smallest number of rows the world can have.
     */
    private final int minRs;

    /**
     * The smallest number of columns the world can have.
     */
    private final int minCs;

    /**
     * The largest number of rows the world can have.
     */
    private final int maxRs;

    /**
     * The largest number of columns the world can have.
     */
    private final int maxCs;

    /**
     * Construct a WorldBounds from the specified data.
     *
     * @param minRows - The smallest number of rows the world can have.
     * @param minCols - The smallest number of columns the world can have.
     * @param maxRows - The largest number of rows the world can have.
     * @param maxCols - The largest number of columns the world can have.
     */
    public WorldBounds(final int minRows,
                       final int minCols,
                       final int maxRows,
                       final int maxCols)
    {
        if(minRows <= 0)
        {
            throw new IllegalArgumentException("minRows must be >= 1, was: " + minRows);
        }
        if(minCols <= 0)
        {
            throw new IllegalArgumentException("minCols must be >= 1, was: " + minCols);
        }
        if(minRows > maxRows)
        {
            throw new IllegalArgumentException("minRows must be <= maxRows, minRows was: " + minRows + " maxRows was: " + maxRows);
        }
        if(minCols > maxCols)
        {
            throw new IllegalArgumentException("minCols must be <= maxCols, minCols was: " + minCols + " maxCols was: " + maxCols);
        }
        
        this.minRs = minRows;
        this.minCs = minCols;
        this.maxRs = maxRows;
        this.maxCs = maxCols;
    }

    /**
     * Get the smallest number of rows the world can have.
     *
     * @return the smallest number of rows the world can have.
     */
    public int getMinimumRows()
    {
        return minRs;
    }

    /**
     * Get the smallest number of columns the world can have.
     *
     * @return the smallest number of columns the world can have.
     */
    public int getMinimumColumns()
    {
        return minCs;
    }

    /**
     * Get the largest number of rows the world can have.
     *
     * @return the largest number of rows the world can have.
     */
    public int getMaximumRows()
    {
        return maxRs;
    }

    /**
     * Get the largest number of columns the world can have.
     *
     * @return the largest number of columns the world can have.
     */
    public int getMaximumColumns()
    {
        return maxCs;
    }

    /**
     * Verify that the rows and columns requested are
     * within the bounds of the world.
     *
     * @param rows    - the rows that the world will have.
     * @param columns - the columns that the world will have.
     *
     * @throws TooFewRowsException     - thrown if the number of rows specified is smaller than the bounds.
     * @throws TooManyRowsException    - thrown if the number of rows specified is larger than the bounds.
     * @throws TooFewColumnsException  - thrown if the number of columns specified is smaller than the bounds.
     * @throws TooManyColumnsException - thrown if the number of columns specified is larger than the bounds.
     */
    public void checkIsInBounds(final int rows,
                                final int columns)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException
    {
        if(rows < minRs)
        {
            throw new TooFewRowsException(minRs,
                                          rows);
        }
        if(rows > maxRs)
        {
            throw new TooManyRowsException(maxRs,
                                           rows);
        }
        if(columns < minCs)
        {
            throw new TooFewColumnsException(minCs,
                                             columns);
            
        }
        if(columns > maxCs)
        {
            throw new TooManyColumnsException(maxCs,
                                              columns);
        }
    }
    
}
