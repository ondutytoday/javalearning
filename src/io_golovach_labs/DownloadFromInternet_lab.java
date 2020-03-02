package io_golovach_labs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadFromInternet_lab {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        InputStream in = url.openStream();
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
        }
        in.close();

    }
}
