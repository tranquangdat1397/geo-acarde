package physic;

import Core.Vector2D;

import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    private float width;
    private float height;

    public BoxCollider(float width, float height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2D();
    }

    public boolean checkBoxCollider(BoxCollider other) {
        Rectangle r1 = new Rectangle((int)this.position.x, (int)this.position.y,(int)this.width,(int)this.height);
        Rectangle r2 = new Rectangle((int)other.position.x,(int)other.position.y,(int)other.width,(int)other.height);
        return r1.intersects(r2);
        //        return other.position.x + other.width >= this.position.x
//                && other.position.x - this.width <= this.position.x
//                && other.position.y + other.height >= this.position.y
//                && other.position.x - this.height <= this.position.y;
    }
}
