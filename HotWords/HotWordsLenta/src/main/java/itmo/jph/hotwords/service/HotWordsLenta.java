package itmo.jph.hotwords.service;

import itmo.jph.hotwords.api.*;

import java.util.List;

public class HotWordsLenta implements GetHotWordsService {
    public void getHotWords() {
        Titles t = new Titles();
        List<String> titles = t.getTitles("\"info\":(.*?)\"title\":\"(.*?)\"", 2, "https://api.lenta.ru/lists/latest");
        List<String> words = TopTenHotWords.getTopKHotWords(titles, 10);
        for (String word : words
        ) {
            System.out.println(word);
        }
    }

}
