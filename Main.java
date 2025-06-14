package exercise1.guestListApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Guest> arrayList = new ArrayList<>();
        System.out.println("Please make choice");

        while (true) {
            System.out.println("1 - Add guest ");
            System.out.println("2 - See all guests");
            System.out.println("3 - Search guest");
            System.out.println("4 - Delete guest");
            System.out.println("5 - Exit");

            System.out.print("Your choice: ");

            int choice;

            try {
                choice = scanner.nextInt();

                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please add only 1-5");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Add guest");
                    String guestName = scanner.nextLine();
                    Guest guest = new Guest(guestName);
                    arrayList.add(guest);
                    System.out.println("Guest is: " + guest.getName());
                    break;

                case 2:
                    System.out.println("See all guests");
                    if (arrayList.isEmpty()) {
                        System.out.println("There is no guest on list");
                    } else {
                        for (Guest g : arrayList) {
                            System.out.println("Guests list is " + g.getName());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Add guest name for searching");
                    String searchName = scanner.nextLine();

                    boolean isConfirmed = false;
                    for (Guest g : arrayList) {
                        if (searchName.equalsIgnoreCase(g.getName())) {
                            System.out.println("the guest you are looking for: " + g.getName());
                            isConfirmed = true;
                        }
                    }
                    if (!isConfirmed) {
                        System.out.println("The guest you are looking for is not on the list.");
                    }
                    break;

                case 4:
                    System.out.println("Input guest name for deleting");
                    String deleteGuest;
                    try {
                        deleteGuest = scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Please write 1-5 digit only");
                        continue;
                    }
                    Guest guestToRemove = null;

                    for (Guest g : arrayList) {
                        if (g.getName().equals(deleteGuest)) {
                            g = guestToRemove;
                            break;
                        }
                    }
                    if (guestToRemove != null) {
                        arrayList.remove(guestToRemove);
                        System.out.println("Guest successfully deleted");
                    } else {
                        System.out.println("Guest not found");
                    }
                    break;

                case 5:
                    System.out.println("Exit the program");
                    break;
                default:
                    System.out.println("Please write only 1-5");
            }
        }
    }
}
