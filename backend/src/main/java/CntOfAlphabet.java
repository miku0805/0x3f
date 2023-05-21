import java.util.*;

public class CntOfAlphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String input = scanner.nextLine();

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            resultBuilder.append(ch).append("(").append(count).append(")");
        }
        String result = resultBuilder.toString();

        System.out.println(result + ":" + result);
    }
}