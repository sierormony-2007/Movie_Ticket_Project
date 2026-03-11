package user;

import controller.Cinema;

public class CashierStaff extends Staff {


    public CashierStaff(Staff s) {
        super(s.getId(), s.getUsername(), s.getFullName(), s.getpassword(), s.getEmail(), s.getPhone(), s.getSalary());
    }

    @Override
    public boolean can(String action) {

        if (action.equals("SELL_TICKET") ||
            action.equals("CANCEL_TICKET") ||
            action.equals("CHECK_TICKET") ||
            action.equals("CREATE_CUSTOMER") ||
            action.equals("HANDLE_TICKET_ISSUE") ||
            action.equals("CHECK_MOVIES")) {

            return true;
        }

        return false;
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
            if(this.getSalary() != getSalary()){
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        return super.toString() + "CashierStaff{" +
                "salary=" + getSalary() +
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