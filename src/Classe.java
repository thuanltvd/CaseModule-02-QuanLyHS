
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classe {

    private static Pattern pattern;
    private Matcher matcher;

    private static final String CLASSNAME_REGEX =   "^C[1-5]A0[1-9]$";

    public Classe() {
        pattern = Pattern.compile(CLASSNAME_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

//    Pupilmanagement pupilmanagement = new Pupilmanagement();
    private String className;
    private String teacherName;
    private int amount;
    Scanner sc = new Scanner(System.in);

    public Classe(String className, String teacherName,int amount) {
        this.className = className;
        this.teacherName = teacherName;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    @Override
    public String toString(){
        return className+","+teacherName+","+amount;
    }


}
