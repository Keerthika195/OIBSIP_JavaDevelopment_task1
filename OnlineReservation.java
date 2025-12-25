import java.util.*;
class Reservation {
    String pnr;
    String name;
    String trainNumber;
    String trainName;
    String from;
    String to;
    String classType;
    String dateOfJourney;
    Reservation(String pnr, String name, String trainNumber, String trainName,
                String from, String to, String classType, String dateOfJourney) {
        this.pnr = pnr;
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.from = from;
        this.to = to;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
    }
}
class OnlineReservationSystem {
    String validUser = "user123";
    String validPass = "pass123";
    Map<String, Reservation> reservations = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    void start() {
        System.out.println("ONLINE RESERVATION SYSTEM");
        if (!login()) {
            System.out.println("Too many wrong attempts. Exiting.");
            return;
        }
        int choice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Reservation by PNR");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = readInt();
            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewReservation();
                    break;
                case 0:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);
    }
    boolean login() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter Login ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            if (id.equals(validUser) && pass.equals(validPass)) {
                System.out.println("Login successful.\n");
                return true;
            } else {
                attempts--;
                System.out.println("Wrong id or password. Attempts left: " + attempts);
            }
        }
        return false;
    }
    void makeReservation() {
        System.out.println("\n Reservation Form");
        System.out.print("Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Train Number: ");
        String trainNumber = sc.nextLine();
        String trainName = "Express " + trainNumber;
        System.out.println("Train Name (auto): " + trainName);
        System.out.print("From (place): ");
        String from = sc.nextLine();
        System.out.print("To (destination): ");
        String to = sc.nextLine();
        System.out.print("Class Type (Sleeper/3AC/2AC/etc): ");
        String classType = sc.nextLine();
        System.out.print("Date of Journey (dd-mm-yyyy): ");
        String doj = sc.nextLine();
        String pnr = generatePNR();
        Reservation r = new Reservation(pnr, name, trainNumber, trainName, from, to, classType, doj);
        reservations.put(pnr, r);
        System.out.println("\nReservation successful!");
        System.out.println("Your PNR Number: " + pnr);
    }
    void cancelReservation() {
        System.out.println("\n Cancellation Form ");
        System.out.print("Enter PNR Number: ");
        String pnr = sc.nextLine();
        Reservation r = reservations.get(pnr);
        if (r == null) {
            System.out.println("No reservation found for this PNR.");
            return;
        }
        System.out.println("\nReservation Details:");
        printReservation(r);
        System.out.print("\nAre you sure you want to cancel? (yes/no): ");
        String ans = sc.nextLine().trim().toLowerCase();
        if (ans.equals("yes")) {
            reservations.remove(pnr);
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Cancellation aborted.");
        }
    }
    void viewReservation() {
        System.out.print("\nEnter PNR Number: ");
        String pnr = sc.nextLine();
        Reservation r = reservations.get(pnr);
        if (r == null) {
            System.out.println("No reservation found for this PNR.");
        } else {
            System.out.println("\nReservation Details:");
            printReservation(r);
        }
    }
    void printReservation(Reservation r) {
        System.out.println("PNR: " + r.pnr);
        System.out.println("Name: " + r.name);
        System.out.println("Train No: " + r.trainNumber);
        System.out.println("Train Name: " + r.trainName);
        System.out.println("From: " + r.from);
        System.out.println("To: " + r.to);
        System.out.println("Class: " + r.classType);
        System.out.println("Date of Journey: " + r.dateOfJourney);
    }
    String generatePNR() {
        int num = 100000 + random.nextInt(900000); 
        return String.valueOf(num);
    }
    int readInt() {
        while (true) {
            try {
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
public class OnlineReservation {
    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.start();
    }
}
