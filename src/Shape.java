import java.awt.Graphics;

public interface Shape {
	abstract void draw(Graphics g);
	abstract public Shape deepCopy();
	abstract void createChildren();
}