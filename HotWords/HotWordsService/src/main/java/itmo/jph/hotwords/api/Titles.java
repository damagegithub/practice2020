package itmo.jph.hotwords.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titles {
    public List<String> getTitles(String pattern, int groupId, String webUrl) {
        //用于获取不同网页的titles
        WebsiteContent w = new WebsiteContent(webUrl);
        String content = w.getWebsiteContent();
        List<String> titles = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);

        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            titles.add(matcher.group(groupId));
        }
        return titles;
    }
}
