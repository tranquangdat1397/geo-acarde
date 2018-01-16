package Game.Player;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;
import Game.Player.Bullet.BulletPlayers;

public class PlayerShoot {
    private FrameCounter frameCounter = new FrameCounter(30);

    public void run(Players players) {
        if(this.frameCounter.run()) {
            BulletPlayers bulletPlayers = new BulletPlayers();
            bulletPlayers.position.set(players.position);
            bulletPlayers.velocity.set(new Vector2D(0.0f,5.0f)) ;
            GameObject.add(bulletPlayers);
            this.frameCounter.reset();
        }
    }
}
