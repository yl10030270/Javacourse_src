/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.ui.console;


import ca.bcit.cst.comp2526.assign3.a00811101.EntityFactory;
import ca.bcit.cst.comp2526.assign3.a00811101.Location;
import ca.bcit.cst.comp2526.assign3.a00811101.Tile;
import ca.bcit.cst.comp2526.assign3.a00811101.World;
import ca.bcit.cst.comp2526.assign3.a00811101.ui.WorldDisplayer;


/**
 * Display a world to the console via System.out.
 *
 * @author Leon
 * @version 1.0
 */
public class ConsoleWorldDisplayer
    implements WorldDisplayer
{
    /**
     * the world to display.
     */
    private final World world;

    /**
     * Construct a ConsoleWorldDisplayer with the specified values.
     *
     * @param w    - the world to display.
     * @param name - the name of the world.
     */
    public ConsoleWorldDisplayer(final World w,
                                 final String name)
    {
        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }
        if(name == null)
        {
            throw new IllegalArgumentException("name cannot be null");
        }
        if(name.trim().isEmpty())
        {
            throw new IllegalArgumentException("name cannot be empty");
        }

        world = w;
    }

    /**
     * Display the world.
     *
     * @param factory - used to display the null entity.
     */
    @Override
    public void displayWorld(final EntityFactory factory)
    {
        if(factory == null)
        {
            throw new IllegalArgumentException("factory cannot be null");
        }
        final int r = world.getNumberOfRows();
        final int c = world.getNumberOfColumns();
        char lab;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                final Tile temptile = world.getTileAt(Location.create(i, j, world));
                if(temptile.getEntity() == null)
                {
                    lab = factory.getLabelForNullEntity();
                }
                else
                {
                    lab = temptile.getEntity().getLabel();
                }
                System.out.print(lab);
            }
            System.out.println("");
        }
    }

}
