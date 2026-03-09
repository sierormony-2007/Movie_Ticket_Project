package user;

import controller.Cinema;

public class OperatorStaff extends Staff {
    private float salary;


    @Override
    public boolean can(String action){
        if(action.equals(Cinema.HANDLE_SYSTEM) || action.equals(Cinema.DISPLAY_MOVIE) || action.equals(Cinema.CHECK_TICKET)){
            return true;
        }
            return false;
    };
    public OperatorStaff(Staff staff, float salary) {
        super(staff.getId(), staff.getUsername(), staff.getFullName(), staff.getpassword(), staff.getEmail(), staff.getPhone());
        this.salary=salary;
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
