package src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextParser {
    List<String> textFile;

    public TextParser(List<String> textFile) {
        this.textFile = textFile;
    }

    public Map<String, Map<String, Integer>> createWordMap() {
        Map<String, Map<String, Integer>> wordMap = new HashMap<>();

        for (String cleanedLine : this.textFile) {
            String[] textInArray = cleanedLine.split(" ");
            for (int i = 0; i < textInArray.length - 1; i++) {
                String curr = textInArray[i];
                String next = textInArray[i+1];
                if (!wordMap.containsKey(curr)) {
                    wordMap.put(curr, new HashMap<>());
                }
                wordMap.put(curr, incrementCount(wordMap.get(curr), next));
            }
        }
        return wordMap;
    }

    private Map<String, Integer> incrementCount(Map<String, Integer> hashMap, String word) {
        if (hashMap.containsKey(word)) {
            hashMap.put(word, hashMap.get(word) + 1);
        } else {
            hashMap.put(word, 1);
        }
        return hashMap;
    }


}
