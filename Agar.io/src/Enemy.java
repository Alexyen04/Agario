import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	private int x, y;
	private int rad; 
	private Color c;
	private boolean alive;
	private double vx, vy;
	private double mass; 
	private int cx, cy; //center point x y
	Rectangle world = new Rectangle(-500, -500, 2000, 2000); //x ,y w, h 
	
	public Enemy() {
		//random radius
		rad = (int)(Math.random()*50)+10;
		
		//spawn the enemy randomly anywhere on a 800x600 screen
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*600);
		
		// center point
		cx = x + rad;
		cy = y + rad; 
		
		//calculating mass
		mass = Math.PI*rad*rad; 
		
		//have enemy move randomly by setting vx, vy to some random
		//non zero value between -3,3
		
		while(vx == 0) {
			vx = (double)((1/mass)*9000);
			vx *= (double)(Math.random()*3)-1;
		}
		
		while(vy == 0) {
			vy = (double)((1/mass)*9000);
			vy *= (double)(Math.random()*3)-1;
		}
		
		
				
	
		
		//generate a random color by generating random r,g,b values
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		c = new Color(red, green, blue);
		
	
		
		
	}
	//collision code
	
	public boolean collides(Enemy en2) {
		 int xd = Math.abs(en2.getCx() - x);
	     int yd = Math.abs(en2.getCy() - y);
	     int rsum = en2.getRad() + rad;
	     int distance = (int) Math.sqrt(((xd * xd) + (yd * yd)));
	     return (distance <= rsum);


    }
	/*
	public double newRadius(Enemy en3) {
		
	}
	
	*/
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public Rectangle getWorld() {
		return world;
	}

	public void setWorld(Rectangle world) {
		this.world = world;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public void paint(Graphics g) {
		update();
		g.setColor(c);
		g.fillOval(x, y, rad*2, rad*2);
		
		
		/*have the enemy object bounce off the rectangle borders
		 * using the helper methods (getters) for minx maxx etc.
		 */

		
		if(x >= world.getMaxX() || x<= world.getMinX()) {
			vx *= -1;
		}
		if(y >= world.getMaxY() || y<= world.getMinY()) {
			vy *= -1;
		}
		
		
		//enemy collision
		
	}
	
	public void update() {
		x+= vx;
		y+= vy;
		cx += vx;
		cy += vy;
	}
}
