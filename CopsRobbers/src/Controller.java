import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
    	view.repaint();
    	
		if (SwingUtilities.isLeftMouseButton(e)) {
			model.addS(e.getX(), e.getY());
		}
    }
    
    public void keyTyped(KeyEvent k) {
    	if (k.getKeyChar() == 'n') {
    		model.print();
    	}
    	else if (k.getKeyChar() == 'h') {
    		System.out.println("hello world");
    	}
    	else if (k.getKeyChar() == 'r') {
    		model.initialize();
    		view.repaint();
    		RobberCar.resetStats();
    	}
    	else if (k.getKeyChar() == 's') {
    		new Thread(new SpriteMover(this)).start();
    	}	
    }
    
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    public void keyPressed(KeyEvent k) {    }
    public void keyReleased(KeyEvent k) {    }

    public static void main(String[] args) throws Exception {
        new Controller();
    }
}