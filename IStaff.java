
public interface IStaff {

    String getId();
    String getUsername();
    String getFullName();
    String getPassword();
    boolean isActive();
    
    boolean can(String action);
}