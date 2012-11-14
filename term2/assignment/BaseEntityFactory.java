/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


import ca.bcit.cst.comp2526.assign3.a00811101.worldreader.UnknownEntityTypeException;


/**
 * Create entities based on the value in a data source.
 *
 * @author Leon
 * @version 1.0
 */
public class BaseEntityFactory
    implements EntityFactory
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
    @Override
    public final Entity createEntity(final char type,
                                     final Location location)
        throws UnknownEntityTypeException
    {
        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }
        return doCreateEntity(type,
                              location);
    }

    /**
     * Throws an UnknownEntityTypeException.
     * It is intended that subclasses override this method.
     *
     * @param type     the type of entity to create.
     * @param location the location that the entity is on.
     *
     * @return the entity created.
     *
     * @throws UnknownEntityTypeException - if the type of entity is unrecognized.
     */
    protected Entity doCreateEntity(final char type,
                                    final Location location)
        throws UnknownEntityTypeException
    {
        final Entity retEnt;

        if(type == getKeyForNullEntity())
        {
            retEnt = null;
        }
        else
        {
            if(type == getKeyForWallEntity())
            {
                retEnt = new WallEntity(this);
            }
            else
            {
                throw new UnknownEntityTypeException(type,
                                                     location);
            }
        }
        return retEnt;
    }

    /**
     * Get the character for the null entity from a data source.
     *
     * @return '.'
     */
    @Override
    public char getKeyForNullEntity()
    {
        return '.';
    }

    /**
     * Get the character for the wall entity from a data source.
     *
     * @return '*'
     */
    @Override
    public char getKeyForWallEntity()
    {
        return '*';
    }

    /**
     * Get the character for the null entity for displaying.
     *
     * @return ' '
     */
    @Override
    public char getLabelForNullEntity()
    {
        return ' ';
    }

    /**
     * Get the character for the wall entity for displaying.
     *
     * @return '*';
     */
    @Override
    public char getLabelForWallEntity()
    {
        return '*';
    }

}
