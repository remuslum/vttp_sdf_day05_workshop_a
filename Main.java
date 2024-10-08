import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("data/austen.txt"), StandardCharsets.UTF_8);
        List<String> cleanedList = new ArrayList<>();
        String sample = lines.get(9);
        sample = sample.replaceAll("[^\\w\\s.]", "");
        System.out.println(sample);

        for(String line:lines) {
            // Replace all full stops with a space
            cleanedList.add(line.replaceAll("[^\\w\\s.]", ""));
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(cleanedList.get(i));
        }
    }
}