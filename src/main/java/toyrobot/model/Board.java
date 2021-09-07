package toyrobot.model;

public class Board {

	private int x;
	private int y;
	
	public Board() {
		this(5, 5);
	}

	public Board(int x, int y) {
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
	
}
