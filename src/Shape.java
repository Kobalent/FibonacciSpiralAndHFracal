import java.awt.Graphics;

public interface Shape {
	abstract void draw(Graphics g);
	abstract public Shape deepCopy();
	abstract void createChildren();
	public abstract boolean criticalCondition();
	public abstract boolean addLevel();
	public abstract boolean removeLevel();
	public abstract int getLevel();
	public abstract String toString();
}
