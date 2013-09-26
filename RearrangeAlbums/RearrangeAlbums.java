import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeAlbums {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            List<String> linesList = readFile(args[0]);
            Iterator<String> iterator = linesList.iterator();
            int testCaseNumber = Integer.parseInt(iterator.next());
            for (int i = 0; i < testCaseNumber; i++) {
                int size = Integer.parseInt(iterator.next().trim());
                List<String> originalOrder = new ArrayList<String>();
                List<String> desiredOrder = new ArrayList<String>();
                for (int j = 0; j < size; j++) {
                    originalOrder.add(iterator.next().trim());
                }
                for (int j = 0; j < size; j++) {
                    desiredOrder.add(iterator.next().trim());
                }
                Rearrage(originalOrder, desiredOrder);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void Rearrage(List<String> originalOrder,
            List<String> desiredOrder) {
        // TODO Auto-generated method stub
        int size = originalOrder.size();
        List<KeyValuePair> originalIndexing = new ArrayList<KeyValuePair>(size);
        for (int i = 0; i < size; i++) {
            originalIndexing.add(null);
        }
        for (int i = 0; i < size; i++) {
            String s = desiredOrder.get(i);
            int oidx = originalOrder.indexOf(s);
            originalIndexing.set(oidx, new KeyValuePair(i, s));
        }
        int currectOrder = originalIndexing.get(0).getKey();
        TreeMap<Integer, String> outputTree = new TreeMap<Integer, String>();
        int i = 1;
        while (i < originalIndexing.size()) {
            KeyValuePair currentAlbum = originalIndexing.get(i);
            if (currentAlbum.getKey() < currectOrder) {
                originalIndexing.remove(currentAlbum);
                outputTree.put(currentAlbum.getKey(), currentAlbum.getValue());
            } else if (currentAlbum.getKey() - currectOrder == 1) {
                currectOrder = currentAlbum.getKey();
                i++;
            } else {
                for (int j = 0; j < i; j++) {
                    KeyValuePair removedAlbum = originalIndexing.remove(j);
                    outputTree.put(removedAlbum.getKey(),
                            removedAlbum.getValue());
                }
                currectOrder = currentAlbum.getKey();
            }
        }
        Output(outputTree);
    }

    private static void Output(TreeMap<Integer, String> outputTree) {
        Map.Entry<Integer, String> albumEntry;
        while ((albumEntry = outputTree.pollLastEntry()) != null) {
            System.out.println(albumEntry.getValue());
        }
        System.out.println();
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
