package controller;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema("CADT Cinema", "Phnom Penh");
        cinema.seedStaff();       
        cinema.demoPolymorphism(); 

        int choice;

        do {

            if (cinema.getLoggedInStaff() == null) {

                printMainMenu();

                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: { // Login
                        System.out.print("Username: ");
                        String username = sc.nextLine();

                        System.out.print("Password: ");
                        String password = sc.nextLine();

                        cinema.staffLogin(username, password);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 2: { // View Movies
                        cinema.printMovies();
                        break;
                    }

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } else {

                printStaffMenu(cinema);

                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: { // Create Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Duration (minutes): ");
                        int duration = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Release Date: ");
                        String releaseDate = sc.nextLine();

                        System.out.print("Genre: ");
                        String genre = sc.nextLine();

                        cinema.createMovie(movieId, title, duration, releaseDate, genre);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 2: { // Update Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("New Title: ");
                        String newTitle = sc.nextLine();

                        cinema.updateMovie(movieId, newTitle);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 3: { // Delete Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        cinema.deleteMovie(movieId);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 4: { // Sell Ticket
                        System.out.print("Ticket ID: ");
                        String ticketId = sc.nextLine();

                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("Customer Name: ");
                        String customerName = sc.nextLine();

                        cinema.sellTicket(ticketId, movieId, customerName);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 5: { // View Movies
                        cinema.printMovies();
                        break;
                    }

                    case 6: { // View Tickets
                        cinema.printTickets();
                        break;
                    }

                    case 7: { // Logout
                        cinema.staffLogout();
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } while (choice != 0);

        sc.close();
    }

    // =========================
    // MENUS
    // =========================
    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU (Not Logged In) ===");
        System.out.println("1) Staff Login");
        System.out.println("2) View Movies");
        System.out.println("0) Exit");
    }

    private static void printStaffMenu(Cinema cinema) {
        System.out.println("\n=== STAFF MENU (Logged In) ===");
        System.out.println("Logged in staff: " + cinema.getLoggedInStaff());
        System.out.println("1) Create Movie");
        System.out.println("2) Update Movie");
        System.out.println("3) Delete Movie");
        System.out.println("4) Sell Ticket");
        System.out.println("5) View Movies");
        System.out.println("6) View Tickets");
        System.out.println("7) Logout");
        System.out.println("0) Exit");
    }
}