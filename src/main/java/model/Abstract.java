package model;

public class Abstract {
    private String details;
    private String parental_advisory;

    public Abstract() {
    }

    public Abstract(String details, String parental_advisory) {
        this.details = details;
        this.parental_advisory = parental_advisory;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getParental_advisory() {
        return parental_advisory;
    }

    public void setParental_advisory(String parental_advisory) {
        this.parental_advisory = parental_advisory;
    }

    @Override
    public String toString() {
        return "Abstract{" +
                "details='" + details + '\'' +
                ", parental_advisory='" + parental_advisory + '\'' +
                '}';
    }
}
