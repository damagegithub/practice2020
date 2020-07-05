package itmo.jph.hotwords.api;

import java.util.*;

public class TopTenHotWords {
    public static List<String> getTopKHotWords(List<String> titles, int k) {

        //使用map构建单词和出现次数
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < titles.size(); i++) {
            String[] words = titles.get(i).split(" ");
            for (int j = 0; j < words.length; j++) {
                //如果存在就加一，不存在就新put进map
                if (m.containsKey(words[j])) {
                    m.put(words[j], 1 + m.get(words[j]));
                } else {
                    m.put(words[j], 1);
                }
            }
        }
        //对map的value排序
        return topTenByValue(m, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //从大到小
                return Integer.compare(o2, o1);
            }
        });
    }

    public static <K, V> List<String> topTenByValue(Map<K, V> map,
                                                    final Comparator<V> valueComparator) {
        List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
                map.entrySet());

        List<String> hotWords = new ArrayList<>();
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return valueComparator.compare(o1.getValue(), o2.getValue());
            }
        });
        int i = 0;
        for (Map.Entry<K, V> entry : list) {
            //排除前置词
            if (Objects.equals(entry.getKey().toString(), "В")
                    || Objects.equals(entry.getKey().toString(), "в")
                    || Objects.equals(entry.getKey().toString(), "на")
                    || Objects.equals(entry.getKey().toString(), "не")
                    || Objects.equals(entry.getKey().toString(), "и")
                    || Objects.equals(entry.getKey().toString(), "за")
                    || Objects.equals(entry.getKey().toString(), "по")
                    || Objects.equals(entry.getKey().toString(), "а")
                    || Objects.equals(entry.getKey().toString(), "к")
                    || Objects.equals(entry.getKey().toString(), "с")
                    || Objects.equals(entry.getKey().toString(), "о")
                    || Objects.equals(entry.getKey().toString(), "от")
                    || Objects.equals(entry.getKey().toString(), "из")
                    || Objects.equals(entry.getKey().toString(), "после")
                    || Objects.equals(entry.getKey().toString(), "для")) {
                continue;
            }
            hotWords.add((String) entry.getKey());
            if (++i >= 10) {
                break;
            }
        }
        return hotWords;
    }

}


