/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class MutableTile
    extends Tile
{
    public MutableTile(Location loc)
    {
        super(loc);
    }

    public Entity setEntity(Entity e)
    {
        Entity temp = null;

        if(entity != null)
        {
            temp = entity;
            entity.setLocation(null);
        }
        else
        {
            if(e.getLocation() != null)
            {
                e.setLocation(location);
                entity = e;
            }
        }

        return temp;

    }
}
