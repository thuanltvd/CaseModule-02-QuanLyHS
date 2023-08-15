public interface Management<T> {
    T input();
    void add();
    void search();
    void update();
    void remove();
    void displayAll();
    void saveFile();
    void readFromFile();
}
