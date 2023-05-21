import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class RegisterProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");

        int captcha = random.nextInt(100) + 1;

        System.out.println("欢迎注册，请输入用户名、密码和验证码。");
        System.out.print("用户名：");
        String username = scanner.nextLine();
        System.out.print("密码：");
        String password = scanner.nextLine();
        System.out.print("验证码（1-100的数字）：" + captcha + "，请输入：");
        int inputCaptcha = scanner.nextInt();

        if (!username.matches("[a-zA-Z]+")) {
            System.out.println("用户名必须为字母！");
            return;
        }

        if (password.length() < 6 || password.length() > 22 || password.matches("^[a-zA-Z].*")) {
            System.out.println("密码必须为6-22位字母或数字，且不能以字母开头！");
            return;
        }

        if (inputCaptcha != captcha) {
            System.out.println("验证码错误！");
            return;
        }

        Date now = new Date();
        System.out.println("注册成功！您的注册时间是：" + sdf.format(now));
    }
}