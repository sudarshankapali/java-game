import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CarGameGUI {
    boolean isGameOver = false;
    JFrame fr = new JFrame("2D Car Game");
    JPanel carPanel = new JPanel();
    JLabel coin = new JLabel();
    CarHandler hnd = new CarHandler(this);
    int speed;
    int width;
    int height;
    int score = 0;
    Timer coinTimer;
    CarGameGUI(){
           speed = 20;
           width= 360;
           height = 545;
        initGUI();
    }
    public void initGUI(){

        carPanel.setOpaque(false);
        carPanel.setSize(60,130);
        fr.setLayout(null);

        //adding car image, obstacle car image and creating a label
        JLabel car = new JLabel(new ImageIcon(new ImageIcon("car.png").getImage().getScaledInstance(60, 130, Image.SCALE_DEFAULT)));
        JLabel obstacle = new JLabel(new ImageIcon(new ImageIcon("carr.png").getImage().getScaledInstance(60, 130, Image.SCALE_DEFAULT)));
        JLabel background = new JLabel("", new ImageIcon("back.gif"),JLabel.CENTER);
        fr.add(background);
        background.setBounds(0,0,width,height);
        carPanel.add(car);
        carPanel.setLocation(220,350);

//       set background color
        Color carBg = Color.decode("#414141");
        carPanel.setBackground(carBg);
        background.add(carPanel);

        // set up coin
        coin.setSize(30, 30);
        coin.setBackground(Color.YELLOW);
        coin.setOpaque(true);
        coin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        coin.setLocation((int) (Math.random() * (width - coin.getWidth())),50);
        background.add(coin);
        obstacle.setSize(60, 130);
        obstacle.setLocation((int) (Math.random() * (width - obstacle.getWidth())), 0 - obstacle.getHeight());
        background.add(obstacle);

        // set up timer to generate coin and obstacle
        coinTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int coinY = rand.nextInt(400) + 50;
                int obstacleX = rand.nextInt(width - obstacle.getWidth());
                int obstacleY = 0 - obstacle.getHeight();
                int obstacleVelY = 1;
                coin.setLocation((int) (Math.random() * (width - coin.getWidth())), coinY);
                obstacle.setLocation(obstacleX, obstacleY);
                coin.setVisible(true);
                obstacle.setVisible(true);

                //setup timer to move obstacle down
                Timer obstacleTimer  = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        obstacle.setLocation(obstacle.getX(), obstacle.getY() + obstacleVelY);

                        //check for collision between car and obstacle
                        Rectangle obstacleBounds = obstacle.getBounds();
                        if(carPanel.getBounds().intersects(obstacleBounds)){
                            isGameOver = true;
                            if(isGameOver = true){
                                Over over = new Over(score);
                                fr.setVisible(false);
                                fr.dispose();
                            }
                            //stop coin timer and obstacle timer;
                            coinTimer.stop();
                            ((Timer) e.getSource()).stop();

                            //check if obstacle has reached the bottom of the window
                            if(obstacle.getY()>=height){
                                obstacle.setVisible(false);
                            }
                        }
                    }
                });
                obstacleTimer.start();
            }
        });
        coinTimer.start();

        // add collision detection for coin and car
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setBounds(10, 0, 100, 20);
        background.add(scoreLabel);

        Timer collisionTimer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle carBounds = carPanel.getBounds();
                Rectangle coinBounds = coin.getBounds();
                if (carBounds.intersects(coinBounds)) {
                    score++;
                    scoreLabel.setText("Score: " + score); // update score label
//                    System.out.println("Score: " + score);
                    coin.setVisible(false);
                    coin.setLocation(-100, -100); // set coin location offscreen
                }
            }
        });
        collisionTimer.start();

        fr.setSize(width,height);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(hnd);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
