/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


import ca.bcit.cst.comp2526.assign3.a00811101.ui.console.ConsoleWorldDisplayer;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.ColumnsNotIntegerException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.EmptyDataException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.ExtraRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.LongRowException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.MissingRowsException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.RowsNotIntegerException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.ShortRowException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.UnknownEntityTypeException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.WorldDataSourceException;
import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.file.FileWorldReader;
import java.io.File;


/**
 * A program that loads a world from the specified file and displays it on the console.
 *
 * @author Leon
 * @version 1.0
 */
public final class Main
{
    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_FEW_ARGUMENT_EXIT_CODE = 1;

    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_MANY_ARGUMENT_EXIT_CODE = 2;

    /**
     * the number represent the reason of exit.
     */
    public static final int BAD_FILE_NAME_EXIT_CODE = 3;

    /**
     * the number represent the reason of exit.
     */
    public static final int NOT_A_FILE_EXIT_CODE = 4;

    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_FEW_ROWS_EXIT_CODE = 5;

    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_MANY_ROWS_EXIT_CODE = 6;

    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_FEW_COLUMNS_EXIT_CODE = 7;

    /**
     * the number represent the reason of exit.
     */
    public static final int TOO_MANY_COLUMNS_EXIT_CODE = 8;

    /**
     * the number represent the reason of exit.
     */
    public static final int SHORT_ROW_EXIT_CODE = 9;

    /**
     * the number represent the reason of exit.
     */
    public static final int LONG_ROW_EXIT_CODE = 10;

    /**
     * the number represent the reason of exit.
     */
    public static final int ROWS_NOT_AN_INTEGER_EXIT_CODE = 11;

    /**
     * the number represent the reason of exit.
     */
    public static final int COLUMNS_NOT_AN_INTEGER_EXIT_CODE = 12;

    /**
     * the number represent the reason of exit.
     */
    public static final int UNKNOWN_ENTITY_TYPE_EXIT_CODE = 13;

    /**
     * the number represent the reason of exit.
     */
    public static final int MISSING_ROWS_EXIT_CODE = 14;

    /**
     * the number represent the reason of exit.
     */
    public static final int EXTRA_ROWS_EXIT_CODE = 15;

    /**
     * the number represent the reason of exit.
     */
    public static final int EMPTY_DATA_EXIT_CODE = 16;

    /**
     * the number represent the reason of exit.
     */
    public static final int WORLD_DATA_SOURCE_EXIT_CODE = 17;

    /**
     * the number of minimal rows the world has to have.
     */
    public static final int SMALLEST_ROWS = 3;

    /**
     * the number of minimal columns the world has to have.
     */
    public static final int SMALLEST_COLUMNS = 3;

    /**
     * the number of maximum rows the world can have.
     */
    public static final int LARGEST_ROWS = 100;

    /**
     * the number of maximum columns the world can have.
     */
    public static final int LARGEST_COLUMNS = 100;

    /**
     * for deal with the checkstyle.
     */
    private Main()
    {
    }

    /**
     * Display the usage message and exit with the specified exit code.
     *
     * @param message  the message to print out before the usage message.
     *                 If null nothing is displayed.
     * @param exitCode the code to pass to System.exit.
     */
    private static void usage(final String message,
                              final int exitCode)
    {
        if(message != null)
        {
            System.err.println(message);
        }

        fatal(String.format("Usage: java ca.bcit.cst.comp2526.assign3.a00811101.Main " + "<world-name>%n"), exitCode);
    }

    /**
     * Display the usage message and exit with the specified exit code.
     *
     * @param message  the message to display to System.err.
     * @param exitCode the code to pass to System.exit.
     */
    private static void fatal(final String message,
                              final int exitCode)
    {
        System.err.println(message);
        System.exit(exitCode);
    }

    /**
     * Program main entry.
     *
     * @param argv - to store the file path
     */
    public static void main(final String[] argv)
    {
        final String errMess;
        final int exitCode;
        final File file;
        final FileWorldReader reader;
        final EntityFactory enfactory;
        final WorldBounds wBounds;
        MutableWorld world = null;

        if(argv.length > 1)
        {
            usage("Too many arguments", TOO_MANY_ARGUMENT_EXIT_CODE);
        }

        if(argv.length == 0)
        {
            usage("Missing world-name", TOO_FEW_ARGUMENT_EXIT_CODE);
        }


        reader = new FileWorldReader();

        enfactory = new BaseEntityFactory();

        wBounds = new WorldBounds(SMALLEST_ROWS, SMALLEST_COLUMNS, LARGEST_ROWS, LARGEST_COLUMNS);

        try
        {
            world = reader.readWorld(argv[0], enfactory, wBounds);
        }
        catch(final TooFewRowsException ex)
        {
            usage(argv[0] + " the world must have at least 3 rows on it", TOO_FEW_ROWS_EXIT_CODE);
        }
        catch(final TooManyRowsException ex)
        {
            usage(argv[0] + " the world must have at most 100 rows on it", TOO_MANY_ROWS_EXIT_CODE);
        }
        catch(final TooFewColumnsException ex)
        {
            usage(argv[0] + " the world must have at least 3 columns on it", TOO_FEW_COLUMNS_EXIT_CODE);
        }
        catch(final TooManyColumnsException ex)
        {
            usage(argv[0] + " the world must have at most 100 columns on it", TOO_MANY_COLUMNS_EXIT_CODE);
        }
        catch(final ShortRowException ex)
        {
            usage(argv[0] + " row " + ex.getRow() + " has too few entities", SHORT_ROW_EXIT_CODE);
        }
        catch(final LongRowException ex)
        {
            usage(argv[0] + " row " + ex.getRow() + " has too many entities", LONG_ROW_EXIT_CODE);
        }
        catch(final RowsNotIntegerException ex)
        {
            usage(argv[0] + " the rows must be an integer", ROWS_NOT_AN_INTEGER_EXIT_CODE);
        }
        catch(final ColumnsNotIntegerException ex)
        {
            usage(argv[0] + " the columns must be an integer", COLUMNS_NOT_AN_INTEGER_EXIT_CODE);
        }
        catch(final UnknownEntityTypeException ex)
        {
            usage(argv[0] + " unknown entity type \"" + ex.getKey() + "\"" + " on row: " + ex.getRow() + " at column: " + ex.getColumn(),
                  UNKNOWN_ENTITY_TYPE_EXIT_CODE);
        }
        catch(final MissingRowsException ex)
        {
            usage(argv[0] + " has too few rows of data", MISSING_ROWS_EXIT_CODE);
        }
        catch(final ExtraRowsException ex)
        {
            usage(argv[0] + " has too many rows of data", EXTRA_ROWS_EXIT_CODE);
        }
        catch(final EmptyDataException ex)
        {
            usage(argv[0] + " is empty", EMPTY_DATA_EXIT_CODE);
        }
        catch(final WorldDataSourceException ex)
        {

            file = new File(argv[0]);

            if(file.isDirectory())
            {
                errMess = " is not a file";
                exitCode = NOT_A_FILE_EXIT_CODE;
            }
            else
            {
                errMess = " does not exist";
                exitCode = BAD_FILE_NAME_EXIT_CODE;
            }
            usage(argv[0] + errMess, exitCode);
        }

        final ConsoleWorldDisplayer displayer;
        displayer = new ConsoleWorldDisplayer(world, argv[0]);
        displayer.displayWorld(enfactory);
    }

}
