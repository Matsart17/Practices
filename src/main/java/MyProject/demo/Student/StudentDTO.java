package MyProject.demo.Student;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentDTO {
    @Pattern(regexp = "^[А-Я][а-я]+")
    private String full_name;
    @Pattern(regexp = "^[А-Я][а-я]+")
    private String address;
    @Pattern(regexp = "^\\+[0-9]{11}" ,message = "Номер должен быть введен в формате: +12223334455")
    private String phone;
    @Pattern(regexp = "^[А-Я][а-я]+")
    @Email(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", message = "Почта введена неверно")
    private String email;
    @NotNull
    private String comments;
    private String current_job;
    private String job_type;
    private String groupName;
    private String userName;


    public String getFull_name() {
        return full_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public String getJob_type() {
        return job_type;
    }

    public String getCurrent_job() {
        return current_job;
    }
}
