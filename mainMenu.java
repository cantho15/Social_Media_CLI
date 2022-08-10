import java.util.ArrayList;
import java.util.Scanner;
public class mainMenu{
    public static void main(String[] args) {
        ArrayList<Friend> globalFriendList = new ArrayList<Friend>();
        globalFriendList.add(new Friend(21, "bob", "male", "bobbyboy"));
        globalFriendList.add(new Friend(20, "jake", "male", "jakethegreat"));
        globalFriendList.add(new Friend(19, "penny", "female", "penny201"));
        globalFriendList.add(new Friend(21, "alex", "female", "alexab2"));
        globalFriendList.add(new Friend(16, "james", "male", "jamesjames"));
        ArrayList<Friend> friendList = new ArrayList<Friend>();
        Scanner scan = new Scanner(System.in);
        int input;
        ArrayList<Friend> unknownFriendsList = new ArrayList<Friend>();
            // create copy arraylist with only usernames of friends not yet added
            if (friendList.size() == 0) {
                for (int i = 0; i < globalFriendList.size(); i++) {
                    unknownFriendsList.add(globalFriendList.get(i));
                }
            } else {
                for (int i = 0; i < globalFriendList.size(); i++) {
                    for (int j = 0; j < friendList.size(); j++) {
                        if (!globalFriendList.get(i).equals(friendList.get(j))) {
                            unknownFriendsList.add(globalFriendList.get(i));
                        }
                    }
                }
            }
        do {
            System.out.println("\nMenu:");
            System.out.println("1) Add friend");
            System.out.println("2) Remove friend");
            System.out.println("3) View friends");
            System.out.println("4) Exit");

            input = scan.nextInt();
            scan.nextLine(); // filled automatically
                if (input == 1) {
                    // list available friends to add
                    System.out.println("Available friends to add:");
                    for (int i = 0; i < unknownFriendsList.size(); i++) {
                        System.out.println(unknownFriendsList.get(i).username);
                    }

                    System.out.print("enter the username of the friend you want to add: ");
                    String newFriend = scan.nextLine();
                    System.out.println(newFriend);

                    for(int i = 0; i < unknownFriendsList.size(); i++) {
                        //check to see if friend inputted can bee added
                        if (newFriend.equals(unknownFriendsList.get(i).username)) {
                            friendList.add(unknownFriendsList.get(i));
                            System.out.println("You added " + unknownFriendsList.get(i) + " from your friends list");
                            unknownFriendsList.get(i).sayHi();
                            unknownFriendsList.remove(i);
                            break;
                        }
                        if (i == unknownFriendsList.size()-1) {
                            System.out.println("Friend not found. Try again.");
                        }
                    }

                } else if (input == 2) {
                    //list friends
                    for(int i = 0; i < friendList.size(); i++) {
                        System.out.println(friendList.get(i).username);
                    }
                    //remove friend
                    System.out.println("Choose a friend to remove");
                    String removed = scan.nextLine();
                    for(int i = 0; i < friendList.size(); i++) {
                        // System.out.println("Iteration count is "+(i+1)+". Friend being checked is "+ globalFriendList.get(i));
                        if (removed.equals(friendList.get(i).username)) {
                            unknownFriendsList.add(friendList.get(i));
                            System.out.println("You removed " + friendList.get(i) + " from your friends list"); 
                            friendList.remove(i);
                            break;
                        }
                        if (i == friendList.size()-1) {
                            System.out.println("Friend not found. Try again.");
                        }
                    }
                } else if (input == 3) {
                    for(int i = 0; i < friendList.size(); i++){
                        System.out.println(friendList.get(i).username);
                    }
                } 
        } while (input != 4);
        scan.close();
    }
}
