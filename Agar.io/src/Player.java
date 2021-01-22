import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
	private int x, y;
	private double cx, cy;
	private double rad; 
	private Color c;
	private boolean alive;
	private double vx, vy;
	private double mass; 
	private double velMult;
	Rectangle world = new Rectangle(0, 0, 1500, 1500); //x ,y w, h 
	
	public Player () {
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		rad = 40;
		x = 500;
		y = 500;
		cx = x+rad;
		cy = y+rad;
		c = new Color(red, green, blue);
		
		vx = 0;
		vy = 0;
		mass = (int) (Math.PI*rad*rad);
		velMult = 150/rad;
	}
	
	public void paint(Graphics g) {
		update();
		g.setColor(c);
		g.fillOval(x, y, (int)rad, (int)rad);
	}
	public boolean collides(Food e) {
		int xd = Math.abs(e.getCx() - x);
	    int yd = Math.abs(e.getCy() - y);
	    int rdiff = (int)(Math.abs(e.getRad()-rad));
	    int distance = (int) Math.sqrt(((xd * xd) + (yd * yd)));
	    return (distance <= rdiff);

	}
	public double getVelmult() {
		return velMult;
	}

	public void setVelmult(double velmult) {
		this.velMult = velmult;
	}

	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
	}

	public double getCy() {
		return cy;
	}

	public void setCy(double cy) {
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
	public void setMass(double d) {
		this.mass = d;
	}
	
	public void update() {
	
		rad = (int)Math.sqrt(mass/Math.PI);
		
	}
}
