package Game.Square;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;

import java.util.Random;

public class NumberOfSquare extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
//    public Vector2D velocity;

    public NumberOfSquare(){
        this.random = new Random();
        this.frameCounter = new FrameCounter(40);
//        this.velocity = new Vector2D();
    }

    public void run(){
        if(this.frameCounter.run()){
            SquareEnemy squareEnemy = new SquareEnemy();
            squareEnemy.position.set(random.nextInt(400),0);
            squareEnemy.velocity.set(0,random.nextInt(2)+2);
            GameObject.add(squareEnemy);
            this.frameCounter.reset();
        }
    }
}
