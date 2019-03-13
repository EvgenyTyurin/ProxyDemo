import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Javafx controller
 */

public class Controller {
    @FXML
    private ImageView img;
    @FXML
    private TextField url;

    @FXML
    private void click() {

        // Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.xxx.com", 8080));
        Proxy proxy = null;
        BufferedImage image =
                ImageLoaderProxy.loadImage(url.getText(), proxy);
        if (image != null) {
            img.setImage(SwingFXUtils.toFXImage(image, null));
        }
    }
}
