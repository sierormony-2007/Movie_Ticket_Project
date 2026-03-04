package user;

public class CashierStaff extends Staff {

    private float salary;

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

//     // Full Constructor
//     public CashierStaff(String id, String username, String password,
//                         String fullname, String email, String phone) {
//         this.id = id;
//         this.username = username;
//         this.password = password;
//         this.position = "Cashier";
//         this.fullname = fullname;
//         this.email = email;
//         this.phone = phone;
//     }

//     // Simple Constructor
//     public CashierStaff(String id, String username, String password) {
//         this(id, username, password, "", "", "");
//     }

//     // ===== Getter Methods =====
//     public String getId() { return id; }
//     public String getUsername() { return username; }
//     public String getPassword() { return password; }
//     public String getPosition() { return position; }
//     public String getFullname() { return fullname; }
//     public String getEmail() { return email; }
//     public String getPhone() { return phone; }

//     // ===== Setter Methods =====
//     public void setId(String id) {
//          if (id != null && !id.trim().isEmpty()) {
//             this.id = id;       
//         } else {
//             System.out.println("Invalid ID. It cannot be null or empty."); 
//          }
//     }
//     public void setUsername(String username) { 
//         if (username != null && !username.trim().isEmpty()) {
//             this.username = username;
//         } else {
//             System.out.println("Invalid username. It cannot be null or empty.");
//         }
//     }
//     public void setPassword(String password) { 
//         if (password != null && !password.trim().isEmpty()) {
//             this.password = password;
//         } else {
//             System.out.println("Invalid password. It cannot be null or empty.");
//         }
//     }
//     public void setFullname(String fullname) { 
//         if (fullname != null && !fullname.trim().isEmpty()) {
//             this.fullname = fullname;
//         } else {
//             System.out.println("Invalid fullname. It cannot be null or empty.");
//         }
//     }
//     public void setEmail(String email) { 
//         if (email != null && !email.trim().isEmpty()) {
//             this.email = email;
//         } else {
//             System.out.println("Invalid email. It cannot be null or empty.");
//         }
//     }
//     public void setPhone(String phone) { 
//         if (phone != null && !phone.trim().isEmpty()) {
//             this.phone = phone;
//         } else {
//             System.out.println("Invalid phone number. It cannot be null or empty.");
//         }
//     }

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