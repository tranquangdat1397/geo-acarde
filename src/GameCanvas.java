import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameCanvas extends JPanel {

//    BufferedImage backGround;
    BufferedImage backBuffered;
    Graphics graphics;
    Vector<BulletPlayers> bulletVector;
    Vector<SquareEnemy> squareVector;
    Vector<BulletSquareMedium> squareMediumBulletVector;

    public Vector2D positionPlayer = new Vector2D();

    SquareEnemy squareMediumEnemy;
//    BulletPlayers bulletPlayers;
    Players players;
    BackGround backGround;

    public GameCanvas(){
        this.setSize(400, 600);
        this.setVisible(true);
        setupBackground();
        setupPlayer();
        setupEnemy();
        setupBackBuffered();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }

    public void renderAll(){
        GameObject.renderAll(graphics);

        this.repaint();
    }

    public void setupBackBuffered(){
        //Cách vẽ nhiều hình lên canvas mà ko bị lag
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    public void setupBackground(){

        this.backGround = new BackGround();
        GameObject.add(backGround);
    }

    public void setupPlayer(){
        this.players = new Players();
        GameObject.add(players);
//        this.players = new Players(new Vector2D(),"asset-geoarcade-master/resources/player/straight.png");
    }
    public void setupEnemy(){
        GameObject.add(new NumberOfSquare());
    }
    public void runAll(){

        this.players.position.set(this.positionPlayer);
        GameObject.runAll();

//        if(this.count>=30) {
//            BulletPlayers bulletPlayers = new BulletPlayers(this.positionPlayer.clone(), "asset-geoarcade-master/resources/player/player_bullet_explosion.png",new Vector2D(0,3));
//            BulletPlayers bulletPlayers1 = new BulletPlayers(players.x-20,players.y-50,"asset-geoarcade-master/resources/player/player_bullet_explosion.png",5);
//            BulletPlayers bulletPlayers = new BulletPlayers();
//            bulletPlayers.position1.set(this.positionPlayer);
//            bulletPlayers.velocity.set(0.0f,3.0f);
//            this.bulletVector.add(bulletPlayers);
//            this.bulletPlayers.run();
//            this.count = 0;

//            Random random = new Random();
//            int randomSquare = random.nextInt(500);
//            SquareEnemy squareEnemy = new SquareEnemy(new Vector2D(randomSquare, this.positionSquareEnemyY),"asset-geoarcade-master/resources/square/enemy_square_small.png",new Vector2D(0,3));
//            this.squareVector.add(squareEnemy);

//            BulletSquareMedium bulletSquareMedium = new BulletSquareMedium(squareMediumEnemy.x+10,squareMediumEnemy.y,"asset-geoarcade-master/resources/square/enemy_square_bullet.png",5);
//            BulletSquareMedium bulletSquareMedium = new BulletSquareMedium(new Vector2D(this.positionSquareEnemyX,this.positionSquareEnemyY),"asset-geoarcade-master/resources/square/enemy_square_bullet.png",new Vector2D(0,3));
//            this.squareMediumBulletVector.add(bulletSquareMedium);
//        } else {
//            this.count += 2;
//        }

//        for (BulletSquareMedium bulletSquareMedium: this.squareMediumBulletVector) {
//            bulletSquareMedium.run();
//        }
//        for(BulletPlayers bulletPlayers: this.bulletVector){
//            bulletPlayers.run();
//        }

//        for (SquareEnemy squareEnemy: squareVector){
//            squareEnemy.run();
//        }
//        squareMediumEnemy.run();
    }
}
