/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


/**
 *
 * @author leon
 */
public interface WorldReader
{
    static final char NULL_ENTITY_KEY = 46;
    static final char WALL_ENTITY_KEY = 42;
    
    MutableWorld readWorld(String worldName)
        throws InvalidWorldException;
}
