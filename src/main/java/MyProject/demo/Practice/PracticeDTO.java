package MyProject.demo.Practice;

import MyProject.demo.Student.Student;

import java.util.Date;

public class PracticeDTO {
    private String description;
    private String relevance;
    private String director;
    private String position;
    private String work;
    private Date starting;
    private Date ending;
    private boolean reportPassed;
    private boolean futureWork;
    private boolean nextYear;
    private boolean isPayed;

    public String getDescription() {
        return description;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getDirector() {
        return director;
    }

    public String getPosition() {
        return position;
    }

    public String getWork() {
        return work;
    }

    public Date getStarting() {
        return starting;
    }

    public Date getEnding() {
        return ending;
    }

    public boolean isReportPassed() {
        return reportPassed;
    }

    public boolean isFutureWork() {
        return futureWork;
    }

    public boolean isNextYear() {
        return nextYear;
    }

    public boolean isPayed() {
        return isPayed;
    }
}
