///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Config.java
// Course:          CS 200, Fall 2020
//
// Author:          Matthew Noojin
// Email:           noojin@wisc.edu
// Lecturer's Name: Marc Renault
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// None.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

/**
 * This file contains constants for the text Adventure project. Also at the
 * bottom of this file are READ ME Notes for the Grader.
 *
 * @author Jim Williams
 * @author Matthew Noojin
 */
public class Config {

	/**
	 * Indexes into coordinate arrays specifying a location in the map.
	 */
	public static final int ROW = 0;
	public static final int COLUMN = 1;

	/**
	 * Indexes into the fields/attributes array for each map location (3rd dimension
	 * of the map array)
	 */
	public static final int NAME = 0;
	public static final int ENTER_TEXT = 1;
	public static final int ENTER_RESULT = 2;
	public static final int NEARBY_TEXT = 3;

	/**
	 * Values within the location fields/attributes that are used for game logic
	 * other than simply printing out.
	 * In name field, designates the starting location of the player
	*/
	public static final String NAME_START = "start";

	// The result of the player entering the field.
	public static final String RESULT_RANDOM_MOVE = "randomMove";
	public static final String RESULT_WIN = "win";
	public static final String RESULT_LOSE = "lose";
	public static final String RESULT_PHASER = "phaser";
	public static final String RESULT_NULL = "All is quiet...";
	public static final String RESULT_NOFIGHT = "You were overcome by the Klingon forces!";
	public static final String RESULT_FIGHT = "You blasted the villain with your phaser! An energy "
			+ "core disappeared...";
	public static final String NEARBY_NULL = "You find yourself in a lonely, deserted corner of "
			+ "this strange alien planet.";

	// Variable storing the count for collected energy cores during gameplay
	public static int ENERGY_CORES = 0;

	/**
	 * Values used by the player to navigate through the map and display information.
	 */
	public static final String MOVE_UP = "w";
	public static final String MOVE_DOWN = "s";
	public static final String MOVE_LEFT = "a";
	public static final String MOVE_RIGHT = "d";
	public static final String NEARBY = "n";
	public static final String QUIT = "q";
	public static final String DISPLAY_CORES = "e";

	/**
	 * Stores filenames for sounds upon entering map locations
	 */
	public static final String SOUND_INTRO = "src/sounds/boldly_go.wav";
	public static final String SOUND_KHAN = "src/sounds/khan.wav";
	public static final String SOUND_ENERGY = "src/sounds/energy.wav";
	public static final String SOUND_SPOCK = "src/sounds/spock.wav";
	public static final String SOUND_BEAM = "src/sounds/beam.wav";
	public static final String SOUND_KLINGON = "src/sounds/klingon.wav";
	public static final String SOUND_PHASER = "src/sounds/phaser.wav";
	public static final String SOUND_ALERT = "src/sounds/alert.wav";
}

/*

0) Overview of changes

"Energy core" weapon collecting feature; "Klingon" enemy battles; added control to view collected energy 
cores; generic 'nearby' text for null game locations; sounds upon entering game areas; Thread.sleep() 
to play endgame sound files.

There are 5 'things' to encounter in Star Trek: The Search for Spock -- Klingon (enemy), Khan (enemy), 
Energy Core (item), Spock (goal), and Beam (random location).

--Information on player's collected 'energy cores' are stored in the Config.ENERGY_CORES variable 
and updated by the Adventure.java enter() method. If a player encounters a Klingon with ENERGY_CORES > 0,
a "phaser battle" is triggered and the player survives; ENERGY_CORES decreases by 1.

--Thread.sleep() was necessary for the sound files to finish playing before the main code terminates upon 
fulfillment of end game conditions. As enter() returns a boolean, there is no way to distinguish
between 'good' and 'bad' game overs in the main loop. It was important for different sounds to 
play based on the unique end game conditions.

See Piazza posts @1810 and @1969 for conversation & permission from Jim Williams regarding these features.

Link to gameplay: https://youtu.be/xalLvDF-gaI


1) Configuration Example

These configuration lines may exceed 100 characters.
Each line starting with a coordinate (row,colum) gives the field/attribute values for that location in the map.
The first set of integer coordinates at the beginning of a line in this file (e.g., 8,8/size/...) is the overall
size (number of rows and number of columns) of the map to be used to create the internal map array.
The line with the 'start' name (e.g., 0,4/start/...) is the starting location of the player.

Coordinates/Name/Enter Text/Enter Result/Nearby Text/
8,8/size/This is the size of the map///
0,0/energy/You found an energy core for your phaser!/phaser/Your energy detector beeps.../
0,2/beam/ZAP! Scotty beamed you to a new location!/randomMove/In the distance, you hear: "Aye, captain."/
0,4/start////
0,7/klingon/Watch out! A Klingon surprise attack!/lose/In the distance, you hear: "vaQ! may'morgh!"/
1,5/energy/You found an energy core for your phaser!/phaser/Your energy detector beeps.../
1,6/klingon/Watch out! A Klingon surprise attack!/lose/In the distance, you hear: "vaQ! may'morgh!"/
2,2/spock/"Live long and prosper." Congratulations! You found Spock!/win/In the distance, you hear: "Vulcans never bluff..."/
2,7/energy/You found an energy core for your phaser!/phaser/Your energy detector beeps.../
3,7/beam/ZAP! Scotty beamed you to a new location!/randomMove/In the distance, you hear: "Aye, captain."/
5,0/klingon/Watch out! A Klingon surprise attack!/lose/In the distance, you hear: "vaQ! may'morgh!"/
5,5/khan/AARGH! An ambush! You submitted to the wrath of Khan!/lose/In the distance, you hear: "Revenge is a dish best served cold. It is very cold in space..."/
6,4/beam/ZAP! Scotty beamed you to a new location!/randomMove/In the distance, you hear: "Aye, captain."/
7,2/klingon/Watch out! A Klingon surprise attack!/lose/In the distance, you hear: "vaQ! may'morgh!"/
7,6/energy/You found an energy core for your phaser!/phaser/Your energy detector beeps.../
7,7/beam/ZAP! Scotty beamed you to a new location!/randomMove/In the distance, you hear: "Aye, captain."/


2) Configuration Description

Larger map; "energy core" locations for weapons; Klingon enemies instead of pits, 
which can result in "battles" which use collected energy cores; start area no longer 
has "welcome" text, which is now executed in main game loop. The other elements are 
essentially the same as in "wumpus", with Star Trek-based names and description fields.


3) writeMap Output

. - ~ - - - - ! 
- - - - - . ! - 
- - S - - - - . 
- - - - x - - ~ 
- - - - - - - - 
! - - - - K - - 
- - - - ~ - - - 
- - ! - - - . ~ 

	Character Key (as found in writeMap method):
		char beam = '~';
		char khan = 'K';
		char spock = 'S';
		char klingon = '!';
		char playerIcon = 'x';
		char energy = '.';
		char empty = '-';
		

4) Additions and Enhancements:

	Tools: 

Added "phaser" weapon (represented by collected energy cores) which can be used to 
defend against Klingons. (Khan is automatic game over.) The addition of the weapon 
allowed for a larger map and more enemies for a more "survival"-based gameplay 
experience.

	Sounds:

Added game intro sound effect, sounds representing each map entity, and a "phaser" sound 
for Klingon battles.

 */
