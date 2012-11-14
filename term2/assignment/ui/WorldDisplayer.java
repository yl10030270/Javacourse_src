/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign3.a00811101.ui;


import ca.bcit.cst.comp2526.assign3.a00811101.EntityFactory;


/**
 * The abstraction of displaying a world.
 *
 * @author Leon
 * @version 1.0
 */
public interface WorldDisplayer
{
    /**
     * Display the world.
     *
     * @param factory - The entity creator.
     */
    void displayWorld(EntityFactory factory);

}
