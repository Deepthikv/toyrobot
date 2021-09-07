package toyrobot.command;

import java.util.logging.Logger;

import toyrobot.model.Robot;

public class ReportCommand extends RobotCommand{
	
	private Logger logger = Logger.getLogger(ReportCommand.class.getName());
	
	public ReportCommand(Robot robot) {
		super(robot);
	}

	@Override
	public void execute() {	
		Robot robot = getRobot();
		logger.info(robot.getCurrentPosition().toString()+","+robot.getCurrentFace().toString());		
	}

}
