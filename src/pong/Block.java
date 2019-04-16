package pong;
import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {
        xPos = 100;
        yPos = 150;
        width = 10;
        height = 10;
        color = Color.black;
    }
    public Block(int x, int y, int w, int h) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = Color.black;
    }
    public Block(int x, int y, int w, int h, Color col) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = col;
    }
    public Block(int x, int y) {
        xPos = x;
        yPos = y;
        
    }
    public void setPos(int x, int y){
        xPos = x;
        yPos = y;
    }
    public void setX(int x){
        xPos = x;
    }
    public void setY(int y){
        yPos = y;
    }
    public void setWidth(int w){
        width = w;
    }
    public void setHeight(int h){
        height = h;
    }
    public void setColor(Color col) {
       color = col;
    }
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Color getColor(){
        return color;
    }

    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());   
    }

    public boolean equals(Object obj) {
         Block bloc = (Block) obj;
        return (xPos == bloc.getX() && yPos == bloc.getY() && height == bloc.getHeight() && width == bloc.getWidth() && color == bloc.getColor());
    }

    public String toString(){
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " ";
    }
}
