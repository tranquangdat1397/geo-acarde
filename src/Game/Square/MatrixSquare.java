package Game.Square;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;
import Game.Enemy.Enemy;

import java.util.Vector;

public class MatrixSquare extends GameObject{
    Vector2D velocity;
    Vector<SquareEnemy> squareEnemies;
    FrameCounter frameCounter;
    String[][] matrixSquare = {
            {"A", " ", " ", " "},
            {" ", "A", " ", " "},
            {" ", " ", "A", " "},
            {" ", " ", " ", "A"},
    };
    float vX=3.0f;

    public MatrixSquare() {
        squareEnemies = new Vector<>();
        this.velocity = new Vector2D(vX,0.0f);
        frameCounter = new FrameCounter(10);

        for(int width=0; width<matrixSquare.length; width++) {
            for (int height = 0; height < matrixSquare.length; height++) {
                if (matrixSquare[width][height].equalsIgnoreCase("A")) {
                    SquareEnemy squareEnemy = new SquareEnemy();
                    squareEnemy.position.set(width * 40 + 10, height * 40 + 10.0f);
                    squareEnemies.add(squareEnemy);
                    GameObject.add(squareEnemy);
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();
        for (SquareEnemy squareEnemy: squareEnemies) {
            if(squareEnemy.position.x<=0 || squareEnemy.position.x>=400) {
                this.velocity.x=0;
                this.velocity.y=2;
            }
        }
        for (SquareEnemy squareEnemy: squareEnemies) {
            squareEnemy.velocity.set(this.velocity);
        }
    }
}
