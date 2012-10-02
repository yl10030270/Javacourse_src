/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public abstract class AbstractEntity
    implements Entity
{
    /**
     *
     */
    private Location location;
    private char label;

    protected AbstractEntity(char lbl)
    {
        label = lbl;
        location = null;
    }

    @Override
    public void setLocation(Location loc)
    {
        location = loc;
    }

    /**
     *
     * @return
     */
    @Override
    public Location getLocation()
    {
        return location;
    }

    /**
     *
     * @return
     */
    @Override
    public char getLabel()
    {
        return label;
    }
}
