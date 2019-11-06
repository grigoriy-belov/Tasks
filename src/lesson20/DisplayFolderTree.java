package lesson20;

import java.io.File;
import java.util.Objects;

public class DisplayFolderTree {

    public static void main(String[] args) {
        File folder = new File(args[0]);
        System.out.println(printFolderTree(folder));
    }

    public static String printFolderTree(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printFolderTree(folder, indent, sb);
        return sb.toString();
    }

    private static void printFolderTree(File folder, int indent, StringBuilder sb) {

        if (indent == 0) {
            sb.append(folder.getName());
            sb.append("\n");
        } else {
            printFile(folder, indent, sb);
        }

        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()) {
                printFile(file, indent + 1, sb);
            } else if (file.isDirectory()) {
                printFolderTree(file, indent + 1, sb);
            }
        }
    }

    private static void printFile(File file, int indent, StringBuilder sb) {
        printIndentString(indent, sb);
        sb.append("+---");
        sb.append(file.getName());
        sb.append("\n");
    }

    private static void printIndentString(int indent, StringBuilder sb) {
        sb.append("+\t".repeat(Math.max(0, indent - 1)));
    }
}

