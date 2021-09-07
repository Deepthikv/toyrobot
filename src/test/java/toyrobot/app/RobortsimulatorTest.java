package toyrobot.app;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import toyrobot.constants.Face;
import toyrobot.exception.InvalidCommandException;
import toyrobot.model.Result;

/**
 * Contains all the test cases for the robot simulator.
 * 
 * 
 * @author Deepthi
 *
 */
public class RobortsimulatorTest {

	private String TEST_FOLDER_PATH = "src/test/resources/";

	/**
	 * This is a simple default test case. It does not contain any actions. This is
	 * to verify the command is working fine. Expected output:0,0,EAST Input: PLACE
	 * 0,0,EAST REPORT
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testDefault() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "DEFAULT-TEST.txt"));
		assertEquals(0, result.getPosition().getX());
		assertEquals(0, result.getPosition().getY());
		assertEquals(Face.EAST, result.getFace());
	}

	/**
	 * Robot facing SOUTH and trying to move forward. Robot should not fall.
	 * Expected result should be the position where the robot was. It should stand
	 * 0,0 in position itself Input: PLACE 0,0,SOUTH MOVE REPORT Expected: 0,0,SOUTH
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testSouthFaceMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "SOUTH-FACE.txt"));
		assertEquals(0, result.getPosition().getX());
		assertEquals(0, result.getPosition().getY());
		assertEquals(Face.SOUTH, result.getFace());
	}

	/**
	 * Robot facing WEST and trying to move forward. Robot should not fall. Expected
	 * result should be the position where the robot was. It should stand 0,0 in
	 * position itself Input: PLACE 0,0,WEST MOVE REPORT Expected: 0,0,SOUTH
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testWestFaceMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "WEST-FACE.txt"));
		assertEquals(0, result.getPosition().getX());
		assertEquals(0, result.getPosition().getY());
		assertEquals(Face.WEST, result.getFace());
	}

	/**
	 * Robot facing NORTH and trying to move forward. Robot should not fall.
	 * Expected result should be the position where the robot was. It should stand
	 * 0,0 in position itself Input: PLACE 0,0,NORTH MOVE REPORT Expected: 0,0,NORTH
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testNorthFaceMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "NORTH-FACE.txt"));
		assertEquals(0, result.getPosition().getX());
		assertEquals(4, result.getPosition().getY());
		assertEquals(Face.NORTH, result.getFace());
	}

	/**
	 * Robot facing EAST and trying to move forward. Robot should not fall. Expected
	 * result should be the position where the robot was. It should stand 0,0 in
	 * position itself Input: PLACE 0,0,EAST MOVE REPORT Expected: 0,0,EAST
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testEastFaceMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "EAST-FACE.txt"));
		assertEquals(4, result.getPosition().getX());
		assertEquals(4, result.getPosition().getY());
		assertEquals(Face.EAST, result.getFace());
	}

	/**
	 * Left move command
	 * 
	 * Expected:3,3,NORTH Input: PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testLeftMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "LEFT-MOVE-TEST.txt"));
		assertEquals(3, result.getPosition().getX());
		assertEquals(3, result.getPosition().getY());
		assertEquals(Face.NORTH, result.getFace());
	}

	/**
	 * Left move command
	 * 
	 * Expected:3,1,SOUTH Input: PLACE 1,2,EAST MOVE MOVE RIGHT MOVE REPORT
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testRightMove() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "RIGHT-MOVE-TEST.txt"));
		assertEquals(3, result.getPosition().getX());
		assertEquals(1, result.getPosition().getY());
		assertEquals(Face.SOUTH, result.getFace());
	}

	/**
	 * This is a random test case. Placing at 4,4. Expected 0,0,EAST PLACE 4,4,SOUTH
	 * MOVE RIGHT MOVE MOVE LEFT MOVE RIGHT MOVE LEFT MOVE MOVE RIGHT REPORT
	 * 
	 * @throws IOException
	 * @throws RobotException
	 * @throws InvalidCommandException
	 */
	@Test
	public void testRandom1() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "RANDOM-1.txt"));
		assertEquals(0, result.getPosition().getX());
		assertEquals(0, result.getPosition().getY());
		assertEquals(Face.WEST, result.getFace());
	}

	/**
	 * Random test case
	 * 
	 * @throws IOException
	 * @throws InvalidCommandException
	 * @throws RobotException
	 */
	@Test
	public void testRandom2() throws IOException, InvalidCommandException {
		Result result = new Robortsimulator().run(getData(TEST_FOLDER_PATH + "RANDOM-2.txt"));
		assertEquals(2, result.getPosition().getX());
		assertEquals(2, result.getPosition().getY());
		assertEquals(Face.EAST, result.getFace());
	}

	/**
	 * Test case for invalid commands provided
	 * 
	 * @throws IOException
	 * @throws InvalidCommandException
	 */

	@Test(expected = InvalidCommandException.class)
	public void testInvalidCommand() throws IOException, InvalidCommandException {
		new Robortsimulator().run("SSSSSSSS DKDK");
	}

	private String getData(String path) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
