public class Student {
    private String studentId;
    private String fullName;
    private String dob;

    public Student() {
    }

    public Student(String studentId, String fullName, String dob) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dob = dob;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String toString1(){
        return "MSHS: "+ studentId + " Họ và Tên: "+ fullName + " Ngày sinh: "+ dob;
    }
    @Override
    public String toString(){
        return studentId+","+fullName+","+dob;
    }
}
