import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的姓名、语文成绩、数学成绩、英语成绩（以空格隔开）：");
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int chineseScore = Integer.parseInt(input[1]);
            int mathScore = Integer.parseInt(input[2]);
            int englishScore = Integer.parseInt(input[3]);
            students.add(new Student(name, chineseScore, mathScore, englishScore));
        }

        System.out.println("姓名：\t语文成绩\t数学成绩\t英语成绩\t总分");
        for (Student student : students) {
            System.out.println(student.getName() + ":\t" + student.getChineseScore()
                    + "\t\t" + student.getMathScore() + "\t\t" + student.getEnglishScore()
                    + "\t\t" + student.getTotalScore());
        }
        Collections.sort(students);
        System.out.println("按总分从高到低排序后：");
        System.out.println("姓名：\t语文成绩\t数学成绩\t英语成绩\t总分");
        for (Student student : students) {
            System.out.println(student.getName() + ":\t" + student.getChineseScore()
                    + "\t\t" + student.getMathScore() + "\t\t" + student.getEnglishScore()
                    + "\t\t" + student.getTotalScore());
        }
    }
}