public class Main {
    public static void main(String[] args) {
        String path = "./src/main/resources/";
        String fileName = "Fristfile.xlsx";
        new Thread(new FileFinder(path, fileName)).start();
    }
}
