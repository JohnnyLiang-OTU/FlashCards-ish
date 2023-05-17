import java.io.*;
import java.util.HashMap;

public class txtReader
{
    static BufferedReader reader;
    static HashMap<String, String> wordCollection = new HashMap<>();
    static public HashMap<String, String> read(String path) // Get all words into wordColection and return it.
    {
        try
        {
            File file = new File(path);
            reader = new BufferedReader(new FileReader(file.toString()));
            String line = reader.readLine();
            while(line != null)
            {
                formatLine(line);
            }
            return wordCollection;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    static public void formatLine(String line)
    {
        String[] words = line.split("-");
        String pinyin_and_definition = words[1]+","+words[2];
        wordCollection.put(words[0], pinyin_and_definition);
    }
}
