package user;
public class OperatorStaff extends Staff {

    

    public OperatorStaff(Staff staff, float salary) {
        super(staff.getId(), staff.getUsername(), staff.getFullName(), staff.getpassword(), staff.getEmail(), staff.getPhone());
    }

}
