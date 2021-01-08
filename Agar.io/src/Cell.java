import java.awt.Color;
import java.awt.Graphics;

public class Cell { //class header
	//instance variables 
	
	private int x, y;
	private int rad; 
	private Color c;
	private boolean alive;
	private int vx, vy;
	private int mass; 
	
	
	//add the constructor
	
	//add a mass to radius helper method
	
	public Cell() {
		
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, rad, rad);
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

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}


	
	
	
}

