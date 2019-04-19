package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {

    //instance variables
    private int speed;

    public Paddle() {
        super(10, 10, 10, 10, Color.white);
        speed = 5;
    }

    public Paddle(int x, int y, int w, int h, Color col, int speed) {
        super(x, y, w, h, col);
        this.speed = speed;
    }

    public Paddle(int x, int y, int w, int h, int speed) {
        super(x, y, w, h, Color.white);
        this.speed = speed;
    }

    public Paddle(int x, int y) {
        super(x, y, 10, 10, Color.white);
        speed = 5;
    }

    public Paddle(int x, int y, int w) {
        super(x, y, 10, 10, Color.white);
        speed = w;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public void moveUpAndDraw(Graphics window) {
        window.setColor(Color.white);
        window.fillRect(super.getX(), super.getY(), super.getWidth(),super.getHeight());
        
         setY(getY() - speed);
         
         window.setColor(super.getColor());
         window.fillRect(super.getX(), super.getY(), super.getWidth(),super.getHeight());
        
    }

    public void moveDownAndDraw(Graphics window) {
        window.setColor(Color.white);
        window.fillRect(super.getX(), super.getY(), super.getWidth(),super.getHeight());
        
         setY(getY() + speed);
         
         window.setColor(super.getColor());
         window.fillRect(super.getX(), super.getY(), super.getWidth(),super.getHeight());
    }
    public String toString(){
        return super.toString() + " " + getSpeed();
    }
}
