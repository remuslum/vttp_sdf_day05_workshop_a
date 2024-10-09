import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import src.FileManager;
import src.LanguageModel;
import src.TextParser;

public class Main {
    public static void main(String[] args) throws IOException{
        String fileName = args[0];
        List<String> stopwords = Files.readAllLines(Paths.get("data/stopwords.txt"), StandardCharsets.UTF_8);
        Console console = System.console(); 

        // Load text file 
        FileManager fileManager = new FileManager(fileName);
        List<String> cleanedText = fileManager.loadTextFile();
        fileManager.cleanStopWords(cleanedText, stopwords);
                
        
        TextParser textParser = new TextParser(cleanedText);
        Map<String, Map<String, Integer>> wordMap = textParser.createWordMap();

        String keyboardInput = "";
        while (!keyboardInput.equals("exit")) {
            keyboardInput = console.readLine("Word: ");
            LanguageModel lm = new LanguageModel(wordMap);
            System.out.println(lm.produceNextFiveWords(keyboardInput));
        }

    } 
}