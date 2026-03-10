package user;


public class Manager extends Staff {
    private float salary; 

   public Manager(String staffId, String userName, String fullName,
                   String password, String email, String phone) {

        super(staffId, userName, fullName, password, email, phone);
    }

    @Override
    public boolean can(String action) {

        return true;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary){
        if(salary<3000){
            System.out.println("Invalid salary. It must be at least 3000.");
        } else {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Manager [Position: Manager, salary=" + salary + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manager manager = (Manager) obj;
        return this.getId().equals(manager.getId());
    }
}

