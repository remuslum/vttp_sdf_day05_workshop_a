package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public List<String> loadTextFile() throws IOException{
        FileReader fileReader = new FileReader(new File(this.fileName));
        BufferedReader br = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line = "";

        while ((line = br.readLine()) != null) {
            if (!line.isEmpty()) {
                lines.add(line.replaceAll("[\\p{Punct}]+", "").toLowerCase().trim());
            } 
        }
        br.close();
        return lines;
    }

    public void cleanStopWords(List<String> listOfWords, List<String> stopwords) {
        for (int i = 0; i < listOfWords.size(); i++) {
            String[] textInArray = listOfWords.get(i).split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : textInArray) {
                if (!stopwords.contains(word)) {
                    stringBuilder.append(word);
                    stringBuilder.append(" ");
                } 
            }
            listOfWords.set(i, stringBuilder.toString().trim());
        }
    }
}
