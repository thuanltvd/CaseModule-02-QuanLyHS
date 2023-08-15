import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class StudentManagement extends Menu implements Management{

    List<Student> studentList;

    public StudentManagement(){
        studentList = new ArrayList<>();
        readFromFile();
    }

    @Override
    public Student input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã HS: ");
        String studentId = sc.nextLine();
        System.out.println("Nhập Họ và Tên: ");
        String fullName =  sc.nextLine();
        System.out.println("Nhập Ngày Sinh: ");
        String dob = sc.nextLine();

        return new Student(studentId,fullName,dob);
    }

    @Override
    public void add() {
        Student student = input();
        studentList.add(student);
        saveFile();
    }

    public Student searchById(String searchId){

//        for(int i = 0;i < studentList.size(); i++ ){
//            if(studentList.get(i).getStudentId() == searchId){
//                return studentList.get(i);
//            }
        for(Student student : studentList){
            if((student.getStudentId()).equals(searchId)){
                return student;
            }
        }
        return null;
    }
    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên cần tìm");
        String search = sc.nextLine();
        List<Student> studentList1 = new ArrayList<>();
        for(Student student : studentList) {
            if(student.getStudentId().contains(search)){
                studentList1.add(student);
            }
        }
        if(studentList1.equals(0)){
            System.out.println("HS không tồn tại");
        }else{
            System.out.println("studentList: "+studentList1);
        }
    }

//    @Override
//    public void update() {
//        Scanner sc = new Scanner(System.in);
////        Student searchName = searchById(searchId);
//        System.out.println("Nhập ID cần update");
//        String searchId = sc.nextLine();
//        for (int i =0; i<studentList.size(); i++){
//            Student student = studentList.get(i);
//            student.getStudentId();
//            System.out.println(student.getStudentId());
//            if(searchId.equals(student.getStudentId())) {
//                Student student1 = new Student();
//                System.out.println("Nhập tên update: ");
//                String nameUpdate = sc.nextLine();
//                student1.setFullName(nameUpdate);
//                studentList.set(i, student1);
//            }
//        }
////            for (int i = 0; i < studentList.size(); i++) {
////                Student student = studentList.get(i);
////                if (student.getStudentId().equals(searchId)) {
////                    Student student1 = new Student();
////                    System.out.println("Nhập tên update: ");
////                    String nameUpdate = sc.nextLine();
////                    student1.setFullName(nameUpdate);
////                    studentList.set(i, student1);
////                    return;
////                }
////            }
//        }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần update: ");
        String name = sc.nextLine();
        Student a = searchById(name);
        for(Student student : studentList){
//            System.out.println(student.getStudentId());
            if(a.equals(student)){
                System.out.println("Nhập tên cần update: ");
                String nameUpdate = sc.nextLine();
                a.setFullName(nameUpdate);
                System.out.println(studentList);
//            }else {
//                System.out.println("Nhập sai");
            }
        }
        saveFile();
    }
    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID cần tìm:");
        String searchID = sc.nextLine();
        Student searchName = searchById(searchID);
        if(searchName != null){
            studentList.remove(searchName);
            System.out.println("Tên HS đã bị xóa");
        }else
            System.out.println("tên HS không tồn tại");
        saveFile();
    }

    @Override
    public void displayAll() {
        for(Student student : studentList){
            System.out.println("Danh sách HS: " + student);
        }
    }

    @Override
    public void saveFile() {
        try{
            FileWriter fileWriter = new FileWriter("DanhsachHS.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Student student : studentList){
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            System.out.println("không ghi được file");
            e.printStackTrace();
//        } finally {
//            System.out.println();
        }
    }

    @Override
    public void readFromFile() {
        try{
            FileInputStream fileInputStream = new FileInputStream("DanhsachHS.csv");
            Scanner sc = new Scanner(fileInputStream);
            String s ;
            String[] line;
            while (sc.hasNextLine()){
                s = sc.nextLine();
                line= s.split(",");
                Student st = new Student(line[0],line[1],line[2]);
                studentList.add(st);
            }
            fileInputStream.close();
//        }catch (FileNotFoundException e){
//            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
