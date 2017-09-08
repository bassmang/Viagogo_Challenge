package main_package;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Class to store Event details.  Holds a unique Event id and a PriorityQueue
 * of tickets at this Event.
 */

public class Event {
	
	// Event variables
	Queue<Double> tickets;
	public int id;
	
	// Constructor
	public Event(int id) {
		tickets = new PriorityQueue<Double>();
		this.id = id;
	}
	
	// Function to add ticket to event
	public void addTicket(double price) {
		tickets.add(price);
	}
	
	// Function to get formatted string with event id and cheapest ticket
	public String eventDetails() {
		Double minTick = tickets.peek();
		return String.format("Event %03d - $%.2f, Distance", id, minTick);
	}
	
}
