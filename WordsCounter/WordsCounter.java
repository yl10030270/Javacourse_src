import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class WordsCounter {
    public List<String> lyrics;
    public TreeMap<String, Integer> result;
    public String delimString; 
    
    public WordsCounter(List<String> lyrics , String delim) {
        super();
        this.lyrics = lyrics;
        this.delimString = delim;
        result =  new TreeMap<>();
    }

    public void Count(){
        for (String line : lyrics) {
            List<String> wordsList = readLine(line, delimString);
            for (String word : wordsList) {
                if(result.containsKey(word)){
                    int value = result.get(word);
                    result.put(word, ++value);
                }else{
                    result.put(word, 1);
                }
            }
        }
    }
    
    public void printResult(){
        for (String word : result.keySet()) {
            System.out.println(word + " - " + result.get(word));
        }
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
