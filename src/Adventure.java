/*
 * File: Adventure.java
 * --------------------
 * This program plays the Adventure game from Assignment #4.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/* Class: Adventure */
/**
 * This class is the main program class for the Adventure game.
 */

public class Adventure extends AdventureStub {

	// the rooms in the game
	private SortedMap<Integer, AdvRoom> rooms = new TreeMap<Integer, AdvRoom>();
	// the list of the objects
	private List<AdvObject> objects = new ArrayList<AdvObject>();

	// the inventory of the player
	// ??

	// Use this scanner for any console input
	private static Scanner scan = new Scanner(System.in);

	/**
	 * This method is used only to test the program
	 */
	public static void setScanner(Scanner theScanner) {
		scan = theScanner;
		// Delete the following line when done
		AdventureStub.setScanner(theScanner);
	}

	/**
	 * Runs the adventure program
	 */
	public static void main(String[] args) {
		AdventureStub.main(args); // Replace with your code
		System.out.print("What will be your adventure today?");
		String name = scan.nextLine(); // small, crowther
		try {
			Adventure game = createGame(name);
			game.run();
		} catch (IOException e) {
			System.out.println("Could not find the files for" + name);
		}
	}

	public static Adventure createGame(String name) throws IOException {
		Adventure game = new Adventure();
		// read the rooms
		Scanner scan = new Scanner(new File(name + "Rooms.txt"));
		while (scan.hasNextInt()) {
			AdvRoom room = AdvRoom.readFromFile(scan);
			game.rooms.put(room.getRoomNumber(), room);
		}
		scan.close();

		// read the objects
		scan = new Scanner(new File(name + "Objects.txt"));
		while (scan.hasNext()) {
			// Be careful with blank lines
			AdvObject object = AdvObject.readFromFile(scan);
			game.objects.add(object);
			// place the object in its corresponding room
			AdvRoom room = game.rooms.get(object.getInitialLocation());
			room.addObject(object);
		}
		scan.close();
		// read the synonyms
		return game;
	}

	/* Method: executeMotionCommand(direction) */
	/**
	 * Executes a motion command. This method is called from the
	 * AdvMotionCommand class to move to a new room.
	 * 
	 * @param direction
	 *            The string indicating the direction of motion
	 */
	public void executeMotionCommand(String direction) {
		super.executeMotionCommand(direction); // Replace with your code
	}

	/* Method: executeQuitCommand() */
	/**
	 * Implements the QUIT command. This command should ask the user to confirm
	 * the quit request and, if so, should exit from the play method. If not,
	 * the program should continue as usual.
	 */
	public void executeQuitCommand() {
		super.executeQuitCommand(); // Replace with your code
	}

	/* Method: executeHelpCommand() */
	/**
	 * Implements the HELP command. Your code must include some help text for
	 * the user.
	 */
	public void executeHelpCommand() {
		super.executeHelpCommand(); // Replace with your code
	}

	/* Method: executeLookCommand() */
	/**
	 * Implements the LOOK command. This method should give the full description
	 * of the room and its contents.
	 */
	public void executeLookCommand() {
		super.executeLookCommand(); // Replace with your code
	}

	/* Method: executeInventoryCommand() */
	/**
	 * Implements the INVENTORY command. This method should display a list of
	 * what the user is carrying.
	 */
	public void executeInventoryCommand() {
		super.executeInventoryCommand(); // Replace with your code
	}

	/* Method: executeTakeCommand(obj) */
	/**
	 * Implements the TAKE command. This method should check that the object is
	 * in the room and deliver a suitable message if not.
	 * 
	 * @param obj
	 *            The AdvObject you want to take
	 */
	public void executeTakeCommand(AdvObject obj) {
		super.executeTakeCommand(obj); // Replace with your code
	}

	/* Method: executeDropCommand(obj) */
	/**
	 * Implements the DROP command. This method should check that the user is
	 * carrying the object and deliver a suitable message if not.
	 * 
	 * @param obj
	 *            The AdvObject you want to drop
	 */
	public void executeDropCommand(AdvObject obj) {
		super.executeDropCommand(obj); // Replace with your code
	}

	/* Private instance variables */
	// Add your own instance variables here
}

