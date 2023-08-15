import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScoreManagement extends Menu implements Management{

    List<TestScore> testScoreList;

    public TestScoreManagement(){
        testScoreList = new ArrayList<>();
        readFromFile();
    }

    public TestScore searchById(String searchId){
        for(TestScore testScore : testScoreList){
            if(String.valueOf(testScore.getId()).equals(searchId)){
                return testScore;
            }
        }
        return null;
    }

    @Override
    public TestScore input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập MS: ");
        String id = sc.nextLine();
        System.out.println("nhập MSHS: ");
        String studentId = sc.nextLine();
        System.out.println("Nhập Môn thi: ");
        String subjects = sc.nextLine();
        System.out.println("Nhập điểm thi: ");
        String score = sc.nextLine();

        return new TestScore(Integer.parseInt(id),studentId,subjects,Double.parseDouble(score));
    }

    @Override
    public void add() {
        try{
        TestScore testScore = input();
        testScoreList.add(testScore);
        }catch (Exception e){
            System.out.println("Lỗi nhập liệu");
            e.printStackTrace();
        }
        finally {
            System.out.println("nhập lại");
        }
        saveFile();
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm: ");
        String searchName = sc.nextLine();
        List<TestScore> testScoreList1 = new ArrayList<>();
        for(TestScore testScore : testScoreList){
            if(testScore.getStudentId().contains(searchName)){
                testScoreList1.add(testScore);
            }
        }
        System.out.println("testScoreList: "+ testScoreList1);
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần update: ");
        String searchId = sc.nextLine();
        TestScore searchName = searchById(searchId);
        if(searchName != null){
            System.out.println("update Tên HS : ");
            String nameUpdate = sc.nextLine();
            searchName.setStudentId(nameUpdate);
            String nameSubjects = sc.nextLine();
            searchName.setSubjects(nameSubjects);
            System.out.println(searchName.toString1());
        }else {
            System.out.println("Điểm thi này không tồn tại");
        }
        saveFile();
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập Id cần Xóa: ");
        String searchId = sc.nextLine();
        TestScore searchName = searchById(searchId);
        if(searchName != null){
            testScoreList.remove(searchName);
            System.out.println("Điểm thi của HS đã được xóa");
        }else {
            System.out.println("Điểm thi HS đó không tồn tại");
        }
        saveFile();
    }

    @Override
    public void displayAll() {
        for(TestScore testScore : testScoreList){
            System.out.println("TestScore: "+ testScore);
        }
    }
    @Override
    public void saveFile() {
        try{
            FileWriter fileWriter = new FileWriter("DiemThi.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(TestScore testScore : testScoreList){
                bufferedWriter.write(testScore.toString1());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            System.out.println("không lưu được file");
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile() {
        try{
            FileInputStream fileInputStream = new FileInputStream("DiemThi.csv");
            Scanner sc = new Scanner(fileInputStream);
            String s;
            String[] line;
            while (sc.hasNextLine()){
                s = sc.nextLine();
                line = s.split(" , ");
                TestScore ts = new TestScore(Integer.parseInt(line[0]),line[1],line[2],Double.parseDouble(line[3]));
                testScoreList.add(ts);
            }
            fileInputStream.close();
        }catch (NumberFormatException n){
            System.out.println("Gia tri không hợp lệ");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
