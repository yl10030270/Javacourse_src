import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SpellChecker {

    public static void main(String[] args) throws Exception {
        /*
         * counter <- 0 
         * paragraph <- read paragraph 
         * dictionary <- read dictionary 
         * stop watch start 
         * counter <- SeqSearch(paragraph ,dictionary) 
         * stop watch stop 
         * print counter 
         * stop watch reset and start 
         * counter <- BinSearch(paragraph , dictionary) 
         * stop watch stop 
         * print counter 
         * return
         */
        int counter = 0;
        List<String> paragraphList = new ArrayList<>();
        paragraphList = readLine(readFile(args[0]).get(0), " ,.;-\":?");
        List<String> dictionaryList = new ArrayList<>();
        dictionaryList = readFile(args[1]);
        Stopwatch timer = new Stopwatch();
        String[] dicStrings = new String[dictionaryList.size()];
        timer.start();
        counter = SeqSearch(paragraphList, dictionaryList.toArray(dicStrings));
        timer.stop();
        System.out.println(Output("Sequential", counter, timer));
        timer.reset();
        timer.start();
        counter = BinSearch(paragraphList, dictionaryList.toArray(dicStrings));
        timer.stop();
        System.out.println(Output("Binary", counter, timer));
    }

    private static String Output(String type, int counter, Stopwatch timer) {
        StringBuilder outString = new StringBuilder(type);
        outString.append(" Search: ");
        outString.append(counter);
        outString.append(" errors, ");
        outString.append(timer.getElapsedTime());
        outString.append(" milliseconds.");
        return outString.toString();
    }

    public static int SeqSearch(List<String> paragraph, String[] dictionary) {
        /*
         * counter <- 0 
         * for each word in list paragraph do 
         *   found <- false 
         *   for i<- 0 to size of dictionary do 
         *      if dictionary[i] = word 
         *          found <- true
         *          break 
         *   if not found 
         *      counter++ 
         * return counter
         */

        int counter = 0;
        for (String word : paragraph) {
            boolean found = false;
            for (int i = 0; i < dictionary.length; i++) {
                if (word.compareToIgnoreCase(dictionary[i]) == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                // System.out.println(word);
                counter++;
            }
        }
        return counter;
    }

    public static int BinSearch(List<String> paragraph, String[] dictionary) {
        /*
         * counter <- 0 
         * for each word in list Paragraph do 
         *      lowerbound <- 0 
         *      upperbound <- Size of dictionary 
         *      found <- false 
         *      while lowerbound <= upperbound 
         *          mid = floor((lowerbound + upperbound)/2) 
         *          if dictionary[mid] > word 
         *              upperbound = mid - 1 
         *          else if dictionary[mid] < word 
         *              lowerbound = mid + 1 
         *          else 
         *              found <- true 
         *              break 
         *      if not found
         *          counter++ 
         * return counter
         */
        int counter = 0;
        for (String word : paragraph) {
            int lowerbound = 0;
            int upperbound = dictionary.length;
            boolean found = false;
            while (lowerbound <= upperbound) {
                int mid = (lowerbound + upperbound) / 2;
                if (dictionary[mid].compareToIgnoreCase(word) > 0) {
                    upperbound = mid - 1;
                } else if (dictionary[mid].compareToIgnoreCase(word) < 0) {
                    lowerbound = mid + 1;
                } else {
                    found = true;
                    break;
                }
            }
            if (!found) {

                counter++;
            }
        }
        return counter;
    }

    public static List<String> readFile(final String filePath) throws Exception {
        final FileSystem fileSystem;
        final Path path;

        fileSystem = FileSystems.getDefault();
        path = fileSystem.getPath(filePath);

        final List<String> lines;

        lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        if (lines.isEmpty()) {
            throw new Exception("Empty File.");
        }
        return lines;
    }

    public static List<String> readLine(final String line, final String delim) {
        StringTokenizer token = new StringTokenizer(line, delim);
        List<String> paragraph = new ArrayList<>();
        while (token.hasMoreTokens()) {
            paragraph.add(token.nextToken());
        }
        return paragraph;
    }
}
