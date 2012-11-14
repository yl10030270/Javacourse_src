/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A "thing" on a tile of a world.
 *
 * @author Leon
 * @version 1.0
 */
public interface Entity
{
    /**
     * Set the location of the entity.
     *
     * @param loc the location of the entity
     */
    void setLocation(Location loc);

    /**
     * Get the location of the entity.
     *
     * @return the location of the entity.
     */
    Location getLocation();

    /**
     * Get the label for the entity.
     * This is the character that represents the entity
     * on the console.
     *
     * @return the label of the entity.
     */
    char getLabel();

}
