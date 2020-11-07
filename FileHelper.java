import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHelper {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileHelper() {}

    public FileHelper(String fileName) {
        setFileName(fileName);
    }
    
    public ArrayList<String> readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(getFileName()));
        String sCurrentWord;
        ArrayList<String> dictionary = new ArrayList<>();
        while((sCurrentWord = br.readLine()) != null) {   
            dictionary.add(sCurrentWord);
        }
        br.close();
        return dictionary;
    }

    public void wirteTofile(String content) {
        try(FileWriter fw = new FileWriter(getFileName(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print("\n");
            out.print(content);
            
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
