package me.erase.ytmp3.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class WebUtil {
    private WebUtil() {
        throw new UnsupportedOperationException("Utility classes can not be instantiated");
    }

    public static String getDirectDownload(String link) throws IOException {
        URL url = new URL(link);
        URLConnection connection = url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder bodyBuilder = new StringBuilder(); // too stronk

            while ((line = reader.readLine()) != null) {
                bodyBuilder.append(line);
            }

            String[] splitBody = bodyBuilder.toString().split("\""),
                    splitLink = link.split("/");
            String id = "/" + splitLink[splitLink.length - 1];

            for (String content : splitBody) {
                if (content.contains(id)) {
                    return content;
                }
            }
        }

        return link;
    }
}
