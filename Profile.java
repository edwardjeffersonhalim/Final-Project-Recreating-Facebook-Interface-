package FinalPartOne;

/* Team Name	: Bug Busters
 * Team Members	: Edward Halim, Jonathan Tejakusuma
 * Midterm Part One
 */

import java.util.Iterator;

public class Profile {
	//Declare Variables
	private String name;
	private String currentStatus;
	private HashedDictionary<String, Profile> friends;
	private static DirectedGraph<String> friendsList;
	
	
	//Public Constructor
	Profile(String name, String status) {
		this.name = name;
		this.currentStatus = status;
		this.friends = new HashedDictionary<>();
		this.friendsList = new DirectedGraph<>();
	}//End profile
	
	
	//Mutator for name
	public String getName() {
		return this.name;
	}//End getName
	
	
	//Accessor for name
	public void setName(String name) {
		this.name = name;
	}//End setName
	
	//Mutator for status
	public String getCurrentStatus() {
		return this.currentStatus;
	}//End getCurrentStatus
	
	//Acessor for status
	public void setCurrentStatus(String status) {
		this.currentStatus = status;	
	}//End setCurrentStatus
	
	/*
	 * Method name	: addFriend
	 * returns		: nothing
	 */
	public void addFriend(Profile friend) {
		friends.add(friend.getName(), friend);
		friendsList.addEdge(name, currentStatus);
	}//End addFriend
	
	/*
	 * Method name	: removeFriend
	 * returns		: The profile name of friend that is removed
	 */
	public Profile removeFriend(Profile friend) {
		friendsList.clear();
		return friends.remove(friend.getName());
	}//End of removeFriend
	
	

	/*
	 * Method name	: print
	 * returns		: nothing, but prints all the details about a profile
	 */
	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("Status: " + this.currentStatus);
		System.out.println("Friends: ");
		Iterator<Profile> it = friends.getValueIterator();
		while(it.hasNext()) {
			Profile entry = it.next();
			System.out.println(entry.getName());
		}
	}//End print
} //End Class Profile
