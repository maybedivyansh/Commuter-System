import java.util.Scanner;

class CommuterSystem {
    // Data for stations and distances
    static String[] stations = {"Station A", "Station B", "Station C", "Station D", "Station E"};
    static int[] distances = {0, 5, 10, 15, 20}; // Distance from Station A

    // Display available stations
    public static void displayStations() {
        System.out.println("Available Stations:");
        for (int i = 0; i < stations.length; i++) {
            System.out.println((i + 1) + ". " + stations[i]);
        }
    }

    // Calculate ticket price based on distance and number of tickets
    public static int calculateTicketPrice(int startStation, int endStation, int numTickets) {
        int distance = Math.abs(distances[startStation - 1] - distances[endStation - 1]);
        return distance * 10 * numTickets; // 10 units per km per ticket
    }

    // Display schedule between two stations
    public static void displaySchedule(int startStation, int endStation) {
        System.out.println("Train Schedule from " + stations[startStation - 1] + " to " + stations[endStation - 1] + ":");
        System.out.println("Train 1: 08:00 AM");
        System.out.println("Train 2: 12:00 PM");
        System.out.println("Train 3: 04:00 PM");
        System.out.println("Train 4: 08:00 PM");
    }

    // Display alternative transport options
    public static void displayAlternativeTransport(int startStation, int endStation) {
        System.out.println("Alternative Transport Options from " + stations[startStation - 1] + " to " + stations[endStation - 1] + ":");
        System.out.println("1. Bus: 09:00 AM, 01:00 PM, 05:00 PM, 09:00 PM");
        System.out.println("2. Taxi: Available 24/7 (10 units per km, per person)");
        System.out.println("3. Car Rental: 500 units per day");
    }

    // Main logic for commuter system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Commuter System");
            System.out.println("1. View Stations");
            System.out.println("2. Buy Ticket");
            System.out.println("3. View Alternative Transport Options");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayStations();
                    break;

                case 2:
                    displayStations();
                    System.out.print("Enter your starting station (number): ");
                    int startStation = scanner.nextInt();

                    System.out.print("Enter your destination station (number): ");
                    int endStation = scanner.nextInt();

                    if (startStation < 1 || startStation > stations.length || endStation < 1 || endStation > stations.length || startStation == endStation) {
                        System.out.println("Invalid stations selected. Please try again.");
                    } else {
                        System.out.print("How many tickets do you want to book? ");
                        int numTickets = scanner.nextInt();

                        int price = calculateTicketPrice(startStation, endStation, numTickets);
                        displaySchedule(startStation, endStation);
                        System.out.println("Total Ticket Price for " + numTickets + " ticket(s): " + price + " units");
                        System.out.print("Do you want to purchase the ticket(s)? (yes/no): ");
                        String purchase = scanner.next();

                        if (purchase.equalsIgnoreCase("yes")) {
                            System.out.println(numTickets + " ticket(s) purchased successfully!");
                        } else {
                            System.out.println("Ticket purchase canceled.");
                        }
                    }
                    break;

                case 3:
                    displayStations();
                    System.out.print("Enter your starting station (number): ");
                    int altStartStation = scanner.nextInt();

                    System.out.print("Enter your destination station (number): ");
                    int altEndStation = scanner.nextInt();

                    if (altStartStation < 1 || altStartStation > stations.length || altEndStation < 1 || altEndStation > stations.length || altStartStation == altEndStation) {
                        System.out.println("Invalid stations selected. Please try again.");
                    } else {
                        displayAlternativeTransport(altStartStation, altEndStation);
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you for using the Commuter System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
