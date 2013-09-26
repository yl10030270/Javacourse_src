/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader;


import ca.bcit.cst.comp2526.assign3.a00811101.DefaultMutableWorld;
import ca.bcit.cst.comp2526.assign3.a00811101.EntityFactory;
import ca.bcit.cst.comp2526.assign3.a00811101.TooFewColumnsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooFewRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooManyColumnsException;
import ca.bcit.cst.comp2526.assign3.a00811101.TooManyRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.WorldBounds;


/**
 * Abstraction for reading a world from a data source.
 *
 * @author Leon
 * @version 1.0
 */
public interface WorldReader
{
    /**
     * Read the world from a data source.
     *
     * @param worldName - the reader dependant name to lookup the data from.
     * @param factory   - used to create the entities on the world.
     * @param bounds    - the min/max size that the world can be.
     *
     * @return DefaultMutableWorld
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
     */
    DefaultMutableWorld readWorld(java.lang.String worldName,
                                  EntityFactory factory,
                                  WorldBounds bounds)
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
               WorldDataSourceException;

}
