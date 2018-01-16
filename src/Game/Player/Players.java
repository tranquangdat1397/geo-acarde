package Game.Player;

import Core.GameObject;
import Utils.Utils;

public class Players extends GameObject {
    private PlayerShoot playerShoot;

    public Players() {
        this.image = Utils.loadImage("asset-geoarcade-master/resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
    }
}
