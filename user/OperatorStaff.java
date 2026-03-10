package user;

public class OperatorStaff extends Staff {
    private float salary;


  
    public OperatorStaff(String staffId, String userName, String fullName,
                         String password, String email, String phone) {

        super(staffId, userName, fullName, password, email, phone);
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
    public float getSalary(){
        return salary;
    }
        public void setSalary(float salary){
        if(salary <200){
            System.out.println("Invalid salary. It must be at least 200.");
        } else {
            this.salary = salary;
        }
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
            if(this.salary != other.salary){
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        return super.toString() + "OperatorStaff{" +
                "salary=" + salary +
                '}';
    }


}
