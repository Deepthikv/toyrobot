package toyrobot.registry;

import java.util.HashMap;
import java.util.Map;

import toyrobot.constants.Direction;
import toyrobot.constants.Face;
import toyrobot.constants.Move;

/**
 * Configuration class for keeping all the face direction 
 * configuration entries
 * 
 * @author Deepthi
 *
 */
public class FaceDirectionRegistry {
	
	private static Map<String, Face> faceMap = new HashMap<>();
	private static Map<Face, Move> faceMoveMap = new HashMap<>();	
	
	static {
		
		//stores the different combination of direction as Faces
		faceMap.put(Face.NORTH + ":" + Direction.LEFT, Face.WEST);
		faceMap.put(Face.NORTH + ":" + Direction.RIGHT, Face.EAST);

		faceMap.put(Face.WEST + ":" + Direction.LEFT, Face.SOUTH);
		faceMap.put(Face.WEST + ":" + Direction.RIGHT, Face.NORTH);

		faceMap.put(Face.SOUTH + ":" + Direction.LEFT, Face.EAST);
		faceMap.put(Face.SOUTH + ":" + Direction.RIGHT, Face.WEST);

		faceMap.put(Face.EAST + ":" + Direction.LEFT, Face.NORTH);
		faceMap.put(Face.EAST + ":" + Direction.RIGHT, Face.SOUTH);
		
		//Storing the moves based the face. It is 
		//mainly used to increment/decrement the x and y cordinates		
		faceMoveMap.put(Face.EAST, Move.FORWARD);
		faceMoveMap.put(Face.NORTH, Move.FORWARD);
		faceMoveMap.put(Face.WEST, Move.BACKWARD);
		faceMoveMap.put(Face.SOUTH, Move.BACKWARD);
	}	
	
	/**
	 * Gets the face from the direction
	 * 
	 * @param direction
	 * @return the face
	 */
	public static Face getFace(String direction) {
		return faceMap.get(direction);
	}
	
	/**
	 * Gets the move from the face. 
	 * @param face
	 * @return move
	 */
	public static Move getMove(Face face) {
		return faceMoveMap.get(face);
	}

}
