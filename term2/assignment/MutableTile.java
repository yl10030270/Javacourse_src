/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A tile that can change the entity that is on it.
 *
 * @author Leon
 * @version 1.0
 */
public class MutableTile
    extends Tile
{
    /**
     * The world that the tile is on.
     */
    private final MutableWorld world;

    /**
     * Construct a MutableTile with the specified location.
     *
     * @param loc - the location of the tile.
     * @param w   - the world that the tile is on.
     */
    public MutableTile(final Location loc,
                       final MutableWorld w)
    {
        super(loc,
              w);
        world = w;
    }

    /**
     * Set the entity for the tile.
     * If there is already an entity on the tile
     * then that entity has its location set to null.
     * If the entity being placed on the tile is not null
     * then that entity has its location set to the location of the tile.
     *
     * @param e - the entity to place on the tile, may be null.
     *
     * @return the entity that was on the tile already,
     *         or null if there was no pre-existing entity.
     */
    public Entity setEntity(final Entity e)
    {
        Entity retVal = null;

        if(entity != null)
        {
            entity.setLocation(null);
            retVal = entity;
        }

        if(e == null)
        {
            entity = null;
        }
        else
        {
            if(e.getLocation() != null)
            {
                world.getTileAt(e.getLocation()).setEntity(null);
            }
            e.setLocation(location);
            entity = e;
        }
        return retVal;
    } //setEntity

}
