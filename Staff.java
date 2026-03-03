
public class Staff implements IStaff {
  private int staffId;
  private String username;
  private String fullName;
  private String password;
  private boolean Active;

@Override
public boolean can(String action) {
    return false;
}

    public Staff(int staffId, String username, String fullName, String password, boolean active, double salary, String position) {
        setID(staffId);
        setUsername(username);
        setFullName(fullName);
        setPassword(password);
        
        this.Active = true;
    }

    protected String getPassword(){
        return password;
    }

    public int getId() {
        return staffId;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }
    public String getPassword(){
        return password;
    }

}
