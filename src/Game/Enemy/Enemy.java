package Game.Enemy;

import Core.GameObject;
import Core.Vector2D;
import physic.BoxCollider;
import Utils.Utils;
import physic.PhysicBody;


public class Enemy extends GameObject implements PhysicBody{
    public Vector2D velocity;
    private EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/square/enemy_square_medium.png");
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(40, 40);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.enemyShoot.run(this);
    }

    public void getHit() {
        this.isLive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
