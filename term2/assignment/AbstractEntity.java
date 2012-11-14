/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101;


/**
 * Convenience class for common entity features.
 *
 * @author leon
 * @version 1.0
 */
public abstract class AbstractEntity
        implements Entity
{
    /**
     * The location of the entity.
     */
    private Location location;

    /**
     * The specified character represent the entity.
     */
    private final char label;

    /**
     * Construct an AbstractEntity with the specified label.
     *
     * @param lbl the label
     */
    protected AbstractEntity(final char lbl)
    {
        label = lbl;
        location = null;
    }

    /**
     * Set the location of the entity.
     *
     * @param loc the location to place the entity.
     */
    @Override
    public void setLocation(final Location loc)
    {
        location = loc;
    }

    /**
     * Get the location of the entity.
     *
     * @return the location of the entity.
     */
    @Override
    public Location getLocation()
    {
        return location;
    }

    /**
     * Get the label.
     *
     * @return the label.
     */
    @Override
    public char getLabel()
    {
        return label;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        String retStr;
        if(location == null)
        {
            retStr = getLabel() + " null";
        }
        else
        {
            retStr = getLabel() + " " + getLocation().toString();
        }
        return retStr;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        int hash;
        hash = (int)getLabel();
        return hash;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
    {
        final boolean retval;
        if(obj == null)
        {
            retval = false;
        }
        else
        {
            if(getClass() == obj.getClass() && this.label == ((AbstractEntity)obj).label)
            {
                final AbstractEntity other;
                other = (AbstractEntity)obj;


                if(this.location == null)
                {
                    retval = (other.location == null);

                }
                else
                {
                    retval = (this.location.equals(other.location));

                }


            }
            else
            {
                retval = false;
            }
        }

        return retval;
    }

}
