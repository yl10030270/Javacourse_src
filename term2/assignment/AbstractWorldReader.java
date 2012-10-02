/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


//import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author leon
 */
public abstract class AbstractWorldReader
    implements WorldReader
{
    private MutableWorld world;

    public AbstractWorldReader()
    {
    }

    @Override
    public final MutableWorld readWorld(String worldName)
        throws InvalidWorldException
    {

        try
        {
            this.openWorldData(worldName);

        }
        catch(InvalidWorldException e)
        {
            throw e;
        }

        world = new MutableWorld(getNumberOfRows(),
                                 getNumberOfColumns());

        MutableTile temp;
        WallEntity tempEntity;
        Location tempLocation;
        
        for(int i = 0;
            i < getNumberOfRows();
            i++)
        {
            getWorldContents().
                set(i,
                    getWorldContents().
                get(i).
                replace(".",
                        " "));
            for(int j = 0;
                j < getNumberOfColumns();
                j++)
            {
                tempLocation = new Location(i,
                                            j);
                temp = new MutableTile(tempLocation);
                tempEntity = new WallEntity(getWorldContents().
                    get(i).
                    charAt(j));
                tempEntity.setLocation(tempLocation);
                temp.setEntity(tempEntity);
                world.getTiles()[i][j] = temp;
            }
        }

        this.closeWorldData();
        return world;
    }

    protected abstract void openWorldData(String worldName)
        throws InvalidWorldException;

    protected abstract void closeWorldData();

    protected abstract int getNumberOfRows();

    protected abstract int getNumberOfColumns();

    protected abstract List<String> getWorldContents();
}
