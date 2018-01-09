import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Players extends GameObject{
    public Vector2D velocity;
    private int count=0;

    public Players() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/player/straight.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if(this.count==15) {
            BulletPlayers bulletPlayers = new BulletPlayers();
            bulletPlayers.position.set(this.position);
            bulletPlayers.velocity.set(new Vector2D(0.0f,5.0f)) ;
            GameObject.add(bulletPlayers);
            this.count=0;
        }
        else {
            count+=1;
        }
    }
}
