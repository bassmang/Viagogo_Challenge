package main_package;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Class to model a 20 x 20 environment with x coordinates -10 to 10 and
 * y coordinates -10 to 10.  Essentially stores as map from Locations
 * to Events.
 */

public class Environment {
	
	// Environment variables.
	Map<Location, Event> events;
	int max_id;
	
	// Constructor.
	public Environment() {
		events = new HashMap<Location, Event>();
		max_id = 0;
	}
	
	// Helper function to generate random number with maximum.
	public int randInt(int max) {
		return (int) ((max + 1) * Math.random());
	}
	
	// Generate random environment.
	public void generateEnvironment() {
		int num_events = randInt(400); // Maximum number of 999 events
		// Loop through each event to set location and tickets
		for (int i = 0; i < num_events; i++) {
			/* Sets random location between -10 and 10 for x and y coordinates.
			* If there is a repeated location for an Event, it will simply
			* replace the previous Event.
			*/
			Location currLoc = new Location(randInt(20) - 10, randInt(20) - 10);
			Event currEvent = new Event(max_id);
			max_id++;
			int num_ticks = randInt(1000);
			// Loops through number of tickets adding random prices.
			for (int j = 0; j < num_ticks; j++) {
				// Prices are less at most $1000 and at least $.01
				double price = 999.99 * Math.random() + .01;
				currEvent.addTicket(price);
			}
			events.put(currLoc, currEvent);
		}
	}
	
	/* Helper class to hold events and distances, which also implements
	 * Comparable.  This is in order to store the Events with a given distance
	 * later in a PriorityQueue, so I can easily find 5 closest Events.
	 */
	class EventDist implements Comparable<EventDist>{
		Event event;
		int dist;
		
		public EventDist(Event event, int dist) {
			this.event = event;
			this.dist = dist;
		}

		// Override compareTo function to be based on distance, which will
		// be relative to the input String.
		@Override
		public int compareTo(EventDist e2) {
			return dist - e2.dist;
		}
	}
	
	// Prints out data of five closest Events
	public void printClosestEvents(String user_in) {
		String[] coords = user_in.split(",");
		Location loc = new Location(Integer.parseInt(coords[0]), 
					Integer.parseInt(coords[1])); // Input location.
		Queue<EventDist> closestEvents = new PriorityQueue<EventDist>();
		// Loops through all events, and creates an EventDist object for each.
		// Stores them in priority queue based on distances.
		for (Location currLoc : events.keySet()) {
			int currDist = loc.distance(currLoc);
			EventDist currEventDist = 
					new EventDist(events.get(currLoc), currDist);
			closestEvents.add(currEventDist);
		}
		// Finds the Events with the five shortest distances and prints them.
		for(int i = 0; i < 5; i++) {
			// Error check to end if there are less than five Events.
			if (closestEvents.isEmpty()) {
				break;
			}
			EventDist currEventDist = closestEvents.poll();
			System.out.println(String.format("%s %d", 
					currEventDist.event.eventDetails(), currEventDist.dist));
		}
	}
}
