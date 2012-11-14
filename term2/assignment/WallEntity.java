/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * A wall on a world.
 *
 * @author leon
 * @version 1.0
 */
public final class WallEntity
        extends AbstractEntity
{
    /**
     * Construct a WallEntity.
     *
     * @param factory - used to get the label for display
     */
    public WallEntity(final EntityFactory factory)
    {
        super(factory.getLabelForWallEntity());
    }

}
