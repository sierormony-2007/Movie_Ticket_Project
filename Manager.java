
public class Manager extends Staff {
    private float salary;

    @Override
    public boolean can(String action) {
        // Managers can perform all actions
        return true;
    }
        public Manager(Staff staff, float salary ) {

        super(staff.getId(), staff.getUsername(), staff.getFullName(), staff.getPassword());
        this.setSalary(salary);
    }
    public float getSalary() {
        return salary;
    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }                   

    public String getPosition() {
        return "Manager";
    }

    // Setter methods
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. It cannot be null or empty.");
        }
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            System.out.println("Invalid username. It cannot be null or empty.");
        }
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            System.out.println("Invalid password. It cannot be null or empty.");
        }
    }


    public boolean can(String action) {
        // Managers can perform all actions
        return true;
    }

// Helpers
private boolean isValidString(String str) {
    return str != null && !str.trim().isEmpty();
    }
private boolean isdigit(String str) {
    if (str == null || str.trim().isEmpty()) {
        return false;
    }
    for (char c : str.toCharArray()) {
        if (!Character.isDigit(c)) {
            return false;
        }
    }
    return true;
}   



    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + getPosition() + '\'' +
                '}';
    }
}

