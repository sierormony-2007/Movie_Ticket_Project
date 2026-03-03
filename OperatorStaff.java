
public class OperatorStaff extends Staff {

    public OperatorStaff(Staff staff, float salary) {
        super(staff.getStaffId(), staff.getuserName(), staff.getfullName(), staff.getpassword(), staff.getemail(), staff.getphone());
        this.setSalary(salary);
    }



    // Setter methods
    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.setStaffId(id);
        } else {
            System.out.println("Invalid ID. It cannot be null or empty.");
        }
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.setUserName(username);
        } else {
            System.out.println("Invalid username. It cannot be null or empty.");
        }
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.setPassword(password);
        } else {
            System.out.println("Invalid password. It cannot be null or empty.");
        }
    }

}
