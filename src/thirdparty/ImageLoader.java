package thirdparty;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * This class can load images from Internet, but can't cache it so it will be proxied
 */

public class ImageLoader {

    public static BufferedImage loadImage(String url, Proxy proxy) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(getUrlBytes(url, proxy)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    private static byte[] getUrlBytes(String urlSpec, Proxy proxy) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection;
        if (proxy != null)
            connection = (HttpURLConnection) url.openConnection(proxy);
        else
            connection = (HttpURLConnection) url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " +
                        urlSpec);
            }
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

}
