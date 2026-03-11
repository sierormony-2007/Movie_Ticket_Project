package user;


public class Manager extends Staff {

   public Manager(Staff s, double bonus) {

        super(s.getId(), s.getUsername(), s.getFullName(), s.getpassword(), s.getEmail(), s.getPhone(), s.getSalary());
    }

    @Override
    public boolean can(String action) {

        return true;
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

