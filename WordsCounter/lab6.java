import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class lab6 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        List<String> lineStrings = readFile(args[0]);
        HashSet<String> wordHashSet = new HashSet<>();
        int i;
        for(i = 0; i < 10; i++){
            wordHashSet.add(lineStrings.get(i));
        }
        Iterator<String> iterator = wordHashSet.iterator();
        i = 1;
        System.out.println("HashSet......");
        while(iterator.hasNext()){
            System.out.println("String " + i++ + ": " +iterator.next());
        }
        System.out.println();
        TreeSet<String> wordTreeSet = new TreeSet<>();
        for(i = 0 ; i < 10; i++){
            wordTreeSet.add(lineStrings.get(i));
        }
        iterator = wordTreeSet.iterator();
        i = 1;
        System.out.println("TreeSet........");
        while(iterator.hasNext()){
            System.out.println("String " + i++ + ": " +iterator.next());
        }
        
        wordHashSet.clear();
        wordHashSet.addAll(lineStrings);
        System.out.println();
        System.out.println(wordHashSet.size() == lineStrings.size() ? "DISTINCT" : "NOT DISTINCT");
        System.out.println();
        System.out.println("Count words in Lyrics........");
        
        lineStrings.clear();
        lineStrings = readFile(args[1]);
        WordsCounter wCounter = new WordsCounter(lineStrings, " ,.;-\":?[]()");
        wCounter.Count();
        wCounter.printResult();
        
    }

    private static List<String> readFile(final String filePath)
            throws Exception {
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

}
