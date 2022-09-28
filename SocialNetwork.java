/* Team Name	: Bug Busters
 * Team Members	: Edward Halim, Jonathan Tejakusuma
 * Midterm Part One
 */

package FinalPartOne;

import java.util.Iterator;
import java.util.Scanner;

class SocialNetwork {

	static class Profile {
		private String name;
		private String currentStatus;

		Profile(String name, String status) {
			this.name = name;
			this.currentStatus = status;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCurrentStatus() {
			return this.currentStatus;
		}

		public void setCurrentStatus(String status) {
			this.currentStatus = status;
		}

		public void addFriend(Profile friend) {
			profilesGraph.addEdge(name, friend.getName());
		}

		public void removeFriend(Profile friend) {
			profilesGraph.removeEdge(name, friend.getName());
		}

		public void print(boolean friendsOfFriends, boolean indent) {
			if (!indent) {
				System.out.println("Name: " + this.name);
				System.out.println("Status: " + this.currentStatus);
				System.out.println("Friends: ");
			}
			
			Iterator<String> it = profilesDict.getKeyIterator();
			while(it.hasNext()) {
				String entry = it.next();
				if (profilesGraph.hasEdge(this.name, entry)) {
					if (indent) {
						System.out.println("    -" + entry);
					} else {
						System.out.println(entry);
					}
					if (friendsOfFriends) {
						System.out.println("  -Friends of " + entry + ":");
						profilesDict.getValue(entry).print(false, true);
					}
				}
			}
		}
	}

	static UndirectedGraph<String> profilesGraph;

	static HashedDictionary<String, Profile> profilesDict;

	public static Profile createProfile(Profile newProfile) {
		profilesGraph.addVertex(newProfile.getName());
		profilesDict.add(newProfile.getName(), newProfile);
		return newProfile;
	}

	public static void removeProfile(String name) {
		profilesDict.remove(name);
	}

	public static Profile searchProfile(String name) {
		return profilesDict.getValue(name);
	}

	public static void showAllProfile() {
		Iterator<Profile> it = profilesDict.getValueIterator();
		while (it.hasNext()) {
			Profile entry = it.next();
			System.out.println();
			entry.print(false, false);
		}
	}

	public static void main(String[] args) {
		// Initialize Hash Table

		// Do you want to create a profile
		// System out
		// Welcome
		// What do you want to do?
		// 1. Create a profile
		// 1. Name
		// 2. Status
		// 2. Remove a profile
		// 3. Add a friend
		// 4. Remove a friend
		// 5. Search

		profilesGraph = new UndirectedGraph<>();
		profilesDict = new HashedDictionary<>();

		profilesGraph.addVertex("root");

		Profile currentProfile = null;

		Scanner input = new Scanner(System.in);
		String userInput = new String();

		while (!userInput.equals("8")) {

			System.out.println("\nWelcome to Social Network!");
			System.out.println("Choose the following actions: ");
			System.out.println("1. Create a profile");
			System.out.println("2. Remove a profile");
			System.out.println("3. Add a friend");
			System.out.println("4. Remove a friend");
			System.out.println("5. Search other profile");
			System.out.println("6. Show All Profiles.");
			System.out.println("7. Show Friends of Friends.");
			System.out.println("8. Exit");

			userInput = input.next();

			if (userInput.equals("1")) {
				System.out.println("Name?");
				String name = input.next();
				System.out.println("Current status?");
				String status = input.next();
				currentProfile = new Profile(name, status);
				createProfile(currentProfile);
				System.out.println("Created new profile for " + name);
				// newProfile.print();
			} else if (userInput.equals("2")) {
				if (currentProfile == null) {
					System.out.println("No active profile, please create a new profile to proceed.");
				} else {
					System.out.println("Do you want to remove your profile? Y/N");
					userInput = input.next();
					if (userInput.equals("Y")) {
						removeProfile(currentProfile.getName());
						currentProfile = null;
						System.out.println("Profile Removed.");
					}
				}

			} else if (userInput.equals("3")) {
				if (currentProfile == null) {
					System.out.println("No active profile, please create a new profile to proceed.");
				} else {
					System.out.println("Whats the name of the friend?");
					String name = input.next();
					if (profilesDict.contains(name)) {
						Profile friendProfile = profilesDict.getValue(name);
						currentProfile.addFriend(friendProfile);
						System.out.println("Friend Added!");
					} else {
						System.out.println("Name does not exist.");
					}
				}
			} else if (userInput.equals("4")) {
				if (currentProfile == null) {
					System.out.println("No active profile, please create a new profile to proceed.");
				} else {
					System.out.println("Whats the name of the friend?");
					String name = input.next();
					if (profilesDict.contains(name)) {
						Profile friendProfile = profilesDict.getValue(name);
						currentProfile.removeFriend(friendProfile);
						System.out.println("Friend Removed!");
					} else {
						System.out.println("Name does not exist.");
					}

				}
			} else if (userInput.equals("5")) {
				if (currentProfile == null) {
					System.out.println("No active profile, please create a new profile to proceed.");
				} else {
					System.out.println("Whats the name of the profile that you want to search?");
					String name = input.next();
					Profile searchedProfile = searchProfile(name);
					System.out.println("Showing search result: ");
					if (searchedProfile == null) {
						System.out.println("Name does not exist");
					} else {
						searchedProfile.print(false, false);
					}

				}

			} else if (userInput.equals("6")) {
				System.out.println("Showing All Profiles: ");
				showAllProfile();
			} else if (userInput.equals("7")) {
				if(currentProfile == null) {
					System.out.println("No active profile, please create a new profile to proceed.");
				} else {
					currentProfile.print(true, false);
				}
			}
		}

	}
}
