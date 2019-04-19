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
        
        draw(window,Color.white);
        //window.setColor(Color.white);
        //window.fillOval(super.getX(), super.getY(), super.getWidth(),super.getHeight());
         setX(getX() + xSpeed);
         setY(getY() + ySpeed);		//setY
         
        //draw the ball at its new location
         draw(window);
//         window.setColor(super.getColor());
  //       window.fillOval(super.getX(), super.getY(), super.getWidth(),super.getHeight());
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
    public void randSpeed(){
         double speed1 = ((Math.random()*4)-2);
         double speed2 = ((Math.random()*4)-2);
         while(speed1 == 0){
             speed1 = ((Math.random()*4)-2);
         }
         
         while(speed2 == 0){
             speed2 = ((Math.random()*4)-2);
         }
         
         if(speed1 > 0){
             speed1 = Math.ceil(speed1);
         }
         else if(speed1 < 0){
            speed1 = Math.floor(speed1);
         
         }
         if(speed2 > 0){
             speed2 = Math.ceil(speed2);
         }
         else if(speed2 < 0){
            speed2 = Math.floor(speed2);
         }
         
         xSpeed = (int)speed1;
         ySpeed = (int)speed2;
    }
    //add a toString() method
    
    public String toString(){
        return super.toString() + " " + xSpeed + " " + ySpeed;
    }
    
}
