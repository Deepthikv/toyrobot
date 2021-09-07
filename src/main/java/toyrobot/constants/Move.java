package toyrobot.constants;

public enum Move {
	FORWARD(1), 
	BACKWARD(-1);

	private int value;

	private Move(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
