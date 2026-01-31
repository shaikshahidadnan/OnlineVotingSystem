package OnlineVoting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OnlineVotingSystem {

    static Scanner sc = new Scanner(System.in);

    // Store candidates and votes
    static Map<Integer, String> candidates = new HashMap<>();
    static Map<Integer, Integer> voteCount = new HashMap<>();

    // Store voters who already voted
    static Set<Integer> votedUsers = new HashSet<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        int choice;
		        do {
		            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
		            System.out.println("1. Admin Login");
		            System.out.println("2. Voter Login");
		            System.out.println("3. View Results");
		            System.out.println("4. Exit");
		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    adminPanel();
		                    break;
		                case 2:
		                    voterPanel();
		                    break;
		                case 3:
		                    displayResults();
		                    break;
		                case 4:
		                    System.out.println("Thank you for using Online Voting System!");
		                    break;
		                default:
		                    System.out.println("Invalid choice!");
		            }
		        } while (choice != 4);
		    }

		    // Admin Panel
		    static void adminPanel() {
		        System.out.print("Enter Admin Password: ");
		        String password = sc.next();

		        if (password.equals("admin123")) {
		            System.out.print("How many candidates to add? ");
		            int n = sc.nextInt();

		            for (int i = 1; i <= n; i++) {
		                System.out.print("Enter candidate ID: ");
		                int id = sc.nextInt();
		                sc.nextLine();
		                System.out.print("Enter candidate name: ");
		                String name = sc.nextLine();

		                candidates.put(id, name);
		                voteCount.put(id, 0);
		            }
		            System.out.println("Candidates added successfully!");
		        } else {
		            System.out.println("Wrong password!");
		        }
		    }

		    // Voter Panel
		    static void voterPanel() {
		        if (candidates.isEmpty()) {
		            System.out.println("No candidates available!");
		            return;
		        }

		        System.out.print("Enter your Voter ID: ");
		        int voterId = sc.nextInt();

		        if (votedUsers.contains(voterId)) {
		            System.out.println("You have already voted!");
		            return;
		        }

		        System.out.println("\n--- Candidates List ---");
		        for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
		            System.out.println(entry.getKey() + " : " + entry.getValue());
		        }

		        System.out.print("Enter candidate ID to vote: ");
		        int vote = sc.nextInt();

		        if (candidates.containsKey(vote)) {
		            voteCount.put(vote, voteCount.get(vote) + 1);
		            votedUsers.add(voterId);
		            System.out.println("Vote cast successfully!");
		        } else {
		            System.out.println("Invalid candidate ID!");
		        }
		    }

		    // Display Results
		    static void displayResults() {
		        if (voteCount.isEmpty()) {
		            System.out.println("No votes yet!");
		            return;
		        }

		        System.out.println("\n--- Voting Results ---");
		        for (Map.Entry<Integer, Integer> entry : voteCount.entrySet()) {
		            System.out.println(
		                candidates.get(entry.getKey()) + " : " + entry.getValue() + " votes"
		            );
		        }

	}

}
