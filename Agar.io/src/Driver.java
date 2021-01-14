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
	Player player = new Player();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Food> foods = new ArrayList<Food>();
	Rectangle world = new Rectangle(-1000, -1000, 3000, 3000); //x ,y w, h 
	
	
	public void paint(Graphics g) {
		super.paintComponent(g); //proper redrawing of the entire screen
	
		//call each Enemy to paint themselves
		for(Food a: foods) {
			a.paint(g);
			for(Enemy b: enemies) {
				if(a.collides(b)) {
					a.massToRad(b);
					a.setRad(0);
				}
			}
		}
		//eating the food / enemies messes up the total mass
		for (Enemy e: enemies) {
            e.paint(g);
            for (Enemy f: enemies) {
                if (f.collides(e)) {
                    if (f.getMass() > e.getMass()) {
                    	e.massToRad(f);
                        e.setRad(0);
                    } else if (e.getMass() > f.getMass()) {
                    	f.massToRad(e);
                        f.setRad(0);
                    }
                }
            }
            
        }
		
		//player cell
		player.paint(g);
	}

	public Driver(){
		JFrame frame = new JFrame("Agar.io");
		frame.setSize(1000,1000);
		frame.add(this);
		
		
		//Foods
		for(int i=0; i<1000; i++) {
			foods.add(new Food());
			
		}
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
