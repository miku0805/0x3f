import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    public static void main(String[] args) {
        // 创建班级和学生信息的双重集合
        Map<String, Map<String, Integer>> gradeMap = new HashMap<>();

        // 向双重集合中添加班级和学生信息
        Map<String, Integer> class1 = new HashMap<>();
        class1.put("张三", 20);
        class1.put("李四", 18);
        gradeMap.put("Class1", class1);

        Map<String, Integer> class2 = new HashMap<>();
        class2.put("王五", 19);
        class2.put("李二", 21);
        gradeMap.put("Class2", class2);

        // 遍历双重集合，打印班级和学生信息
        for (Map.Entry<String, Map<String, Integer>> gradeEntry : gradeMap.entrySet()) {
            System.out.println(gradeEntry.getKey());
            Map<String, Integer> classMap = gradeEntry.getValue();
            for (Map.Entry<String, Integer> studentEntry : classMap.entrySet()) {
                System.out.println("    " + studentEntry.getKey() + ":" + studentEntry.getValue());
            }
        }
    }
}