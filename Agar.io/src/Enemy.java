import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	private int x, y;
	private double rad; 
	private Color c;
	private boolean alive;
	private double vx, vy;
	private double mass; 
	private int cx, cy; //center point x y
	Rectangle world = new Rectangle(0, 0, 1500, 1500); //x ,y w, h 
	
	public Enemy() {
		//random radius
		rad = (int)(Math.random()*50)+10;
		
		//spawn the enemy randomly anywhere on a 800x600 screen
		x = (int)(Math.random()*1000+300);
		y = (int)(Math.random()*1000+300);
		
		// center point
		cx = (int)(x + rad);
		cy = (int)(y + rad); 
		
		//calculating mass
		mass = Math.PI*rad*rad; 
		
		//have enemy move randomly by setting vx, vy to some random
		//non zero value between -3,3
		
		while(vx == 0) {
			vx = (int)((150/rad)+2);
			vx *= (int)(Math.random()*3)-1;
		}
		
		while(vy == 0) {
			vy = (int)((150/rad)+2);
			vy *= (int)(Math.random()*3)-1;
		}
		
		
				
	
		
		//generate a random color by generating random r,g,b values
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		c = new Color(red, green, blue);
		
	
		
		
	}
	/*
	public void massToRad(Enemy e) {
		mass += e.getMass();
		e.setRad(Math.sqrt(mass/Math.PI));
		
	}
	*/
	
	public boolean collides(Enemy en2) {
		int xd = Math.abs(en2.getCx() - cx);
	    int yd = Math.abs(en2.getCy() - cy);
	    int rdiff = (int)(Math.abs(en2.getRad()-rad));
	    int distance = (int) Math.sqrt(((xd * xd) + (yd * yd)));
	    return (distance < rdiff);



    }
	
	public void paint(Graphics g) {
		update();
		g.setColor(c);
		g.fillOval(x, y, (int)rad*2, (int)rad*2);
		
		
		/*have the enemy object bounce off the rectangle borders
		 * using the helper methods (getters) for minx maxx etc.
		 */

		
		if(x <= world.getMinX() || x+(rad*2)>= world.getMaxX()) {
			vx*=-1;
		}
		if(y <= world.getMinY() || y+(rad*2) >= world.getMaxY()) {
			vy*=-1;
		}
		if(x <= 0 && y <= 0) {
			x +=5;
			y +=5;
		}
		//enemy collision
		
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

	public double getRad() {
		return rad;
	}

	public void setRad(double rad) {
		this.rad = rad;
	}

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

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
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

	public void update() {
		rad = (Math.sqrt(mass/Math.PI));
		x+= vx;
		y+= vy;
		cx += vx;
		cy += vy;
	}
}
