package toyrobot.model;

import java.util.logging.Logger;

import toyrobot.command.ICommand;
import toyrobot.command.MoveCommand;
import toyrobot.constants.Command;
import toyrobot.constants.Face;
import toyrobot.constants.Message;
import toyrobot.exception.InvalidCommandException;
import toyrobot.parser.CommandParser;
import toyrobot.registry.RobotCommandRegistry;
import toyrobot.validation.PositionValidator;

/**
 * Robot class which accepts the command and execute accordingly and
 * gives the result in the form of position and face.
 * 
 *  Example: 0,0,NORTH
 * 
 * @author Deepthi
 *
 */
public class Robot {

	private Logger logger = Logger.getLogger(Robot.class.getName());	
	private Face face = Face.NORTH;
	private Board board = new Board();
	private Position position = null;
	private RobotCommandRegistry registry;
	

	
	public Robot() {
		initialize();
	}

	/**
	 * Initialize the objects
	 */
	private void initialize() {
		board = new Board();
		position = new Position();		
		registry = new RobotCommandRegistry(this);
		registry.registerCommands();
	}

	/**
	 * Executes  the robot based on the commands given and return the 
	 * Result contains the position and face.
	 * 
	 * @throws InvalidCommandException 
	 * @throws RobotException 
	 */
	public Result execute(String commands) throws InvalidCommandException {
		try {
			
			for (String command : CommandParser.parseCommandFromString(commands)) {
				if (command.startsWith(Command.PLACE.toString())) {
					try {
						String[] positionAndFace = command.replace(Command.PLACE.toString(), "").trim().split(",");
						
						//Initialize the position and face from the command
						if (positionAndFace.length > 2) {
							position.setX(Integer.valueOf(positionAndFace[0]));
							position.setY(Integer.valueOf(positionAndFace[1]));
							setFace(Face.valueOf(positionAndFace[2]));
						}
					}catch(Exception ex) {
						throw new InvalidCommandException("Invalid command");
					}
					
				}
				//Specific to move command
				else if (Command.valueOf(command) == Command.MOVE) {
					PositionValidator positionValidator = new PositionValidator(this, board);
					ICommand command2 = registry.getCommand(Command.valueOf(command));
					((MoveCommand) command2).setPositionValidator(positionValidator);
					command2.execute();
				}
				////Specific to other commands like left,right,etc
				else {
					ICommand command2 = registry.getCommand(Command.valueOf(command));
					command2.execute();
				}
			}		
			return new Result(getCurrentPosition(), getCurrentFace());
			
		}catch(InvalidCommandException ex) {
			logger.severe(Message.INVALID_COMMAND+" "+ex.getMessage());
			throw new InvalidCommandException(Message.INVALID_COMMAND);
		}
		catch(Exception ex) {
			logger.severe(Message.SOME_ERROR+" "+ex.getMessage());
			throw new InvalidCommandException(Message.INVALID_COMMAND);
		}
	}

	/**
	 * Sets the face
	 * 
	 * @param face
	 */
	public void setFace(Face face) {
		this.face = face;
	}

	/**
	 * Gets the current position
	 * 
	 * @return the current position
	 */
	public Position getCurrentPosition() {
		return this.position;
	}

	/**
	 * Gets the current face
	 * 
	 * @return current face
	 */
	public Face getCurrentFace() {
		return this.face;
	}

	/**
	 * Sets the position
	 * 
	 * @param position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

}
