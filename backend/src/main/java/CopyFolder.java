import java.io.*;

public class CopyFolder {
    public static void main(String[] args) {
        File sourceFolder = new File("D:\\MultiFile");
        File destFolder = new File("E:\\MultiFileCopy");

        // 如果目标文件夹不存在，则创建
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }

        // 遍历源文件夹下的所有文件和子文件夹
        File[] files = sourceFolder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                // 如果是子文件夹，递归调用复制文件夹的方法
                copyFolder(file, new File(destFolder, file.getName()));
            } else {
                // 如果是文件，调用复制文件的方法
                copyFile(file, new File(destFolder, file.getName()));
            }
        }
        System.out.println("文件夹复制完成！");
    }

    // 复制文件夹的方法
    public static void copyFolder(File sourceFolder, File destFolder) {
        // 如果目标文件夹不存在，则创建
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }

        // 遍历源文件夹下的所有文件和子文件夹
        File[] files = sourceFolder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                // 如果是子文件夹，递归调用复制文件夹的方法
                copyFolder(file, new File(destFolder, file.getName()));
            } else {
                // 如果是文件，调用复制文件的方法
                copyFile(file, new File(destFolder, file.getName()));
            }
        }
    }

    // 复制文件的方法
    public static void copyFile(File sourceFile, File destFile) {
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}