package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private int rightScore;
    private int leftScore;
    private boolean[] keys;
    private BufferedImage back;

    public Pong() {
        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        //ball = new Ball(100, 75, 10, 10, Color.blue, (int) (((Math.random()+0.5) * 5)), (int) ((Math.random()+.5) * 5));
        ball = new Ball(100, 75, 10, 10, Color.blue, 3,2);
        leftPaddle = new Paddle(10, 300, 20, 60, Color.black, 2);
        rightPaddle = new Paddle(750, 300, 20, 60, Color.black, 2);
        rightScore = 0;
        leftScore = 0;
        new Thread(this).start();
        addKeyListener(this);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {

        Graphics2D twoDGraph = (Graphics2D) window;
        
        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
         graphToBack.setColor(Color.white);
         graphToBack.fillRect(0, 0, 800, 600);
        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        //see if ball hits left wall or right wall
         if(ball.getX() <= 0){
             ball.setXs(0);
             ball.setYs(0);
             ball.setX((int)(getWidth()/2));
             ball.setY((int)(getHeight()/2));
             ball.randSpeed();
             rightScore++;
         }
         if(ball.getX()+ ball.getWidth() >= getWidth()){
             ball.setXs(0);
             ball.setYs(0);
             ball.setX((int)(getWidth()/2));
             ball.setY((int)(getHeight()/2));
             ball.randSpeed();
             leftScore++;
         }
        //see if the ball hits the top or bottom wall
        if (ball.getY() <= 0 || ball.getY() >= getHeight()-ball.getHeight()) {
            ball.setYs(-ball.getYs());
        }
        if ((ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() && ball.getX() + ball.getWidth() >= leftPaddle.getX()) && (ball.getY() + ball.getHeight() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight())) {
            ball.setXs(-ball.getXs());
            ball.setYs(-ball.getYs());
        }
        if ((ball.getX()+ball.getWidth() >= rightPaddle.getX() && ball.getX() <= rightPaddle.getX() + rightPaddle.getWidth()) && (ball.getY()+ball.getHeight() >= rightPaddle.getY() && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight())) {
            ball.setXs(-ball.getXs());
            ball.setYs(-ball.getYs());
        }
        
        if (keys[0] && leftPaddle.getY() > 0) {
            leftPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[1] && leftPaddle.getY() < getHeight()-leftPaddle.getHeight()) {
            leftPaddle.moveDownAndDraw(graphToBack);
        }
        if (keys[2] && rightPaddle.getY() > 0) {
            rightPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[3] && rightPaddle.getY() < getHeight()-rightPaddle.getHeight()) {
            rightPaddle.moveDownAndDraw(graphToBack);
        }
        Font font = new Font("Arial", Font.PLAIN, 56);
        graphToBack.setFont(font);
        graphToBack.drawString("" + leftScore, 100, 100);
        graphToBack.drawString("" + rightScore, getWidth()-200, 100);
        twoDGraph.drawImage(back, null, 0, 0);
        
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'S':
                keys[1] = true;
                break;
            case 'E':
                keys[2] = true;
                break;
            case 'D':
                keys[3] = true;
                break;
        }
    }
    

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'S':
                keys[1] = false;
                break;
            case 'E':
                keys[2] = false;
                break;
            case 'D':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
