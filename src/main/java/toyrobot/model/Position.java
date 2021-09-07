package toyrobot.model;

public class Position {

	private int x;
	private int y;
	
	public Position() {
		this(0, 0);
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Resets the position
	 */
	public void reset() {

	}

	@Override
	public String toString() {
		return this.x + "," + this.y ;
	}

}
