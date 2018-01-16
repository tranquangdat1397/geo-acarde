package Game.Player.Bullet;

import Core.GameObject;
import Game.Square.SquareEnemy;

public class HitSquare {
    public void run(BulletPlayers bulletPlayers){
        SquareEnemy squareEnemy = GameObject.checkCollider(bulletPlayers.boxCollider, SquareEnemy.class);
        if(squareEnemy != null){
            bulletPlayers.getHit();
            squareEnemy.getHit();
        }
    }
}
