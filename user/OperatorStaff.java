package user;

public class OperatorStaff extends Staff {



  
    public OperatorStaff(Staff s) {
        super(s.getId(), s.getUsername(), s.getFullName(), s.getpassword(), s.getEmail(), s.getPhone(), s.getSalary());
    }

    @Override
    public boolean can(String action) {

        if (action.equals("HANDLE_SYSTEM") ||
            action.equals("DISPLAY_MOVIE") ||
            action.equals("CHECK_TICKET")) {

            return true;
        }

        return false;
    }
     @Override
    public boolean equals(Object obj){
        OperatorStaff other = (OperatorStaff) obj;

        if(!super.equals(obj)){
            return false;
        }
        else{
            // if(Float.floatToIntBits(salary != Float.floatToIntBits(other.salary))){
            //     return false;
            // }
            if (this.getSalary() != other.getSalary()) {
            return false;
}
        }
        return true;
    }
    @Override
    public String toString() {
        return super.toString() + "OperatorStaff{" +
                "salary=" + getSalary()+
                '}';
    }


}
