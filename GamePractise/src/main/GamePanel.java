package main;

import inputs.MouseInputs;
import inputs.keyboardInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private float xDelta=100,yDelta=100;
    private MouseInputs mouseInputs;
    private int frames = 0;
    private long lastCheck = 0;
    private float xDir = 0.2f,yDir = 0.2f;
    private Random random;
    private Color color = new Color(150,20,90);
    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new keyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
public void changeXdelta(int value){
this.xDelta+=value;
}
public void changeYdelta(int value){
this.yDelta+=value;
}
public void setRectPos(int x,int y){
this.xDelta = x;
this.yDelta = y;
}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta,(int)yDelta,200,50);
        frames++;
                if(System.currentTimeMillis() - lastCheck >= 1000){
                    lastCheck = System.currentTimeMillis();
                    System.out.println("FPS: "+frames);
                    frames=0;
                }
//        repaint();
    }
    private void updateRectangle(){
        xDelta+=xDir;
        if(xDelta>400 || xDelta<0){
            xDir*= -1;
            color=getRndColor();
        }
        yDelta+=yDir;
        if(yDelta>400 || yDelta<0){
            yDir*= -1;
            color=getRndColor();
        }
    }
    private Color getRndColor(){
        int r= random.nextInt(255);
        int g= random.nextInt(255);
        int b= random.nextInt(255);
        return new Color(r,g,b);
    }
}
