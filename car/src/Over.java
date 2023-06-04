import javax.swing.*;
import java.awt.*;

public class Over {
    JFrame frame = new JFrame("2D Car Game");
    JLabel text = new JLabel("GameOver");
    JButton button = new JButton("Replay");

    public Over(int score){
        text.setForeground(Color.RED);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setBounds(0, 150, 360, 40);

        JLabel currentScore = new JLabel("Your score: "+score);
        currentScore.setForeground(Color.RED);
        currentScore.setFont(new Font("Arial", Font.BOLD, 40));
        currentScore.setHorizontalAlignment(SwingConstants.CENTER);
        currentScore.setVerticalAlignment(SwingConstants.CENTER);
        currentScore.setBounds(0, 190, 360, 40);

        button.setBounds(120, 240, 120, 30);
        button.setFocusable(false);
        button.addActionListener(e -> {
            Option obj = new Option();
            frame.setVisible(false);
            frame.dispose();
        });

        frame.setLayout(null);
        frame.add(currentScore);
        frame.add(text);
        frame.add(button);
        frame.setSize(360,545);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
