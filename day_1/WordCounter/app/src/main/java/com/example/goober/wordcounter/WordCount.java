package com.example.goober.wordcounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static android.R.attr.name;

/**
 * Created by goober on 06/11/2017.
 */

public class WordCount {

    private String inputText;

    public WordCount(String text) {
        this.inputText = text;
    }

    public String hasGotString(){
        return this.inputText;
    }

    public String countWords(){
        String[] wordBreak = inputText.split("\\s+");
        return Integer.toString(wordBreak.length);


    }

    public Map mapIndividualWords(){
        String[] wordBreak = inputText.split("\\s+");
        Map<String, Integer> wordMap = new HashMap<>(wordBreak.length);
        for (String word : wordBreak) {
            Integer count = wordMap.get(word);
            if (count == null) {
                count = 0;
            }
            wordMap.put(word, count + 1);
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > 1) {
                count += entry.getValue();
            }
        }
        return wordMap;
    }

    public String finalAnswer(Map wordMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("The word count is....  ");

        Set<Map.Entry<String, Integer>> words = wordMap.entrySet();
        for (Map.Entry<String, Integer> entry : words) {

            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue().toString() + ", ");
        }
        return sb.toString();
    }

}
