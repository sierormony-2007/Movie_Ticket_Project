
public interface IStaff {

    String getId();
    String getUsername();
    String getFullName();
    boolean isActive();
    
    boolean can(String action);
}