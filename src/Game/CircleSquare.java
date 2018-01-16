package Game;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;
import Game.Enemy.Enemy;
import Game.Square.SquareEnemy;

import java.util.Vector;

public class CircleSquare extends GameObject{
    private FrameCounter frameCounter;
    Vector2D velocity;
    Vector<SquareEnemy> enemies;

    public CircleSquare() {
//        this.frameCounter = new FrameCounter(50);
        this.velocity = new Vector2D(2.0f, 3.0f);
        enemies = new Vector<>();
            for (double angle=0.0; angle<=360.0; angle+=360.0/15){
                SquareEnemy squareEnemy = new SquareEnemy();
                squareEnemy.position.set((new Vector2D(50.0f,1.0f)).rotate(angle)).addUp(60,60);
                enemies.add(squareEnemy);
                GameObject.add(squareEnemy);
            }
    }

    @Override
    public void run() {
        super.run();
//        if(this.frameCounter.run()){
//            for (double angle=0.0; angle<=360.0; angle+=360.0/15){
//                SquareEnemy squareEnemy = new SquareEnemy();
//                squareEnemy.position.set((new Vector2D(50.0f,0.0f)).rotate(angle)).addUp(60,60);
//                GameObject.add(squareEnemy);
//            }
//        }

        for (SquareEnemy squareEnemy: enemies) {
            if(squareEnemy.position.y<=0 || squareEnemy.position.y>=600){
                this.velocity.y = -this.velocity.y;
            }

            if(squareEnemy.position.x<=0 || squareEnemy.position.x>=400){
                this.velocity.x = -this.velocity.x;
            }
        }

        for(SquareEnemy squareEnemy: enemies){
            squareEnemy.velocity.set(this.velocity);
        }
    }
}
