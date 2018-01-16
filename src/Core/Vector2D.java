package Core;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this.x=0.0f;
        this.y=0.0f;
    }

    public Vector2D set(float x, float y){
        this.x=x;
        this.y=y;
        return this;
    }

    public Vector2D set(Vector2D vector2D){
        return this.set(vector2D.x,vector2D.y);
    }

    public Vector2D addUp(float x, float y){
        this.x+=x;
        this.y+=y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D){
        return this.addUp(vector2D.x,vector2D.y);
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x+x,this.y+y);
    }

    public Vector2D add(Vector2D vector2D){
        return this.add(vector2D.x,vector2D.y);
    }

    public Vector2D subtractBy(float x, float y){
        this.x-=x;
        this.y-=y;
        return this;
    }

    public  Vector2D subtractBy(Vector2D vector2D){
        return this.subtractBy(vector2D.x,vector2D.y);
    }

    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x-x, this.y-y);
    }

    public Vector2D subtract(Vector2D vector2D){
        return this.add(vector2D.x,vector2D.y);
    }

    public float length(float x, float y){
        return (float)Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    public Vector2D clone(){
        return new Vector2D(this.x,this.y);
    }

    public Vector2D multiply(float number){
        this.x+=number;
        this.y+=number;
        return this;
    }

    public Vector2D normalize(){
        return new Vector2D((float) (this.x / length(this.x, this.y)), (float) (this.y / length(this.x, this.y)));
    }

    public Vector2D rotate(double angle){
        double cos = Math.cos(Math.toRadians(angle));
        double sin = Math.sin(Math.toRadians(angle));
        return new Vector2D((float)(this.x*cos-this.y*sin),(float)(this.x*sin-this.y*cos));
    }

}
