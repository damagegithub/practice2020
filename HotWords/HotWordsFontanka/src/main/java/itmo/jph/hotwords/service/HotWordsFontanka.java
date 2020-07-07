package itmo.jph.hotwords.service;

import itmo.jph.hotwords.api.*;

import java.util.List;
public class HotWordsFontanka implements GetHotWordsService {
    public void getHotWords() {
        Titles t = new Titles();
        List<String> titles=t.getTitles("<item>(.*?)<title>(.*?)</title>",2,"https://www.fontanka.ru/fontanka.rss");
        List<String> words=TopTenHotWords.getTopKHotWords(titles,10);
        for (String word:words
        ) {
            System.out.println(word);
        }
    }
}