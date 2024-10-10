import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import src.FileManager;
import src.LanguageModel;
import src.TextParser;

public class WordGeneratorMain {
    public static void main(String[] args) throws IOException{
        String dirPath = args[0];
        String fileName = args[1];
        List<String> stopwords = Files.readAllLines(Paths.get(dirPath + File.separator + "stopwords.txt"), StandardCharsets.UTF_8);
        Console console = System.console(); 

        // Load text file 
        FileManager fileManager = new FileManager(dirPath + File.separator + fileName);
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