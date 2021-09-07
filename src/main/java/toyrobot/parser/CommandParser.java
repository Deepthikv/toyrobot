package toyrobot.parser;

import java.util.Arrays;
import java.util.List;

import toyrobot.exception.InvalidCommandException;

public class CommandParser {
	
	/**
	 * Parse the command and covert to list of commands
	 * 
	 * @param string
	 * @return list of commands
	 * @throws InvalidCommandException
	 */
	public static List<String> parseCommandFromString(String string) throws InvalidCommandException{
		String lines[] = string.split("\\r?\\n");
		return Arrays.asList(lines);
	}	
}
