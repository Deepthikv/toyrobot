package toyrobot.command;

import toyrobot.constants.Direction;
import toyrobot.model.Robot;

public class LeftCommand extends DirectionCommand{

	public LeftCommand(Robot robot) {
		super(robot);
	}

	@Override
	public Direction getDirection() {
		return Direction.LEFT;
	}
}
