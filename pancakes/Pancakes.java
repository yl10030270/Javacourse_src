/*
 * Liang Yang
 * A00811101
 * Set 3D
 *
 *
 * Algorithm sortPancakes(stack[0...n-1]
 *    for i <- 0 to n-2 do
 *       maxvalue index <- findmaxvalueinstack(i)
 *       if(maxvalueindex == i)
 *			continue;
 *       else if(maxvalueindex == n-1)
 *          flip(i + 1)
 *		 else 
 *          flip(maxvalueindex + 1)
 *          flip(i + 1)
 *    return stack[0...n-1]
 * End Algorithm
 * 
 */
package pancakes;


import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author leon
 */
public class Pancakes
{
    /**
     * @param args the command line arguments
     */
    private static List<String> inputLines;

    private static ArrayDeque<Integer> flipOrder = new ArrayDeque<>();

    private static Stack<Integer> panStack = new Stack<>();

    private static int pansize;

    public static void main(String[] args)
    {
        try
        {
            sortPancakes(args[0]);// TODO code application logic here
        }
        catch(Exception e)
        {
            System.out.println("Exception" + e.toString());
        }
    }

    private static void sortPancakes(final String filepath)
        throws Exception
    {
        inputLines = readFile(filepath);

        for(String string : inputLines)
        {
            Stack<Integer> temp = new Stack<>();
            final Scanner scan = new Scanner(string);
            pansize = 0;
            while(scan.hasNextInt())
            {
                temp.push(scan.nextInt());
                pansize++;
            }
            while(!temp.empty())
            {
                panStack.push(temp.pop());
            }

            sort();

            System.out.println(string);
            final int flipsize = flipOrder.size();
            for(int i = 0; i < flipsize; i++)
            {
                System.out.print("" + flipOrder.poll() + " ");
            }
            System.out.println("");
            panStack.clear();
        }
    }

    private static List<String> readFile(final String filePath)
        throws Exception
    {
        final FileSystem fileSystem;
        final Path path;

        fileSystem = FileSystems.getDefault();
        path = fileSystem.getPath(filePath);

        final List<String> lines;

        lines = Files.readAllLines(path,
                                   StandardCharsets.UTF_8);

        if(lines.isEmpty())
        {
            throw new Exception("Empty File.");
        }
        return lines;
    }

    private static void sort()
    {
        for(int i = 0; i < pansize - 1; i++)
        {
            int maxIndex = findMax(i);
            if(maxIndex == i)
            {
                continue;
            }
            else if(maxIndex == pansize - 1)
            {
                flip(i);
            }
            else
            {
                flip(maxIndex);
                flip(i);
            }
        }
        flipOrder.add(0);

    }

    private static int findMax(int range)
    {
        int max = panStack.get(range);
        int maxindex = range;
        for(int i = range; i < panStack.size(); i++)
        {
            final int temp = panStack.get(i);
            if(temp > max)
            {
                max = temp;
                maxindex = i;
            }
        }
        return maxindex;
    }

    private static void flip(int index)
    {
        ArrayDeque<Integer> temp = new ArrayDeque<>();;
        flipOrder.add(index + 1);
        for(int i = 0; i < pansize - index; i++)
        {
            temp.add(panStack.pop());
        }
        for(int i = 0; i < pansize - index; i++)
        {
            panStack.push(temp.poll());
        }
    }

}
