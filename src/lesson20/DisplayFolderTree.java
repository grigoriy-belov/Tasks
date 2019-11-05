package lesson20;

import java.io.File;

public class DisplayFolderTree {


    public static void main(String[] args) {
        DisplayFolderTree displayFolderTree = new DisplayFolderTree();
        File folder = new File(args[0]);
        System.out.println(displayFolderTree.printDirectoryTree(folder));
    }

    public static String printDirectoryTree(File folder) {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(folder, indent, sb);
        return sb.toString();
    }

    private static void printDirectoryTree(File folder, int indent, StringBuilder sb) {

        if (indent == 0) {
            sb.append(folder.getName());
            sb.append("\n");
        } else {
            sb.append(getIndentString(indent));
            sb.append("+---");
            sb.append(folder.getName());
            sb.append("\n");
        }

        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                printDirectoryTree(file, indent + 1, sb);
            } else {
                printFile(file, indent + 1, sb);
            }
        }
    }

    private static void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+---");
        sb.append(file.getName());
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        if (indent > 1) {
            sb.append("+\t".repeat(indent));
        }
        return sb.toString();
    }
}

