import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] argv){
        Map<String, Integer> m = new HashMap<>();
        String path = System.getProperty("user.dir");
        String s;
        String[] w = null;
        Vector<String> words=  new Vector<String >();

        try (BufferedReader br = new BufferedReader(new FileReader(path + "/src/" + "test.txt"))) {
            while ((s = br.readLine()) != null) {
                /**
                 *  Words are strings delimited by white spaces
                 *  (punctuation marks such as: period, comma, question mark, exclamation mark,
                 *  colon, semicolon, hyphen, dash parentheses, brackets, ellipsis, apostrophe,
                 *  quotation marks, slash are not part of an word
                 */
                w = s.split("\\s+");
                for(int i = 0; i < w.length; i++){
                    words.add(w[i]);
                }
            }


            for(String key : words){
                Integer val = m.get(key);
                Integer newVal = (val == null) ? 1 : val + 1;
                m.put(key, newVal);
            }

            for(Map.Entry<String, Integer> e : m.entrySet())
                System.out.println(e.getKey() + " ---> " + e.getValue());
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
