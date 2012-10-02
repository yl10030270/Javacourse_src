/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign1.a00811101;


import ca.bcit.cst.comp2526.assign1.a00811101.ui.console.ConsoleWorldDisplayer;


/**
 *
 * @author leon
 */
public class Main
{
    public static void main(String[] args)
        throws InvalidWorldException
    {
        if(args.length > 1)
        {
            throw new InvalidWorldException("Invalid argument.");
        }
        else if(args.length == 0)
        {
            throw new InvalidWorldException("No worldpath,please enter the world file path.");
        }
        (new ConsoleWorldDisplayer((new FileWorldReader()).readWorld(args[0]),
                                   "Test")).displayWorld();

    }
//
//    public static void add(float a,
//                           float b)
//        throws Exception
//    {
//
//        if(a == b)
//        {
//            throw new Exception("输入的数相等！");
//        }
//
//    }
}
