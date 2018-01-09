import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletSquareMedium {
    public Vector2D position;
    public BufferedImage image;
    public Vector2D velocity;

    public BulletSquareMedium(Vector2D position, String url, Vector2D velocity){
        this.position=position;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.velocity = velocity;

    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y,null);
    }
}
