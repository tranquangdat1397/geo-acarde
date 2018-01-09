public class SquareEnemy extends GameObject{
    public Vector2D velocity;
    private int count=0;

    public SquareEnemy() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/square/enemy_square_small.png");
        this.velocity=new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        if(count==30){
            BulletSquare bulletSquare = new BulletSquare();
            bulletSquare.position.set(this.position);
            bulletSquare.velocity.set(new Vector2D(0.0f,7.0f));
            GameObject.add(bulletSquare);
            this.count=0;
        }
        else {
            count+=1;
        }
    }
}
