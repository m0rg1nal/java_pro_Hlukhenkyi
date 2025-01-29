package hw10.app;

public class Main {
    private final static String BASE_PATH = "src/hw10/files/";

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String fileName = "file";
        String fileContent = "My very important information.";
        String result = handler.writeFile(fileName, fileContent);
        String content = handler.readFile(BASE_PATH + fileName + ".txt");
        getOutput("RESULT: " + result);
        getOutput("FILE CONTENT: " + content);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
