import Core.GameObject;
import Core.Vector2D;
import Game.BackGround.BackGround;
import Game.CircleSquare;
import Game.Enemy.EnemySqawner;
import Game.Square.MatrixSquare;
import Game.Square.NumberOfSquare;
import Game.Player.Players;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

//    BufferedImage backGround;
    BufferedImage backBuffered;
    Graphics graphics;

    public Vector2D positionPlayer = new Vector2D();

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

    }
    public void setupEnemy(){

        GameObject.add(new NumberOfSquare());
        GameObject.add(new EnemySqawner());
        GameObject.add(new CircleSquare());
        GameObject.add(new MatrixSquare());
    }
    public void runAll(){

        this.players.position.set(this.positionPlayer);
        GameObject.runAll();

    }
}
