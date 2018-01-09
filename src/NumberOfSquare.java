import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class NumberOfSquare extends GameObject{
    private int count=0;
    private Random random;

    public NumberOfSquare(){
        this.random = new Random();
    }

    public void run(){
        if(this.count >=20){
            SquareEnemy squareEnemy = new SquareEnemy();
            squareEnemy.position.set(random.nextInt(400),0.0f);
            squareEnemy.velocity.set(0.0f,random.nextInt(4)+3);
            GameObject.add(squareEnemy);
            count=0;
        }
        else {
            count+=1;
        }
    }
}
