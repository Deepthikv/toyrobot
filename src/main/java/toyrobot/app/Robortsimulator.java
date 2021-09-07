package toyrobot.app;

import toyrobot.exception.InvalidCommandException;
import toyrobot.model.Result;
import toyrobot.model.Robot;

/**
 * Robot simulator class
 * 
 * @author Deepthi
 *
 */
public class Robortsimulator {
	
	/**
	 * Run the robot simulator based on the commands given.
	 * Any invalid command will be throws as InvalidCommandException
	 * 
	 * @param command
	 * @return the position and face
	 * @throws InvalidCommandException
	 */
	public Result run(String command) throws InvalidCommandException {
		Robot robot = new Robot();
		return robot.execute(command);
	}

}
