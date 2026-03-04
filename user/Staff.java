package user;

public class Staff implements IStaff {
    private String staffId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;

@Override
public boolean can(String action) {
    return false;
}

    public Staff(String staffId, String userName, String fullName, String password, String email, String phone) {
        setStaffId(staffId);
        setUserName(userName);
        setFullName(fullName);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
    }
    protected String getpassword() {
        return password;
    }

  @Override
    public boolean isActive() {
        return true;
    }
  @Override
    public String getId() {
        return staffId;
    }
    public String getUsername() {
        return userName;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public boolean checkPassword(String input) {
        return password != null && password.equals(input);
    }
    public void setStaffId(String staffId) {
        if (staffId != null && !staffId.trim().isEmpty()) {
            this.staffId = staffId;
        } else {
            System.out.println("Invalid Staff ID. It cannot be null or empty.");
        }
    }
    public void setUserName(String userName) {
        if (userName != null && !userName.trim().isEmpty()) {
            this.userName = userName;
        } else {
            System.out.println("Invalid username. It cannot be null or empty.");
        }
    }
    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("Invalid full name. It cannot be null or empty.");
        }
    }
    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            System.out.println("Invalid password. It cannot be null or empty.");
        }
    }
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            System.out.println("Invalid email. It cannot be null or empty.");
        }
    }
    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone number. It cannot be null or empty.");
        }
    }

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
    private boolean isDigit(String str) {
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
        return "Staff{" +
                "StaffId='" + staffId + '\'' +
                ", UserName='" + userName + '\'' +
                ", FullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", Phone='" + phone + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Staff other = (Staff) obj;
        return staffId.equals(other.staffId);
    }
}
