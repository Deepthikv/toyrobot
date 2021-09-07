package toyrobot.registry;

import java.util.HashMap;
import java.util.Map;

import toyrobot.command.ICommand;
import toyrobot.command.LeftCommand;
import toyrobot.command.MoveCommand;
import toyrobot.command.ReportCommand;
import toyrobot.command.RightCommand;
import toyrobot.constants.Command;
import toyrobot.model.Robot;

/**
 * Configuration for class storing all the commands
 * for the robot.
 * 
 * @author Deepthi
 *
 */
public class RobotCommandRegistry {
	
	private Robot robot;
	private Map<Command, ICommand> commandsMap = new HashMap<>();
	public RobotCommandRegistry(Robot robot) {
		this.robot = robot ;		
	}	
	public void registerCommands() {	
		//commandsMap.put(Command.PLACE, new PlaceCommand(robot));
		commandsMap.put(Command.REPORT,new ReportCommand(robot));
		commandsMap.put(Command.LEFT,new LeftCommand(robot));
		commandsMap.put(Command.RIGHT,new RightCommand(robot));
		commandsMap.put(Command.MOVE,new MoveCommand(robot));
	}
	
	public ICommand getCommand(Command command) {
		return commandsMap.get(command);
	}

}
