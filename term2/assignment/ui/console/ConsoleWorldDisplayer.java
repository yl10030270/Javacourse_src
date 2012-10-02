/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101.ui.console;


import ca.bcit.cst.comp2526.assign1.a00811101.World;
import ca.bcit.cst.comp2526.assign1.a00811101.ui.WorldDisplayer;


/**
 *
 * @author leon
 */
public class ConsoleWorldDisplayer
    implements WorldDisplayer
{
    private World world;
    private String worldName;

    public ConsoleWorldDisplayer(World w,
                                 String name)
    {
        world = w;
        worldName = name;
    }

    @Override
    public void displayWorld()
    {
        for(int i = 0;
            i < world.getNumberOfRows();
            i++)
        {
            for(int j = 0;
                j < world.getNumberOfCols();
                j++)
            {
                System.out.print(world.getTiles()[i][j].getEntity().
                    getLabel());
            }
            System.out.print("\n");
        }

    }
}
