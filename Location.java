package main_package;

/*
 * Class to store location in the grid system.
 */
public class Location {
	
	// Locations variables
	public int x_loc;
	public int y_loc;
	
	// Constructor
	public Location(int x_loc, int y_loc) {
		this.x_loc = x_loc;
		this.y_loc = y_loc;
	}
	
	// Function to get Manhattan distance between two locations
	public int distance(Location l2) {
		return Math.abs(x_loc - l2.x_loc) + Math.abs(y_loc - l2.y_loc);
	}
	
}
