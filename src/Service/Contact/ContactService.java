package Service.Contact;

import Model.BusinessContact;
import Model.Contact;
import Model.ContactType;
import Model.PersonalContact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ContactService implements IContactService {

    private final List<Contact> contacts = new ArrayList<>();
    private final Scanner scanner;

    public ContactService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            String action = scanner.nextLine();

            switch (action) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    viewContacts();
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    deleteContactByName();
                    break;
                case "4":
                    editContact();
                    break;
                case "5":
                    searchAndPrintContactByName();
                    break;
                default:
                    printOut("Invalid option. Please try again.");
            }
        }
        closeScanner();
    }

    private void closeScanner() {
        scanner.close();
    }

    private void showMenu() {
        printOut("Select an option:");
        printOut("0. Close");
        printOut("1. View Contacts");
        printOut("2. Add Contact");
        printOut("3. Delete Contact");
        printOut("4. Edit Contact");
        printOut("5. Search by Name");
    }

    private void deleteContactByName() {
        String enterName = getUserInput("enter contact name");
        Optional<Contact> findContact = contacts.stream().filter(contact -> contact.getName().equalsIgnoreCase(enterName)).findAny();
        if(findContact.isPresent()){
            String name = getUserInput("Enter contact name:");
            contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
            printOut(name + " has been deleted.");
        }else {
            printOut("contact not found");
        }

    }

    private void editContact() {
        String contactName = getUserInput("Enter contact name to find:");
        String number = getUserInput("Enter number to find:");
        Optional<Contact> findUser = contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(contactName) && contact.getNumber().equalsIgnoreCase(number))
                .findFirst();

        findUser.ifPresentOrElse(contact -> {
            String newNumber = getUserInput("Enter new number:");
            contact.setNumber(newNumber);
            printOut("User has been modified: " + contact);
        }, () -> printOut("Contact not found. Please try again."));
    }

    private void addContact() {
        ContactType type = getContactTypeFromUser();
        String name = getUserInput("Enter contact name:");
        String number = getUserInput("Enter number:");

        if (type == ContactType.PERSONAL) {
            contacts.add(new PersonalContact(name, number));
        } else {
            String fax = getUserInput("Enter fax:");
            BusinessContact businessContact = new BusinessContact(name, number, fax);
            contacts.add(businessContact);
        }
    }

    private ContactType getContactTypeFromUser() {
        while (true) {
            try {
                return ContactType.valueOf(getUserInput("Enter contact type (PERSONAL/BUSINESS):").toUpperCase());
            } catch (IllegalArgumentException e) {
                printOut("Invalid contact type. Please enter PERSONAL or BUSINESS.");
            }
        }
    }

    private void viewContacts() {
        contacts.forEach(System.out::println);
    }

    private void searchAndPrintContactByName() {
        String name = getUserInput("Enter contact name:");
        contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }
    private void printOut(String txt){
             System.out.println(txt);
    }
    private String getUserInput(String prompt) {
        printOut(prompt);
        return scanner.nextLine();
    }
}
