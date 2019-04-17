package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable {

    private Ball ball;

    public BallTestTwo() {
        setBackground(Color.WHITE);
        setVisible(true);
         ball = new Ball(10,10, 20, 20, Color.black, 2, 5);
		//test the Ball thoroughly
		//test all constructors
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);

        if (!(ball.getX() >= 10 && ball.getX() <= (800 - ball.getWidth()))) {
            ball.setXs(-ball.getXs());
        }

        if (!(ball.getY() >= 10 && ball.getY() <= (600 - ball.getHeight()))) {
            ball.setYs(-ball.getYs());
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(19);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
