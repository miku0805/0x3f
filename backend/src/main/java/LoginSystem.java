import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        int attempts = 3;
        String username = "example";
        String password = "123456";

        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎登录，请输入用户名和密码。");

        while (attempts > 0) {
            System.out.print("用户名：");
            String inputUsername = scanner.nextLine();
            System.out.print("密码：");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("登录成功！");
                break;
            } else {
                attempts--;
                System.out.println("用户名或密码错误，还有" + attempts + "次机会。");
            }
        }

        if (attempts == 0) {
            System.out.println("登录失败，退出游戏。");
        }
    }
}