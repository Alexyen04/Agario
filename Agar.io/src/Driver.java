import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements MouseListener, ActionListener{
	
	//Create ArrayList for enemies
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	Rectangle world = new Rectangle(-1000, -1000, 3000, 3000); //x ,y w, h 
	
	
	public void paint(Graphics g) {
		super.paintComponent(g); //proper redrawing of the entire screen
		
		//player cell
	
		
		//call each Enemy to paint themselves
		for (Enemy e: enemies) {
            e.paint(g);
            for (Enemy f: enemies) {
                if (f.collides(e)) {
                    if (f.getMass() > e.getMass()) {
                        e.setRad(0);
                    } else if (e.getMass() > f.getMass()) {
                        f.setRad(0);
                    }
                }
            }
        }
		
	}

	public Driver(){
		JFrame frame = new JFrame("Agar.io");
		frame.setSize(800,800);
		frame.add(this);
		
		/* add 50  Enemies */
		for(int i =0 ; i < 50; i++) {
			enemies.add( new Enemy() );
		}	
		
		Timer t = new Timer(16, this); //chose swing library for import
		t.start();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	
	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("here");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint(); //time will invoke this method which then refreshes the screen
					//for the "animation"
	}
}
