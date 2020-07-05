package itmo.jph.hotwords.api;

import java.util.List;

public interface Titles {
    public List<String> getTitles(String pattern, int group, String webUrl);
}
