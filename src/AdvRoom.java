/*
 * File: AdvRoom.java
 * ------------------
 * This file defines a class that models a single room in the
 * Adventure game.
 */

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/* Class: AdvRoom */
/**
 * This class defines a single room in the Adventure game. A room is
 * characterized by the following properties:
 * 
 * <ul>
 * <li>A room number, which must be greater than zero
 * <li>Its name, which is a one-line string identifying the room
 * <li>Its description, which is a multiline array describing the room
 * <li>A list of objects contained in the room
 * <li>A flag indicating whether the room has been visited
 * <li>A motion table specifying the exits and where they lead </li>
 * 
 * The external format of the room data file is described in the assignment
 * handout. The comments on the methods exported by this class show how to use
 * the initialized data structure.
 */

public class AdvRoom extends AdvRoomStub {
	
	public AdvRoom() {
		
	}
	
	public AdvRoom(int number, String name, String[] description, List<AdvObject> roomObjects, boolean flag, AdvMotionTableEntry[] roomExits) {
		
	}

	/* Method: getRoomNumber() */
	/**
	 * Returns the room number.
	 * 
	 * @usage int roomNumber = room.getRoomNumber();
	 * @return The room number
	 */
	public int getRoomNumber() {
		return roomNum;
	}

	/* Method: getName() */
	/**
	 * Returns the room name, which is its one-line description.
	 * 
	 * @usage String name = room.getName();
	 * @return The room name
	 */
	public String getName() {
		return roomName;
	}

	/* Method: getDescription() */
	/**
	 * Returns an array of strings that correspond to the long description of
	 * the room (including the list of the objects in the room).
	 * 
	 * @usage String[] description = room.getDescription();
	 * @return An array of strings giving the long description of the room
	 */
	public String[] getDescription() {
		return super.getDescription(); // Replace with your code
	}

	/* Method: addObject(obj) */
	/**
	 * Adds an object to the list of objects in the room.
	 * 
	 * @usage room.addObject(obj);
	 * @param The
	 *            AdvObject to be added
	 */
	public void addObject(AdvObject obj) {
		objects.add(obj);
	}

	/* Method: removeObject(obj) */
	/**
	 * Removes an object from the list of objects in the room.
	 * 
	 * @usage room.removeObject(obj);
	 * @param The
	 *            AdvObject to be removed
	 */
	public void removeObject(AdvObject obj) {
		objects.remove(obj);
	}

	/* Method: containsObject(obj) */
	/**
	 * Checks whether the specified object is in the room.
	 * 
	 * @usage if (room.containsObject(obj)) . . .
	 * @param The
	 *            AdvObject being tested
	 * @return true if the object is in the room, and false otherwise
	 */
	public boolean containsObject(AdvObject obj) {
		return objects.contains(obj);
	}

	/* Method: getObjectCount() */
	/**
	 * Returns the number of objects in the room.
	 * 
	 * @usage int nObjects = room.getObjectCount();
	 * @return The number of objects in the room
	 */
	public int getObjectCount() {
		return objects.size();
	}

	/* Method: getObject(index) */
	/**
	 * Returns the specified element from the list of objects in the room.
	 * 
	 * @usage AdvObject obj = room.getObject(index);
	 * @return The AdvObject at the specified index position
	 */
	public AdvObject getObject(int index) {
		return objects.get(index);
	}

	/* Method: setVisited(flag) */
	/**
	 * Sets the flag indicating that this room has been visited according to the
	 * value of the parameter. Calling setVisited(true) means that the room has
	 * been visited; calling setVisited(false) restores its initial unvisited
	 * state.
	 * 
	 * @usage room.setVisited(flag);
	 * @param flag
	 *            The new state of the "visited" flag
	 */
	public void setVisited(boolean flag) {
		visitedFlag = flag;
	}

	/* Method: hasBeenVisited() */
	/**
	 * Returns true if the room has previously been visited.
	 * 
	 * @usage if (room.hasBeenVisited()) . . .
	 * @return true if the room has been visited; false otherwise
	 */
	public boolean hasBeenVisited() {
		return visitedFlag;
	}

	/* Method: getMotionTable() */
	/**
	 * Returns the motion table associated with this room, which is an array of
	 * directions, room numbers, and enabling objects stored in a
	 * AdvMotionTableEntry.
	 * 
	 * @usage AdvMotionTableEntry[] motionTable = room.getMotionTable();
	 * @return The array of motion table entries associated with this room
	 */
	public AdvMotionTableEntry[] getMotionTable() {
		return motions;
	}

	/* Method: readFromFile(rd) */
	/**
	 * Reads the data for this room from the Scanner scan, which must have been
	 * opened by the caller. This method returns a room if the room
	 * initialization is successful; if there are no more rooms to read,
	 * readFromFile returns null.
	 * 
	 * @usage AdvRoom room = AdvRoom.readFromFile(scan);
	 * @param scan
	 *            A scanner open on the rooms data file
	 * @return a room if successfully read; null if at end of file
	 */
	public static AdvRoom readFromFile(Scanner scan) {
		roomNum = scan.nextInt();
		scan.nextLine();
		roomName = scan.nextLine();
		
		//Stores default delimiter;
		Pattern pat = scan.delimiter();
		
		//print room name and number (for testing)
		System.out.println("");
		System.out.println(roomNum);
		System.out.println(roomName);
		
		ArrayList<String> rooms = new ArrayList<String>();
		ArrayList<AdvMotionTableEntry> exits = new ArrayList<AdvMotionTableEntry>();
		String temp;
		
		//Variables for AdvMotionTableEntry object to store "movement map"
		String dir = "";
		int num = 0;
		String key = null;
		AdvMotionTableEntry exit;
		
		//Get room description
		while (!scan.hasNext("-----")) {
			temp = scan.nextLine();
			rooms.add(temp);
		}
		
		//print room description (for testing)
		for(int i = 0; i< rooms.size(); i++) {
			System.out.println(rooms.get(i));
		}
		
		//Advance past "-----"
		scan.nextLine();	
		
		while(!scan.hasNext("\\S")) {
			//prints out the values for movement map
			//Will be stored in variables after testing

			System.out.println("Scanned iten: " + scan.next());
			if(!scan.hasNextInt()) {
				System.out.println(scan.useDelimiter("/|\\s+").nextInt());
				System.out.println(scan.next());
				scan.useDelimiter(pat);
			}
			else {
				System.out.println(scan.nextInt());
			}
			

//			dir = scan.next();
//			num = scan.nextInt();
//			if(scan.hasNext("/")) {
//				key = scan.next();
//			}
//			else{
//				key = null;
//			}
//			scan.nextLine();
//			exit = new AdvMotionTableEntry(dir,num,key);
//			exits.add(exit);		
		}

		System.out.println("Exited loop");

		roomDescript = (String[]) rooms.toArray(new String[rooms.size()]);
		motions = exits.toArray(new AdvMotionTableEntry[exits.size()]);
		
		if(scan.hasNextLine()) {
			scan.nextLine();
		}	
		
		//for test
		System.out.println("Loop finished");
		
		return new AdvRoom(roomNum, roomName, roomDescript, objects, visitedFlag, motions);
	}

	/* Private instance variables */
	// Add your own instance variables here
	private static int roomNum;
	private static String roomName;
	private static String[] roomDescript;
	private static boolean visitedFlag = false;
	private static List<AdvObject> objects = new ArrayList<AdvObject>();
	private static AdvMotionTableEntry[] motions;
	
}
