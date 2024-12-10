package MyProject.demo.Student;

import MyProject.demo.Group.Group;
import MyProject.demo.Practice.Practice;
import MyProject.demo.User.MyUser;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String comments;
    private String currentJob;
    private String jobType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_group_id")
    private Group studentGroup;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private MyUser myUser;

    @OneToMany(mappedBy = "student")
    private List<Practice> practices;


    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
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

    public String getCurrentJob() {
        return currentJob;
    }

    public String getJobType() {
        return jobType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Group getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(Group student_group) {
        this.studentGroup = student_group;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myuser) {
        this.myUser = myuser;
    }
}
