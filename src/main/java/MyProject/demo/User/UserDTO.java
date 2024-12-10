package MyProject.demo.User;

import jakarta.validation.constraints.Pattern;

public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String role;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {return role;}
}
