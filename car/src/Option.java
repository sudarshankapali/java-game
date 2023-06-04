import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option implements ActionListener {
    private JButton play = new JButton("Start");
    private JButton exit = new JButton("Exit");
    public JFrame frame = new JFrame("2D Car Game");
    ImageIcon imageIcon = new ImageIcon("background.jpg");
    Image image = imageIcon.getImage().getScaledInstance(360,545,Image.SCALE_SMOOTH);

    JLabel background = new JLabel(new ImageIcon(image));


    public Option(){

        play.setBounds(120,120,100,40);
        exit.setBounds(120,180,100,40);
        play.setFocusable(false);
        exit.setFocusable(false);
        play.addActionListener(this::actionPerformed);
        exit.addActionListener(this::actionPerformed);
        frame.add(background);
        background.setBounds(0,0,360,545);


        frame.setLayout(null);
        frame.add(play);
        frame.add(exit);

        frame.setSize(360,545);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play)
        {
            frame.setVisible(false);
            frame.dispose();
            CarGameGUI carGameGUI = new CarGameGUI();
        }
        if (e.getSource() == exit)
        {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }

    }
}
