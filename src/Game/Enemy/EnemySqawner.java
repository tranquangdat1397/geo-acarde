package Game.Enemy;

import Core.FrameCounter;
import Core.GameObject;

import java.util.Random;

public class EnemySqawner extends GameObject{
    private Random random;
    private FrameCounter frameCounter;

    public EnemySqawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        if(this.frameCounter.run()){
            Enemy enemy = new Enemy();
            enemy.position.set(random.nextInt(400),0);
            enemy.velocity.set(0,random.nextInt(2)+2);
            GameObject.add(enemy);
            this.frameCounter.reset();
        }
    }
}
