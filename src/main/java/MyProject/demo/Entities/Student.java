package MyProject.demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password_hash;

    private String full_name;
    private String group_cipher;
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

    public String getGroup_cipher() {
        return group_cipher;
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

    public void setGroup_cipher(String groupCipher) {
        this.group_cipher = groupCipher;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + full_name + '\'' +
                ", groupCipher='" + group_cipher + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", comments='" + comments + '\'' +
                ", currentJob=" + current_job +
                ", jobType='" + job_type + '\'' +
                '}';
    }
}
