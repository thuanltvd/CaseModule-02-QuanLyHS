public class TestScore {
    private int id;
    private String studentId;
    private String subjects;
    private double score;

    public TestScore() {
    }

    public TestScore(int id, String studentId, String subjects, double score) {
        this.id = id;
        this.studentId = studentId;
        this.subjects = subjects;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString1(){
        return id +" , " + studentId +" , "+subjects +" , "+score;
    }

    @Override
    public String toString() {
        return "MS Diem: "+ id + " MSHS: "+ studentId + " Mon hoc: "+subjects+ " Diem: "+score;
    }
}
