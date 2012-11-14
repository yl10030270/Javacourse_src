/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A collection of tiles that make up a map.
 *
 * @author Leon
 * @version 1.0
 */
public interface World
    extends Rectangle
{
    /**
     * Initialize the tiles on the world.
     */
    void init();

    /**
     * Get the tile at the specified location.
     *
     * @param location the location of the tile to get.
     *
     * @return the tile at the specified location.
     */
    Tile getTileAt(Location location);

}
