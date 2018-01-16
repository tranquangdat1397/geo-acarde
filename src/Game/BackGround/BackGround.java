package Game.BackGround;

import Core.GameObject;
import Utils.Utils;

import java.awt.*;

public class BackGround extends GameObject {

    public BackGround(){
        this.image = Utils.loadImage("asset-geoarcade-master/resources/background/background.png");
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);

    }
}
