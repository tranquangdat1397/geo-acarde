package Game.Enemy;

import Core.FrameCounter;
import Core.GameObject;

public class EnemyShoot extends GameObject{
    private FrameCounter frameCounter = new FrameCounter(30);

    public void run(Enemy enemy){
        if(this.frameCounter.run()){
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0,5);
            GameObject.add(bulletEnemy);
            this.frameCounter.reset();
        }
    }
}
