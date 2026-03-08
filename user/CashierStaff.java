package user;

import controller.Cinema;

public class CashierStaff extends Staff {

    private float salary;

    @Override
    public boolean can(String action){
        if(action.equals(Cinema.CHECK_MOVIES) || action.equals(Cinema.SELL_TICKET) || action.equals(Cinema.CHECK_TICKET) || action.equals(Cinema.CANCEL_TICKET) || action.equals(Cinema.HANDLE_TICKET_ISSUE) || action.equals(Cinema.CREATE_CUSTOMER)){
            return true;
        }return false;
    };
    public CashierStaff(Staff staff1,float salary) {
        super(staff1.getId(), staff1.getUsername(), staff1.getFullName(), staff1.getpassword(), staff1.getEmail(), staff1.getPhone ());
        this.salary = salary;
    }
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary){
        if(salary <150){
            System.out.println("Invalid salary. It must be at least 150.");
        } else {
            this.salary = salary;
        }
    }
    @Override
    public boolean equals(Object obj){
        CashierStaff other = (CashierStaff) obj;

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
        return super.toString() + "CashierStaff{" +
                "salary=" + salary +
                '}';
    }
}



//     // ===== Permission Method =====
//     public boolean can(String action) {
//         if (action == null) return false;

//         return action.equals(Cinema.SELL_TICKET)
//                 || action.equals(Cinema.CHECK_TICKET);
//     }

//     // ===== Helper Function =====
//     public void updateContactInfo(String email, String phone) {
//         this.email = email;
//         this.phone = phone;
//     }

//     // ===== toString Method =====
//     @Override
//     public String toString() {
//         return "CashierStaff{" +
//                 "id='" + id + '\'' +
//                 ", username='" + username + '\'' +
//                 ", fullname='" + fullname + '\'' +
//                 ", email='" + email + '\'' +
//                 ", phone='" + phone + '\'' +
//                 ", position='" + position + '\'' +
//                 '}';
//     }
// }