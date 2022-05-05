package lab;

import java.io.File;
import java.util.Scanner;

public class FilePath {
    public static void main(String[] args) {
        System.out.println("===== Analysis Path Program =====");
        System.out.println("Please input Path:");
        String path = inputString();
        File file = new File(path);

        if (file.exists() && file.isFile()) {
            System.out.println("----- Result Analysis -----");
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
            System.out.println("Folders: " + getFolders(path));
            
        } else {
            System.err.println("Path error!");
        }

    }

    private static String getDisk(String path) {
        int haiCaiXuyec = path.indexOf("\\");
        return path.substring(0, haiCaiXuyec);
    }

    private static String getExtension(String path) {
        int dauCham = path.lastIndexOf(".");
        return path.substring(dauCham + 1, path.length());
    }

    private static String getFileName(String path) {
        int from = path.lastIndexOf("\\");
        int to = path.lastIndexOf(".");
        return path.substring(from + 1, to);
    }

    private static String getPath(String path) {
        int to = path.lastIndexOf("\\");
        return path.substring(0, to);
    }

    private static String getFolders(String path) {
        int from = path.indexOf("\\");
        int to = path.lastIndexOf(".");
        path = path.substring(from, to);
        String[] folder = path.split("\\");
        return folder[folder.length - 1];
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }


}
