import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage backGround;
    BufferedImage backBuffered;
    Graphics graphics;
    Vector<BulletPlayers> bulletVector;
    Vector<SquareEnemy> squareVector;
    Vector<BulletSquareMedium> squareMediumBulletVector;

    SquareEnemy squareMediumEnemy;
    Players players;

    int count =0;

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
        this.graphics.drawImage(this.backGround,0,0,null);
        players.render(this.graphics);
        squareMediumEnemy.render(this.graphics);
       for(SquareEnemy squareEnemy: this.squareVector){
           squareEnemy.render(this.graphics);
       }

        for (BulletSquareMedium bulletsquareMedium: squareMediumBulletVector) {
            bulletsquareMedium.render(this.graphics);
        }

        for(BulletPlayers bulletPlayers: this.bulletVector){
            bulletPlayers.render(this.graphics);
        }

        this.repaint();
    }

    public void setupBackBuffered(){
        //Cách vẽ nhiều hình lên canvas mà ko bị lag
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    public void setupBackground(){

        try {
            this.backGround = ImageIO.read(new File("asset-geoarcade-master/resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupPlayer(){

        this.players = new Players(0,0,"asset-geoarcade-master/resources/player/straight.png");
        this.bulletVector = new Vector<>();
    }
    public void setupEnemy(){
        squareMediumEnemy = new SquareEnemy(50,0,"asset-geoarcade-master/resources/square/enemy_square_medium.png",1);
        this.squareMediumBulletVector = new Vector<>();
        this.squareVector = new Vector<>();
    }
    public void runAll(){
//        if(this.bulletPositionX<=0) speedX = Math.abs(speedX);
//        if(this.bulletPositionX>=360) speedX = -speedX;
//        if(this.bulletPositionY<=0) speedX = Math.abs(speedY);
//        if(this.bulletPositionY>=580) speedY = -speedY;
//        this.bulletPositionX += speedX;
//        this.bulletPositionY += speedY;

        if(this.count>=30) {
            BulletPlayers bulletPlayers = new BulletPlayers(players.x,players.y-50, "asset-geoarcade-master/resources/player/player_bullet_explosion.png",5);
            BulletPlayers bulletPlayers1 = new BulletPlayers(players.x-20,players.y-50,"asset-geoarcade-master/resources/player/player_bullet_explosion.png",5);
            this.bulletVector.add(bulletPlayers);
            this.bulletVector.add(bulletPlayers1);
            this.count = 0;

            Random random = new Random();
            int randomSquare = random.nextInt(500);
            SquareEnemy squareEnemy = new SquareEnemy(randomSquare,0,"asset-geoarcade-master/resources/square/enemy_square_small.png",3);
            this.squareVector.add(squareEnemy);

            BulletSquareMedium bulletSquareMediumquareMedium = new BulletSquareMedium(squareMediumEnemy.x+10,squareMediumEnemy.y,"asset-geoarcade-master/resources/square/enemy_square_bullet.png",5);
            this.squareMediumBulletVector.add(bulletSquareMediumquareMedium);
        } else {
            this.count += 2;
        }

        for (BulletSquareMedium bulletSquareMedium: this.squareMediumBulletVector) {
            bulletSquareMedium.run();
        }
        for(BulletPlayers bulletPlayers: this.bulletVector){
            bulletPlayers.run();
        }

        for (SquareEnemy squareEnemy: squareVector){
            squareEnemy.run();
        }
        squareMediumEnemy.run();
    }
}
