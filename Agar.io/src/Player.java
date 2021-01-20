import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	private int x, y;
	private int cx, cy;
	private int rad; 
	private Color c;
	private boolean alive;
	private double vx, vy;
	private int mass; 
	Rectangle world = new Rectangle(0, 0, 1500, 1500); //x ,y w, h 
	
	public Player () {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		cx = x+rad;
		cy = y+rad;
		x = 500;
		y = 500;
		c = new Color(red, green, blue);
		rad = 40;
		vx = 0;
		vy = 0;
		mass = (int) (Math.PI*rad*rad);
		
	}
	
	public void paint(Graphics g) {
		update();
		g.setColor(c);
		g.fillOval(x, y, rad, rad);
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
	public int getMass() {
		return mass;
	}
	public void setMass(int mass) {
		this.mass = mass;
	}
	
	public void update() {
		x += vx;
		y += vy;
		rad = (int)Math.sqrt(mass/Math.PI);
		
	}
}
