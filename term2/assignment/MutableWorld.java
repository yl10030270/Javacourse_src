/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public class MutableWorld
    extends World
{
    public MutableWorld(int rows,
                        int cols)
    {
        super(rows,
              cols);
    }

    @Override
    public MutableTile getTileAt(Location location)
    {
        return tiles[location.getRow()][location.getColumn()];
    }

    @Override
    public MutableTile[][] getTiles()
    {
        return tiles;
    }
}
