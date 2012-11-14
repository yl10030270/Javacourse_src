/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


import ca.bcit.cst.comp2526.assign3.a00811101.DefaultMutableWorld;
import ca.bcit.cst.comp2526.assign3.a00811101.EntityFactory;
import ca.bcit.cst.comp2526.assign3.a00811101.Location;
import ca.bcit.cst.comp2526.assign3.a00811101.TooFewColumnsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooFewRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooManyColumnsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooManyRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.WorldBounds;
import java.util.List;


/**
 * Convenience class for common world reading features.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class AbstractWorldReader
    implements WorldReader
{
    /**
     * Read a world from a data source.
     *
     * @param worldName - the name of the world to read.
     * @param factory   - used to create entities.
     * @param bounds    - the bounds of the world.
     *
     * @return the world.
     *
     * @throws TooFewRowsException        - thrown if the number of rows specified is smaller than the bounds.
     * @throws TooManyRowsException       - thrown if the number of rows specified is larger than the bounds.
     * @throws TooFewColumnsException     - thrown if the number of columns specified is smaller than the bounds.
     * @throws TooManyColumnsException    - thrown if the number of columns specified is larger than the bounds.
     * @throws ShortRowException          - thrown if there are too few entities on a row.
     * @throws LongRowException           - thrown if there are too many entities on a row.
     * @throws RowsNotIntegerException    - thrown if the rows are not an integer.
     * @throws ColumnsNotIntegerException - thrown if the columns are not an integer.
     * @throws UnknownEntityTypeException - thrown if the data has an unknown entity type.
     * @throws EmptyDataException         - thrown if there is no data in the data source.
     * @throws MissingRowsException       - thrown if the data has too few rows.
     * @throws ExtraRowsException         - thrown if the data has too many rows.
     * @throws WorldDataSourceException   - thrown if there is an underlying problem reading from the data source.
     *
     */
    @Override
    public final DefaultMutableWorld readWorld(final String worldName,
                                               final EntityFactory factory,
                                               final WorldBounds bounds)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException,
               ShortRowException,
               LongRowException,
               RowsNotIntegerException,
               ColumnsNotIntegerException,
               UnknownEntityTypeException,
               MissingRowsException,
               ExtraRowsException,
               EmptyDataException,
               WorldDataSourceException
    {

        checkArguments(worldName, factory, bounds);

        this.openWorldData(worldName);

        final int r = getNumberOfRows(worldName);
        final int c = getNumberOfColumns(worldName);
        final List<String> worldcontents = getWorldContents(worldName);
        final int actRows = worldcontents.size();

        checkBounds(r, c, actRows, bounds);

        this.closeWorldData(worldName);

        checkEachRow(r, c, worldcontents);

        final DefaultMutableWorld world;
        world = new DefaultMutableWorld(r, c, bounds);
        world.init();

        Location loc;
        char type;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                loc = Location.create(i,
                                      j,
                                      world);
                type = worldcontents.get(i).charAt(j);
                world.getTileAt(loc).setEntity(factory.createEntity(type, loc));
            }
        }

        return world;
    } //readworld

    /**
     * Check the validation of arguments.
     *
     * @param worldName - the name of the world to read.
     * @param factory   - used to create entities.
     * @param bounds    - the bounds of the world.
     */
    private void checkArguments(final String worldName,
                                final EntityFactory factory,
                                final WorldBounds bounds)
    {
        if(worldName == null)
        {
            throw new IllegalArgumentException("worldName cannot be null");
        }

        if(worldName.trim().isEmpty())
        {
            throw new IllegalArgumentException("worldName cannot be empty");
        }

        if(factory == null)
        {
            throw new IllegalArgumentException("factory cannot be null");
        }

        if(bounds == null)
        {
            throw new IllegalArgumentException("bounds cannot be null");
        }
    }

    /**
     * Check The rows or columns if outside the bounds.
     *
     * @param r       -the number of the rows.
     * @param c       -the number of the columns.
     * @param actRows -the actual number of the rows.
     * @param bounds  - the bounds of the world.
     *
     * @throws TooFewRowsException     - thrown if the number of rows specified is smaller than the bounds.
     * @throws TooManyRowsException    - thrown if the number of rows specified is larger than the bounds.
     * @throws TooFewColumnsException  - thrown if the number of columns specified is smaller than the bounds.
     * @throws TooManyColumnsException - thrown if the number of columns specified is larger than the bounds.
     * @throws MissingRowsException    - thrown if the data has too few rows.
     * @throws ExtraRowsException      - thrown if the data has too many rows.
     */
    private void checkBounds(final int r,
                             final int c,
                             final int actRows,
                             final WorldBounds bounds)
        throws TooManyRowsException,
               TooManyColumnsException,
               TooFewRowsException,
               TooFewColumnsException,
               ExtraRowsException,
               MissingRowsException
    {
        final int maxRows = bounds.getMaximumRows();
        final int maxCols = bounds.getMaximumColumns();
        final int minRows = bounds.getMinimumRows();
        final int minCols = bounds.getMinimumColumns();
        if(r > maxRows)
        {
            throw new TooManyRowsException(maxRows, r);
        }

        if(c > maxCols)
        {
            throw new TooManyColumnsException(maxCols, c);
        }

        if(r < minRows)
        {
            throw new TooFewRowsException(minCols, r);
        }

        if(c < minCols)
        {
            throw new TooFewColumnsException(minCols, c);
        }
        if(r < actRows)
        {
            throw new ExtraRowsException(r, actRows);
        }

        if(r > actRows)
        {
            throw new MissingRowsException(r, actRows);
        }
    }

    /**
     * Check the validation of each row.
     *
     * @param r             - the number of rows;
     * @param c             - the number of columns;
     * @param worldcontents - the world has been read.
     *
     * @throws ShortRowException - thrown if there are too few entities on a row.
     * @throws LongRowException  - thrown if there are too many entities on a row.
     */
    private void checkEachRow(final int r,
                              final int c,
                              final List<String> worldcontents)
        throws ShortRowException,
               LongRowException
    {
        int length;

        for(int i = 0; i < r; i++)
        {
            length = worldcontents.get(i).length();
            if(length < c)
            {
                throw new ShortRowException(i, c, length);
            }
            if(length > c)
            {
                throw new LongRowException(i, c, length);
            }
        }
    }

    /**
     * Open the data source.
     *
     * @param worldName - the name of the world.
     *
     * @throws EmptyDataException       - if there is no data in the data source.
     * @throws WorldDataSourceException - if there is a problem with the data source.
     */
    protected abstract void openWorldData(String worldName)
        throws EmptyDataException,
               WorldDataSourceException;

    /**
     * Close the data source.
     *
     * @param worldName - the name of the world.
     */
    protected abstract void closeWorldData(String worldName);

    /**
     * Get the number of rows on the world.
     *
     * @param worldName - the name of the world.
     *
     * @return the number of rows on the world.
     *
     * @throws RowsNotIntegerException - if the rows is not an integer.
     */
    protected abstract int getNumberOfRows(String worldName)
        throws RowsNotIntegerException;

    /**
     * Get the number of columns on the world.
     *
     * @param worldName - the name of the world.
     *
     * @return the number of columns on the world.
     *
     * @throws ColumnsNotIntegerException - if the column is not an integer.
     */
    protected abstract int getNumberOfColumns(String worldName)
        throws ColumnsNotIntegerException;

    /**
     * Get the lines that represent the entities on the world.
     *
     * @param worldName - the name of the world.
     *
     * @return the lines that represent the entities on the world
     */
    protected abstract List<String> getWorldContents(String worldName);

}
