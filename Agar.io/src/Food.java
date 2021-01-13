import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private int x, y;
	private int rad; 
	private Color c;
	private boolean alive;
	private int mass; 
	
	public Food () {
		x = (int)(Math.random()*4000+-1000);
		y = (int)(Math.random()*4000+-1000);
		rad = 10;
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		c = new Color(red, green, blue);
		mass = (int) (Math.PI*rad*rad);
		
	}
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, rad, rad);
	}
}
