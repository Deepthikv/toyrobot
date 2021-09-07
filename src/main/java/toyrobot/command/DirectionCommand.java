package toyrobot.command;

import toyrobot.constants.Direction;
import toyrobot.constants.Face;
import toyrobot.model.Robot;
import toyrobot.registry.FaceDirectionRegistry;
/**
 * This is an abstract command for left and right command.
 * Based on the command, Robot's new face will be set.
 * 
 * For example: Currently Robot is facing at NORTH face and LEFT command 
 *              is invoked, new face WEST will be returned and that face will 
 *              be set as new face for the robot. 
 *               
 *              
 * @author Deepthi
 *
 */
public abstract class  DirectionCommand extends RobotCommand{

	public DirectionCommand(Robot robot) {
		super(robot);
	}
	
	@Override
	public void execute() {		
		Robot robot = getRobot();
		Face face = FaceDirectionRegistry.getFace(robot.getCurrentFace() + ":" + getDirection());
		robot.setFace(face);
	}
	
	public abstract Direction getDirection();
}
