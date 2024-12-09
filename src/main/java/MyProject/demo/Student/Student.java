package MyProject.demo.Student;

import MyProject.demo.Group.Group;
import MyProject.demo.Practice.Practice;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password_hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_group_id")
    private Group student_group;
//, nullable = false
    @OneToMany(mappedBy = "student")
    private List<Practice> practices;

    private String full_name;
    private String address;
    private String phone;
    private String email;
    private String comments;
    private String current_job;
    private String job_type;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String passwordHash) {
        this.password_hash = passwordHash;
    }

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

    public String getCurrent_job() {
        return current_job;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFull_name(String fullName) {
        this.full_name = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCurrent_job(String currentJob) {
        this.current_job = currentJob;
    }

    public void setJob_type(String jobType) {
        this.job_type = jobType;
    }
}
