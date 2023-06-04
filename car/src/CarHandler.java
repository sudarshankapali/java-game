import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarHandler implements KeyListener {
    CarGameGUI g;

    public CarHandler(CarGameGUI ref){
        this.g = ref;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT){
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            if(x - g.speed >= 0){
                g.carPanel.setLocation(x - g.speed, y);
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            int width = g.fr.getWidth();
            int carwidth = g.carPanel.getWidth();
            if (x + g.speed + carwidth <= width){
                g.carPanel.setLocation(x + g.speed, y);
            }
        } else if (code == KeyEvent.VK_UP) {
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            if (y - g.speed >= 0) {
                g.carPanel.setLocation(x, y - g.speed);
            }
        } else if (code == KeyEvent.VK_DOWN) {
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            int height = g.fr.getHeight();
            int carheight = g.carPanel.getHeight();
            if (y + g.speed + carheight <= height) {
                g.carPanel.setLocation(x, y + g.speed);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
