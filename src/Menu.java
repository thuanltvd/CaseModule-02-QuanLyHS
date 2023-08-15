import java.util.Scanner;

public abstract class Menu implements Management{

    public void Menu(String a) {
        System.out.println("DS: "+ a);
        System.out.println("1: Student");
        System.out.println("1: Classe");
        System.out.println("3: TestScore");
    }

    public void showMenu(String displayMenu) {
        System.out.println("Danh Sách Của MENU: " + displayMenu);
        System.out.println("1. Add");
        System.out.println("2. Search");
        System.out.println("3. Update");
        System.out.println("4. Remove");
        System.out.println("5. Display");
        System.out.println("6. Save to File");
        System.out.println("7. Read from File");
        System.out.println("0. Exit");
        System.out.println("-1. Dừng chương trình");
        System.out.println("Enter option: ");
    }

    public void menu(String displayMenu) {
        Scanner sc = new Scanner(System.in);
        while (true) {
//            Menu(a);
            showMenu(displayMenu);
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 0){
                break;
            } else if (choice == -1) {
                System.exit(00);
            }
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    readFromFile();
                    break;
                case 0:
//                    showMenu(displayMenu);
                    break;
//                case 00:
//                    showMenu(menu());
//                    break;
                default:
                    System.out.println("ban nhap sai, ban hay nhap lai");
                    break;
            }
        }
    }
}

