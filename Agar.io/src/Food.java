import java.awt.Color;
import java.awt.Graphics;

public class Food {
	private int x, y;
	private double rad; 
	private Color c;
	private boolean alive;
	private double mass; 
	private int cx, cy; //center point x y
	private double vx, vy;
	
	public Food () {
		x = (int)(Math.random()*4000+-1000);
		y = (int)(Math.random()*4000+-1000);
		rad = 5;
		cx = (int)(x + rad);
		cy = (int)(y + rad); 
		vx = 0;
		vy = 0;
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		c = new Color(red, green, blue);
		mass = (int) (Math.PI*rad*rad);
		
	}
	public void massToRad(Enemy e) {
		double fMass = (double) (e.getMass()+mass);
		e.setRad(Math.sqrt(fMass/Math.PI));
		
	}
	
	public boolean collides(Enemy e) {
		int xd = Math.abs(e.getCx() - x);
	    int yd = Math.abs(e.getCy() - y);
	    int rdiff = (int)(Math.abs(e.getRad()-rad));
	    int distance = (int) Math.sqrt(((xd * xd) + (yd * yd)));
	    return (distance <= rdiff);

	}
	
	public double getVx() {
		return vx;
	}
	public void setVx(double d) {
		this.vx = d;
	}
	public double getVy() {
		return vy;
	}
	public void setVy(double vy) {
		this.vy = vy;
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

	public void setRad(double d) {
		this.rad = d;
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

	public double getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public void paint(Graphics g) {
		update();
		g.setColor(c);
		g.fillOval(x, y, (int)rad*2, (int)rad*2);
	}
	public void update() {
		x += vx;
		y += vy;
		cx += vx;
		cy += vy;
	}
}
