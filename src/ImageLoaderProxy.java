import thirdparty.ImageLoader;

import java.awt.image.BufferedImage;
import java.net.Proxy;
import java.util.HashMap;

/**
 * Proxy class
 */

class ImageLoaderProxy {
    private static HashMap<String, BufferedImage> images = new HashMap<>();

    static BufferedImage loadImage(String url, Proxy proxy) {
        BufferedImage image = images.get(url);
        if (image == null) {
            System.out.println("Using third party class");
            image  = ImageLoader.loadImage(url, proxy);
            images.put(url, image);
        }
        return image;
    }
}
