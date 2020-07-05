package itmo.jph.hotwords.service;

import itmo.jph.hotwords.api.*;

import java.util.List;
public class HotWordsFontanka implements GetHotWordsService {
    public void getHotWords() {
        Titles t = new TitlesImpl();
        List<String> titles=t.getTitles("<title><!\\[CDATA\\[(.*?)\\]\\]></title>",1,"https://aif.ru/rss/news.php");
        List<String> words=TopTenHotWords.getTopKHotWords(titles,10);
        for (String word:words
        ) {
            System.out.println(word);
        }
    }
}