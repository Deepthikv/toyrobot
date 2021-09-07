package toyrobot.command;

import toyrobot.model.Robot;

/**
 * It is an abstract base command for all the robot commands 
 * 
 * @author Deepthi
 *
 */
public abstract class RobotCommand implements ICommand{

	private Robot robot;
	
	public RobotCommand(Robot robot) {
		this.robot = robot;
	}
	
	protected Robot getRobot() {
		return robot;
	}

}
