package Game.Player.Bullet;

import Core.GameObject;
import Game.Enemy.BulletEnemy;
import Game.Enemy.Enemy;

public class HitEnemy {
    public void run(BulletPlayers bulletPlayers) {
        Enemy enemy = GameObject.checkCollider(bulletPlayers.boxCollider, Enemy.class);
        if(enemy != null){
            bulletPlayers.getHit();
            enemy.getHit();
        }
    }
}
