package MyProject.demo.Company;


import MyProject.demo.Practice.Practice;
import MyProject.demo.Student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "organization")
    private Set<Practice> practices;
    private String orgName;
    private String orgAddress;
    private String orgPhone;
    private String orgEmail;
    private String orgContactName;
    private String orgRequirements;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgContactName() {
        return orgContactName;
    }

    public void setOrgContactName(String orgContactName) {
        this.orgContactName = orgContactName;
    }

    public String getOrgRequirements() {
        return orgRequirements;
    }

    public void setOrgRequirements(String orgRequirements) {
        this.orgRequirements = orgRequirements;
    }
}

