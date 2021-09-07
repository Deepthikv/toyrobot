package toyrobot.command;

import toyrobot.constants.Direction;
import toyrobot.model.Robot;

public class RightCommand extends DirectionCommand{

	public RightCommand(Robot robot) {
		super(robot);
	}

	@Override
	public Direction getDirection() {
		return Direction.RIGHT;
	}
}
