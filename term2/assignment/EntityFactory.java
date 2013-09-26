/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.UnknownEntityTypeException;


/**
 * Abstraction to create entities based on.
 * the value in a data source.
 *
 * @author Leon
 * @version 1.0
 */
public interface EntityFactory
{
    /**
     * Create an entity based on the character.
     *
     * @param type     the type of entity to create.
     * @param location the location that the entity is on.
     *
     * @return the entity created.
     *
     * @throws UnknownEntityTypeException - if the type of entity is unrecognized.
     */
    Entity createEntity(char type,
                        Location location)
        throws UnknownEntityTypeException;

    /**
     * Get the character for the null entity.
     *
     * @return the character for reading the null entity.
     */
    char getKeyForNullEntity();

    /**
     * Get the character for the wall entity.
     * from a data source.
     *
     * @return the character for reading the wall entity.
     */
    char getKeyForWallEntity();

    /**
     * Get the character for the null entity.
     * for displaying.
     *
     * @return the character for displaying the null entity.
     */
    char getLabelForNullEntity();

    /**
     * Get the character for the wall entity.
     * for displaying.
     *
     * @return the character for displaying the wall entity.
     */
    char getLabelForWallEntity();

}
