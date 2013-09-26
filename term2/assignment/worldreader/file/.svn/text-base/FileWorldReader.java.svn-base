/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.worldreader.file;


import ca.bcit.cst.comp2526.assign3.a00811101.NumberUtils;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.AbstractWorldReader;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.ColumnsNotIntegerException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.EmptyDataException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.RowsNotIntegerException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.WorldDataSourceException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Read a world from a local file.
 *
 * @author Leon
 * @version 1.0
 */
public class FileWorldReader
    extends AbstractWorldReader
{
    /**
     * The Buffered Reader to read the File.
     */
    private BufferedReader in;

    /**
     * Open the data source.
     *
     * @param filePath - the path to the local file.
     *
     * @throws EmptyDataException       - if there is no data in the file.
     * @throws WorldDataSourceException - if there is an underlying problem reading the file.
     */
    @Override
    protected void openWorldData(final String filePath)
        throws EmptyDataException,
               WorldDataSourceException
    {
        final File file = new File(filePath);

        try
        {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.defaultCharset()));
        }
        catch(final FileNotFoundException ex)
        {
            throw new WorldDataSourceException(ex);
        }

        if(file.length() == 0)
        {
            throw new EmptyDataException();
        }

    }

    /**
     * Get the number of rows on the world.
     *
     * @param worldName -the name of the world to read.
     *
     * @return the number of rows on the word.
     *
     * @throws RowsNotIntegerException -throw when the number of rows is not an integer.
     */
    @Override
    protected int getNumberOfRows(final String worldName)
        throws RowsNotIntegerException
    {
        String line = "";
        try
        {
            line = in.readLine();
        }
        catch(final IOException ex)
        {
            Logger.getLogger(FileWorldReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!NumberUtils.isInt(line))
        {
            throw new RowsNotIntegerException(line);
        }
        return Integer.parseInt(line);
    }

    /**
     * Get the number of columns on the world.
     *
     * @param worldName -the name of the world to read.
     *
     * @return the number of columns on the word.
     *
     * @throws ColumnsNotIntegerException - throw when the number of columns is not an integer.
     */
    @Override
    protected int getNumberOfColumns(final String worldName)
        throws ColumnsNotIntegerException
    {
        String line = "";
        try
        {
            line = in.readLine();
        }
        catch(final IOException ex)
        {
            Logger.getLogger(FileWorldReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!NumberUtils.isInt(line))
        {
            throw new ColumnsNotIntegerException(line);
        }
        return Integer.parseInt(line);
    }

    /**
     * Get the lines that represent the entities on the world.
     *
     * @param worldName -the name of the world to read.
     *
     * @return the lines that represent the entities on the world.
     */
    @Override
    protected List<String> getWorldContents(final String worldName)
    {
        final List<String> line;
        line = new ArrayList<>();

        do
        {
            try
            {
                line.add(in.readLine());
            }
            catch(final IOException ex)
            {
                Logger.getLogger(FileWorldReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(line.get(line.size() - 1) != null);
        line.remove(line.size() - 1);
        return line;
    }

    /**
     * Close the data source.
     *
     * @param worldName -the name of the world to read.
     */
    @Override
    protected void closeWorldData(final String worldName)
    {
        try
        {
            in.close();
        }
        catch(final IOException ex)
        {
            Logger.getLogger(FileWorldReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
