package toyrobot.validation;

import java.util.logging.Logger;

import toyrobot.constants.Face;
import toyrobot.model.Board;
import toyrobot.model.Position;
import toyrobot.model.Robot;

/**
 * PositionValidator validator class is mainly to validate
 * robots moves to restrict it falling down from the boundary
 * 
 * @author Deepthi
 *
 */
public class PositionValidator {
	
	private Logger logger = Logger.getLogger(PositionValidator.class.getName());	
	private Board board ;	
	private Robot robot;
	
	public PositionValidator(Robot robot,Board board) {
		this.robot = robot;
		this.board = board;
	}
	/**
	 * Validates the position of the robot. If the robot reaches boundary
	 * and try to move forward, then it return false and will not allow to be updated
	 * its position.
	 * 
	 * @param move
	 * @return
	 */
	public boolean validatePosition() {	
		Position position = robot.getCurrentPosition();
		Face currentFace = robot.getCurrentFace();		
		if(currentFace == Face.SOUTH && (position.getY() == 0) ) {
			logger.warning("Robot is about to fall at position-->"+position+" in the next move");
			return false;
		}		
		if(currentFace == Face.WEST && (position.getX() == 0) ) {
			logger.warning("Robot is about to fall at position-->"+position+" in the next move");
			return false;
		}		
		if(currentFace == Face.NORTH && (position.getY() == (this.board.getY()-1)) ) {
			logger.warning("Robot is about to fall at position-->"+position+" in the next move");
			return false;
		}		
		if(currentFace == Face.EAST && (position.getX() == (this.board.getX()-1)) ) {
			logger.warning("Robot is about to fall at position-->"+position+" in the next move");
			return false;
		}
		return true;
	}
}
