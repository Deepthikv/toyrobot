package toyrobot.command;

import toyrobot.constants.Face;
import toyrobot.model.Position;
import toyrobot.model.Robot;
import toyrobot.registry.FaceDirectionRegistry;
import toyrobot.validation.PositionValidator;

/**
 * Commands for the move
 * 
 * @author Deepthi
 *
 */
public class MoveCommand extends RobotCommand {

	private PositionValidator positionValidator;

	public MoveCommand(Robot robot) {
		super(robot);
	}

	public void setPositionValidator(PositionValidator positionValidator) {
		this.positionValidator = positionValidator;
	}

	/**
	 * Executes the robot's movement and sets the position accordingly
	 * only if the movement is allowed. Robot's movement is validated
	 * by the validator class {@code}PositionValidator to restrict the robot not to fall.
	 * 
	 * See {@code} PositionValidator
	 */
	@Override
	public void execute() {
		Robot robot = getRobot();
		
		//needs to have some nice logic to avoid if else
		if (robot.getCurrentFace() == Face.EAST) {			
			Position currentPosition = robot.getCurrentPosition();		
			if (positionValidator.validatePosition()) {
				currentPosition.setX(currentPosition.getX() + FaceDirectionRegistry.getMove(robot.getCurrentFace()).getValue());
			}
		} else if (robot.getCurrentFace() == Face.NORTH) {			
			Position currentPosition = robot.getCurrentPosition();			
			if (positionValidator.validatePosition()) {
				currentPosition.setY(currentPosition.getY() + FaceDirectionRegistry.getMove(robot.getCurrentFace()).getValue());
			}
		} else if (robot.getCurrentFace() == Face.WEST) {			
			Position currentPosition = robot.getCurrentPosition();
			if (positionValidator.validatePosition()) {
				currentPosition.setX(currentPosition.getX() + FaceDirectionRegistry.getMove(robot.getCurrentFace()).getValue());
			}

		} else if (robot.getCurrentFace() == Face.SOUTH) {			
			Position currentPosition = robot.getCurrentPosition();
			if (positionValidator.validatePosition()) {
				currentPosition.setY(currentPosition.getY() + FaceDirectionRegistry.getMove(robot.getCurrentFace()).getValue());
			}
		}
	}
}
