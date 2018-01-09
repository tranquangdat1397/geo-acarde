public class BulletSquare extends GameObject{
    public Vector2D velocity;
    public BulletSquare() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/square/enemy_square_bullet.png");
        this.velocity=new Vector2D();
    }

    @Override
    public void run() {
        this.position.addUp(this.velocity);
    }
}
