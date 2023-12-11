
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserContacts {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        boolean doExit = false;
        while (!doExit) {
            // Show options if the user list is not empty
            if (!contacts.isEmpty()) {
                System.out.println("Do you want to view the list of users or add a new user? (view/add)");
                String action = scanner.nextLine();
                if ("view".equalsIgnoreCase(action)) {
                    viewUsers();
                } else if ("add".equalsIgnoreCase(action)) {
                    addUser();
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                // No users present, go straight to adding users
                addUser();
            }
            // Ask if the user would like to do another operation
            doExit = askToContinue();
        }
    }

    private static void viewUsers() {
        // Display all users
        contacts.forEach(user -> System.out.println(user.getName() + ": " + user.getNumber()));
    }

    private static void addUser() {
        // Add new user to the list
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        System.out.println("Enter number:");
        String number = scanner.nextLine();
        contacts.add(new Contact(name, number));
        System.out.println(name + " added to your contacts.");
    }

    private static boolean askToContinue() {
        // Check to exit program
        System.out.println("Do you want to close the program? (yes/no):");
        return "yes".equalsIgnoreCase(scanner.nextLine());
    }
}
