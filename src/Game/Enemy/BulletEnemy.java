package Game.Enemy;

import Core.GameObject;
import Core.Vector2D;
import Utils.Utils;

public class BulletEnemy extends GameObject{
    public Vector2D velocity;

    public BulletEnemy() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/square/enemy_square_bullet.png");
        this.velocity=new Vector2D();
    }

    @Override
    public void run() {
        this.position.addUp(this.velocity);
    }
}
