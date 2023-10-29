import java.io.File;

public class FileFinder implements Runnable {
    private String path;
    private String fileName;

    public FileFinder(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File element : files) {
            if (element.isFile()) {
                if (fileName.equals(element.getName())) {
                    System.out.println("File exist in : " + element.getAbsolutePath());
                }
            } else if (element.isDirectory()) {
                new Thread(new FileFinder(element.getAbsolutePath(), fileName)).start();
            }
        }
    }
}
