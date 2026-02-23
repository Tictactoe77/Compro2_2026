public class Grade {

    private String subjectName;
    private double prelim;
    private double midterm;
    private double finals;

    public Grade(String subjectName, double prelim, double midterm, double finals) {
        this.subjectName = subjectName;
        this.prelim = prelim;
        this.midterm = midterm;
        this.finals = finals;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getPrelim() {
        return prelim;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getFinals() {
        return finals;
    }

    // CSV format helper
    public String toCSV() {
        return subjectName + "," + prelim + "," + midterm + "," + finals;
    }
}