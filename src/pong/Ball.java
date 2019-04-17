package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200, 10, 10 ,Color.black);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y) {
        super(x, y, 10, 10, Color.black);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y, int w, int h) {
        super(x, y,w,h, Color.black);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y,int w, int h, Color col) {
        super(x, y, w, h , col);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y,int w, int h, Color col, int xs, int ys) {
        super(x, y, w, h , col);
        xSpeed = ys;
        ySpeed = xs;
    }

    public void moveAndDraw(Graphics window) {
        window.setColor(Color.white);
        window.fillOval(super.getX(), super.getY(), super.getWidth(),super.getHeight());
         setX(getX() + xSpeed);
         setY(getY() + ySpeed);		//setY
         
        //draw the ball at its new location
         window.setColor(super.getColor());
         window.fillOval(super.getX(), super.getY(), super.getWidth(),super.getHeight());
    }

    public boolean equals(Object obj) {
        Ball temp = (Ball)obj;
        return super.equals(obj) && this.getXs() == temp.getXs() && this.getYs() == temp.getYs();
    }

   //add the get methods
    public int getXs(){
        return xSpeed;
    }
    
    public void setXs(int s){
        xSpeed = s;
    }
    
    
    public int getYs(){
        return ySpeed;
    }
    
    public void setYs(int s){
        ySpeed = s;
    }
    //add a toString() method
    
    public String toString(){
        return super.toString() + " " + xSpeed + " " + ySpeed;
    }
    
}
