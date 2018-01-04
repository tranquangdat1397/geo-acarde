import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayers {
    public int x;
    public int y;
    public BufferedImage image;
    public int speed;

    public BulletPlayers(int x, int y, String url, int speed){
        this.x = x;
        this.y = y;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.speed = speed;

    }

    public void run() {
        this.y-=this.speed;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y,null);
    }
}
