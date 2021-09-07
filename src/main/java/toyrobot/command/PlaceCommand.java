package toyrobot.command;

import toyrobot.constants.Face;
import toyrobot.model.Robot;

public class PlaceCommand extends RobotCommand{

	public PlaceCommand(Robot robot) {
		super(robot);
	}	

	@Override
	public void execute() {
		String[] positionAndFace = "".replace("PLACE", "").trim().split(",");
		if (positionAndFace.length > 2) {
			Robot robot = getRobot();
			robot.getCurrentPosition().setX(Integer.valueOf(positionAndFace[0]));
			robot.getCurrentPosition().setY(Integer.valueOf(positionAndFace[1]));
			robot.setFace(Face.valueOf(positionAndFace[2]));
		}
	}
}
