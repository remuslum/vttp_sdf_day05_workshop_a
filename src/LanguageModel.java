package src;

import java.util.Map;

public class LanguageModel {
    private final Map<String, Map<String, Integer>> wordMap;

    public LanguageModel(Map<String, Map<String, Integer>> wordMap) {
        this.wordMap = wordMap;
    }

    public String produceNextFiveWords(String string) {
        String word = string;
        String sentence = string + "";
        int count = 0;
        if (this.wordMap.get(word) == null) {
            return "Word does not exist";
        } 
        while (count != 5) {
            String temp = findMostProbableWord(word);
            sentence += temp + " ";
            word = temp;
            count++;
        }
        return sentence;
    }

    private String findMostProbableWord(String word) {
        int count = 0;
        String temp = "";
        if (this.wordMap.get(word) == null) {
            return "Word not exist";
        }
        Map<String, Integer> map = this.wordMap.get(word);
        for (String key : map.keySet()) {
            if (map.get(key) > count) {
                count = map.get(key);
                temp = key;
            }
        }
        return temp;
    }

    

    
}
