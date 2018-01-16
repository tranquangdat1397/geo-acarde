package Game.Square;

import Core.GameObject;
import Core.Vector2D;
import Utils.Utils;
import physic.BoxCollider;
import physic.PhysicBody;

public class SquareEnemy extends GameObject implements PhysicBody{
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public SquareEnemy() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);

    }

    public void getHit() {
        this.isLive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
