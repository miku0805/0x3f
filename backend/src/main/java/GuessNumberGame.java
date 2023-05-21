import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // 生成1-100的随机数
        int guess;
        Scanner scanner = new Scanner(System.in);

        System.out.println("请猜一个1-100之间的数字。");

        do {
            System.out.print("你的猜测是：");
            guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("恭喜你，猜中了！");
            } else if (guess < secretNumber) {
                System.out.println("猜错了，你猜的数字太小了。");
            } else {
                System.out.println("猜错了，你猜的数字太大了。");
            }
        } while (guess != secretNumber);
    }
}