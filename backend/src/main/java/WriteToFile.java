import java.io.*;

public class WriteToFile {
	public static void main(String[] args) {
		try {
			// 写入图案
			FileWriter writer = new FileWriter("D:\\test.txt");
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= i; j++) {
					writer.write("*");
				}
				writer.write("\n");
			}
			writer.close();

			// 追加文字
			BufferedWriter out = new BufferedWriter(new FileWriter("D:\\test.txt", true));
			out.write("一闪一闪亮晶晶");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}