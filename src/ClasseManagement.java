import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasseManagement extends Menu implements Management{

    List<Classe> classeList;

    public ClasseManagement(){
        classeList = new ArrayList<>();
        readFromFile();
    }

    @Override
    public Classe input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã Lớp học");
        String className = sc.nextLine();
        System.out.println("Nhập Tên giáo viên: ");
        String classTeacher = sc.nextLine();
        System.out.println("sỉ số HS của lớp");
        int amount = sc.nextInt();

        return new Classe(className,classTeacher,amount);
    }

    @Override
    public void add() {
        try{
            Classe classe = input();
            classeList.add(classe);
        }catch (Exception e){
            System.out.println("Lỗi nhập liệu");
            e.printStackTrace();
        }

        saveFile();
    }

    public Classe searchById(String searchId){
        for(Classe classe : classeList){
            if(classe.getClassName().equals(searchId)){
                return classe;
            }
        }
        return null;
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã lớp học cần tìm: ");
        String search = sc.nextLine();
        List<Classe> classes = new ArrayList<>();
        for(Classe classe : classeList){
            if(classe.getClassName().contains(search)){
                classes.add(classe);
            }
        }
        System.out.println("classeList: "+classes);
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần update: ");
        String search = sc.nextLine();
        Classe searchName = searchById(search);
        if(searchName != null){
            System.out.println("Update name");
            String nameUpdate = sc.nextLine();
            searchName.setClassName(nameUpdate);
            System.out.println(searchName.toString());
        }else {
            System.out.println("Tên lớp không tồn tại");
        }
        saveFile();
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Id cần xóa: ");
        String searchId = sc.nextLine();
        Classe searchName = searchById(searchId);
        if(searchName != null){
            classeList.remove(searchName);
            System.out.println("Tên lớp học đã được xóa");
        }else {
            System.out.println("Tên lớp học không tồn tại");
        }
        saveFile();
    }

    @Override
    public void displayAll() {
        for(Classe classe : classeList){
            System.out.println("Danh sách lớp học: "+classe);
        }
    }

    @Override
    public void saveFile() {
        try{
            FileWriter fileWriter = new FileWriter("DSLopHoc.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Classe classe : classeList){
                bufferedWriter.write(classe.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        }catch (IOException e){
            System.out.println("khong ghi dc file");
            e.printStackTrace();
        }finally {
            System.out.println();
        }
    }

    @Override
    public void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("DSLopHoc.csv");
            Scanner sc = new Scanner(fileInputStream);
            String s ;
            String[] line;
            while (sc.hasNextLine()){
                s = sc.nextLine();
                line = s.split(",");
                Classe c = new Classe(line[0],line[1],Integer.parseInt(line[2]));
                classeList.add(c);
            }
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
