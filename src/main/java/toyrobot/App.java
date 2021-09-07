package toyrobot;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import toyrobot.app.Robortsimulator;
import toyrobot.exception.InvalidCommandException;

/**
 * Main class for running the toy robot simulaator
 *
 */
public class App {
	private static Logger logger = Logger.getLogger(App.class.getName());
	public static void main(String[] args) {		
		String userDirectory = System.getProperty("user.dir");
		String fileName = null;		
		if(args!=null && args.length > 0) {	
			fileName = args[0];			
		}else {
			fileName = userDirectory + File.separator + "testdata.txt" ;
		}
		String command = getData(fileName);
		try {
			logger.info("Application started with the command from file "+fileName+ ": " + command);
			new Robortsimulator().run(command);
		} catch (InvalidCommandException e) {
			e.printStackTrace();
			logger.severe("The input command was not proper: " + " " + command);
		}
	}

	private static String getData(String path) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			logger.severe("Invalid path:"+path);
			System.exit(0);
		}
		return content;
	}
}
