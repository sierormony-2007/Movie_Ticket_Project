package controller;
import java.util.ArrayList;
import other.Customer;
import other.Movie;
import other.Showtime;
import other.Ticket;
import user.IStaff;
import user.Manager;
import user.Staff;

public class Cinema {

    // =========================
    // ACTION CONSTANTS
    // =========================

    //Movie actions
    public static final String CREATE_MOVIE = "CREATE_MOVIE";
    public static final String UPDATE_MOVIE = "UPDATE_MOVIE";
    public static final String DELETE_MOVIE = "DELETE_MOVIE";
    public static final String CHECK_MOVIES = "CHECK_MOVIES";
    public static final String DISPLAY_MOVIE = "DISPLAY_MOVIE";

    //showtime actions
    public static final String ADD_SHOWTIME = "ADD_SHOWTIME";
    public static final String UPDATE_SHOWTIME = "UPDATE_SHOWTIME";
    public static final String CHECK_SHOWTIME = "CHECK_SHOWTIME";
    public static final String DELETE_SHOWTIME = "DELETE_SHOWTIME";
    //Ticket actons
    public static final String SELL_TICKET = "SELL_TICKET";
    public static final String CHECK_TICKET = "CHECK_TICKET";
    public static final String CANCEL_TICKET = "CANCEL_TICKET";
    public static final String HANDLE_TICKET_ISSUE = "HANDLE_TICKET_ISSUE";
    //System
    public static final String HANDLE_SYSTEM = "HANDLE_SYSTEM";
    
    //manager
    public static final String APPROVE_BUDGET = "APPROVE_BUDGET";
    public static final String MANAGE_STAFF = "MANAGE_STAFF";
    public static final String VIEW_FINANCIAL_REPORTS = "VIEW_FINANCIAL_REPORTS";

    // =========================
    // BASIC INFO
    // =========================
    private String cinemaName;
    private String address;
   

    // =========================
    // DATA STORAGE (ArrayLists)
    // =========================
    private ArrayList<Staff> staffs = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Showtime> showtimes = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    // =========================
    // LOGIN
    // =========================
    private IStaff loggedInStaff = null;

    // =========================
    // FEEDBACK MESSAGE
    // =========================
    private String lastMessage = "";

    // =========================
    // CONSTRUCTOR
    // =========================
    public Cinema(String cinemaName, String address) {
        this.cinemaName = isBlank(cinemaName) ? "Cinema" : cinemaName.trim();
        this.address = isBlank(address) ? "Unknown" : address.trim();

        seedDefaultAdmin();

        lastMessage = "Cinema created. Default admin: admin / 1234";
    }

    // =========================
    // DEFAULT ADMIN
    // =========================
    private void seedDefaultAdmin(){
        Staff s1 = new Staff("1", "admin", "Admin User", "1234", "admin@cinema.com", "1234567890");
        Manager admin = new Manager(s1, 5000);
        staffs.add(admin);
    }

    // =========================
    // LOGIN
    // =========================
    public void staffLogin(String username, String password) {

        if (isBlank(username) || isBlank(password)) {
            lastMessage = "Login failed: missing username or password.";
            return;
        }

        for (IStaff s : staffs) {

            if (s.getUsername().equalsIgnoreCase(username.trim())) {

                    if (!s.checkPassword(password)) {
                        lastMessage = "Login failed: incorrect password.";
                        return;
                    }

                loggedInStaff = s;
                lastMessage = "Login successful. Welcome " + s.getUsername();
                return;
            }
        }

        lastMessage = "Login failed: username not found.";
    }

    public void staffLogout() {
        loggedInStaff = null;
        lastMessage = "Logged out successfully.";
    }

    private boolean requireLogin() {
        if (loggedInStaff == null) {
            lastMessage = "Action denied. Please login first.";
            return false;
        }
        return true;
    }




public IStaff getLoggedInStaff() {
    return loggedInStaff;
}

    // =========================
    // CREATE MOVIE
    // =========================
    public void createMovie(String movieId, String title, int duration) {

        if (!requireLogin()) return;

        if (isBlank(movieId)) {
    lastMessage = "Movie ID cannot be empty.";
    return;
    }

        movieId = movieId.trim();

        if (findMovieById(movieId) != null) {
            lastMessage = "Movie ID already exists.";
            return;
        }

        movies.add(new Movie(Integer.parseInt(movieId), title, (double) duration, ""));
        lastMessage = "Movie created successfully.";
        }

    // =========================
    // UPDATE MOVIE
    // =========================
    public void updateMovie(String movieId, String newTitle) {

        if (!requireLogin()) return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Movie not found.";
            return;
        }

        if (!isBlank(newTitle)) {
            movie.setTitle(newTitle);
        }

        lastMessage = "Movie updated successfully.";
    }

    // =========================
    // DELETE MOVIE
    // =========================
    public void deleteMovie(String movieId) {

        if (!requireLogin()) return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Movie not found.";
            return;
        }

        movies.remove(movie);
        lastMessage = "Movie deleted successfully.";
    }

    // =========================
    // SELL TICKET
    // =========================
    public void sellTicket(String ticketId, String movieId, String customerName) {

        if (!requireLogin()) return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Cannot sell ticket. Movie not found.";
            return;
        }

        int id = Integer.parseInt(ticketId);
        Customer customer = new Customer(customerName, "", false);
        double price = 100.0;
        tickets.add(new Ticket(id, movie, customer, price, ""));
        lastMessage = "Ticket sold successfully.";
    }

    // =========================
    // PRINT METHODS
    // =========================
    public void printMovies() {
        System.out.println("\n--- Movies (" + movies.size() + ") ---");
        for (Movie m : movies) {
            System.out.println(m);
        }
    }

    public void printTickets() {
        System.out.println("\n--- Tickets (" + tickets.size() + ") ---");
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    // =========================
    // HELPER
    // =========================
    private Movie findMovieById(String movieId) {

        if (isBlank(movieId)) return null;

        for (Movie m : movies) {
            if (m.getMovieId() == Integer.parseInt(movieId.trim())) {
                return m;
            }
        }

        return null;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    // =========================
    // GET MESSAGE
    // =========================
    public String getLastMessage() {
        return lastMessage;
    }
}