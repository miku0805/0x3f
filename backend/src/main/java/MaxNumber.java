import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> dataList = new ArrayList<>();

        System.out.println("请逐个输入数据，以-1结束：");
        while (true) {
            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            dataList.add(input);
        }

        System.out.print("您输入的数据为：");
        for (int i = 0; i < dataList.size(); i++) {
            if (i == dataList.size() - 1) {
                System.out.print(dataList.get(i));
            } else {
                System.out.print(dataList.get(i) + ", ");
            }
        }
        System.out.println();

        int max = Collections.max(dataList);
        System.out.println("最大值为：" + max);
    }
}