import java.io.*;
import java.util.*;

public class SortScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // 输入学生姓名、Java成绩
        while (true) {
            System.out.print("请输入学生姓名（输入quit停止输入）：");
            String name = scanner.nextLine();
            if (name.equals("quit")) {
                break;
            }
            System.out.print("请输入Java成绩：");
            int score = scanner.nextInt();
            scanner.nextLine(); // 消耗掉输入缓冲区中的换行符
            students.add(new Student(name, score));
        }

        // 按分数从高到低排序
        Collections.sort(students);

        // 将排序后的结果写入文件score.txt
        try {
            FileWriter writer = new FileWriter("score.txt");
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getScore() + "\n");
            }
            writer.close();
            System.out.println("成绩已保存到文件score.txt中！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
