import java.awt.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClasseManagement classeManagement = new ClasseManagement();
        StudentManagement studentManagement = new StudentManagement();
        TestScoreManagement testScoreManagement = new TestScoreManagement();



        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0 ){
            System.out.println("=== MENU ===");
            System.out.println("1. Học Sinh");
            System.out.println("2. Lớp Học");
            System.out.println("3. Điểm Thi");
            System.out.println("0. Dừng chương trình");
            System.out.println("Nhập số: ");
            try {
                option = sc.nextInt();

            if(option == 0){
                System.out.println("Đã thoát chương trình");
                break;
            }
            switch (option){
                case 1 :
                    studentManagement.menu("Student Management:");
                    break;
                case 2 :
                    classeManagement.menu("Classe Management:");
                    break;
                case 3 :
                    testScoreManagement.menu("TestScore Management:");
                    break;
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}