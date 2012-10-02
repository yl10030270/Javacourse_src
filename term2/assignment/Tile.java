/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class Tile
{
    protected Entity entity;
    protected Location location;

    public Tile(Location loc)
    {
        entity = null;
        location = loc;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public Location getLocation()
    {
        return location;
    }
}
