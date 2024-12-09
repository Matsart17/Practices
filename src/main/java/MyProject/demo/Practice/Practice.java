package MyProject.demo.Practice;

import MyProject.demo.Company.Organization;
import MyProject.demo.Student.Student;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "practice")
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="organization_id")
    private Organization organization;
    private String description = "Не указан";
    private String relevance = "Не указан";
    private String director = "Не указан";
    private String position = "Не указан";
    private String work = "Не указан";
    private Date starting = new Date();
    private Date ending = new Date();
    private boolean reportPassed = false;
    private boolean futureWork = false;
    private boolean nextYear = false;
    private boolean isPayed = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public boolean isReportPassed() {
        return reportPassed;
    }

    public void setReportPassed(boolean reportPassed) {
        this.reportPassed = reportPassed;
    }

    public boolean isFutureWork() {
        return futureWork;
    }

    public void setFutureWork(boolean futureWork) {
        this.futureWork = futureWork;
    }

    public boolean isNextYear() {
        return nextYear;
    }

    public void setNextYear(boolean nextYear) {
        this.nextYear = nextYear;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}

