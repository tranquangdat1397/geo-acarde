import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayers extends GameObject{
    public Vector2D velocity;
    private int count=0;

    public BulletPlayers(){
        this.image = Utils.loadImage("asset-geoarcade-master/resources/player/player_bullet_explosion.png");
        this.velocity = new Vector2D();

    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }
}
