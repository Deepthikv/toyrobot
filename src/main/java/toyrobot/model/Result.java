package toyrobot.model;

import toyrobot.constants.Face;

public class Result {
	
	private Position position;
	private Face face;
	
	public Result(Position position, Face face) {
		super();
		this.position = position;
		this.face = face;
	}

	public Position getPosition() {
		return position;
	}
	
	public Face getFace() {
		return face;
	}
	
	@Override
	public String toString() {		
		return position.getX()+","+position.getY()+","+face;
	}

}
