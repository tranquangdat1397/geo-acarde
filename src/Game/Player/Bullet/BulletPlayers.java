package Game.Player.Bullet;

import Core.GameObject;
import Core.Vector2D;
import Utils.Utils;
import physic.BoxCollider;
import physic.PhysicBody;

public class BulletPlayers extends GameObject implements PhysicBody{
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;
    private HitEnemy hitEnemy;

    public BulletPlayers(){
        this.image = Utils.loadImage("asset-geoarcade-master/resources/player/player_bullet_explosion.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.hitSquare = new HitSquare();
        this.hitEnemy = new HitEnemy();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitSquare.run(this);
        this.hitEnemy.run(this);
    }

    public void getHit() {
        this.isLive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
