/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author leon
 */
public class FileWorldReader
    extends AbstractWorldReader
{
    private FileReader reader;
    private BufferedReader in;
    //private MutableWorld world;
    private int NumberOfRows;
    private int NumberOfColumns;
    private List<String> WorldContents = new ArrayList<>();
    
    public FileWorldReader()
    {
    }


    @Override
    protected void openWorldData(String filePath)
        throws InvalidWorldException
    {
        String line;
        int[] num = new int[2];
        int numLines = 0;

        try
        {
            reader = new FileReader(filePath);
        }
        catch(FileNotFoundException ex)
        {
            throw new InvalidWorldException(ex.getMessage(),
                                            ex.getCause());
        }
        in = new BufferedReader(reader);
        for(int i = 0;
            i <= 1;
            i++)
        {
            try
            {
                line = in.readLine();
            }
            catch(IOException ex)
            {
                throw new InvalidWorldException(ex.getMessage(),
                                                ex.getCause());
            }
            if(NumberUtils.isInt(line))
            {
                num[i] = Integer.parseInt(line);
                if(num[i] < 3)
                {
                    throw new InvalidWorldException("Number of rows or columns is too small.");
                }
            }
            else
            {
                throw new InvalidWorldException("Number of rows or columns is not integer.");
            }
        }
        NumberOfRows = num[0];
        NumberOfColumns = num[1];

        for(int i = 0;
            i < NumberOfRows;
            i++)
        {
            try
            {
                line = in.readLine();
            }
            catch(IOException ex)
            {
                throw new InvalidWorldException(ex.getMessage(),
                                                ex.getCause());
            }
            WorldContents.add(line);
        }
    }

    @Override
    protected void closeWorldData()
    {
        try
        {
            in.close();
        }
        catch(IOException ex)
        {
            Logger.getLogger(FileWorldReader.class.getName()).
                log(Level.SEVERE,
                    null,
                    ex);
        }
    }

    @Override
    protected int getNumberOfRows()
    {
        return NumberOfRows;
    }

    @Override
    protected int getNumberOfColumns()
    {
        return NumberOfColumns;
    }

    @Override
    protected List<String> getWorldContents()
    {
        return WorldContents;
    }
}
