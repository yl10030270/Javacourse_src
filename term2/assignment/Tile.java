/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A place on a world(think of it like a square on a chess board).
 *
 * @author Leon
 * @version 1.0
 */
public class Tile
{
    /**
     * The entity that is on the tile, null if there is no entity.
     */
    protected Entity entity;

    /**
     * The location of the tile.
     */
    protected final Location location;

    /**
     * Construct a Tile with the specified location.
     *
     * @param loc - the location of the tile.
     * @param w   - the world that the tile is on.
     */
    public Tile(final Location loc,
                final World w)
    {
        if(loc == null)
        {
            throw new IllegalArgumentException("loc cannot be null");
        }
        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }
        entity = null;
        location = loc;
    }

    /**
     * Get the entity that is on the tile.
     *
     * @return the entity on the tile,
     *         or null if the tile has no entity.
     */
    public Entity getEntity()
    {
        return entity;
    }

    /**
     * Get the location of the tile on the world.
     *
     * @return the location of the tile on the world.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return location.toString() + " --> " + ((entity == null) ?
                                                "null" :
                                                entity.toString());
    }

}
