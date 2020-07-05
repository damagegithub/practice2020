package itmo.jph.hotwords.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebsiteContent {
    URL url;

    public WebsiteContent(String webUrl) {
        try {
            this.url = new URL(webUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getWebsiteContent() {
        StringBuilder content = new StringBuilder();
        try {
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream input = httpUrlConn.getInputStream();
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            BufferedReader br = new BufferedReader(read);
            // 读取返回结果
            String data = br.readLine();
            while (data != null) {
                content.append(data);
                data = br.readLine();
            }
            br.close();
            read.close();
            input.close();
            httpUrlConn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
