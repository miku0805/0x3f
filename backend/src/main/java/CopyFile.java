import java.io.*;

public class CopyFile {
	public static void main(String[] args) {
		File source = new File("D:\\bbb.mp4");
		File dest = new File("copy.mp4");

		long start, end;

		try {
			// 使用FileInputStream的read()方法复制文件
			FileInputStream fis1 = new FileInputStream(source);
			FileOutputStream fos1 = new FileOutputStream(dest);
			start = System.currentTimeMillis();
			int len;
			while ((len = fis1.read()) != -1) {
				fos1.write(len);
			}
			fis1.close();
			fos1.close();
			end = System.currentTimeMillis();
			System.out.println("使用FileInputStream的read()方法复制文件用时：" + (end - start) + "毫秒");

			// 使用FileInputStream的read(byte[] b)方法复制文件
			FileInputStream fis2 = new FileInputStream(source);
			FileOutputStream fos2 = new FileOutputStream(dest);
			start = System.currentTimeMillis();
			byte[] buffer = new byte[1024];
			int len2;
			while ((len2 = fis2.read(buffer)) != -1) {
				fos2.write(buffer, 0, len2);
			}
			fis2.close();
			fos2.close();
			end = System.currentTimeMillis();
			System.out.println("使用FileInputStream的read(byte[] b)方法复制文件用时：" + (end - start) + "毫秒");

			// 使用BufferedInputStream的read()方法复制文件
			FileInputStream fis3 = new FileInputStream(source);
			BufferedInputStream bis1 = new BufferedInputStream(fis3);
			FileOutputStream fos3 = new FileOutputStream(dest);
			start = System.currentTimeMillis();
			int len3;
			while ((len3 = bis1.read()) != -1) {
				fos3.write(len3);
			}
			bis1.close();
			fis3.close();
			fos3.close();
			end = System.currentTimeMillis();
			System.out.println("使用BufferedInputStream的read()方法复制文件用时：" + (end - start) + "毫秒");

			// 使用BufferedInputStream的read(byte[] b)方法复制文件
			FileInputStream fis4 = new FileInputStream(source);
			BufferedInputStream bis2 = new BufferedInputStream(fis4);
			FileOutputStream fos4 = new FileOutputStream(dest);
			start = System.currentTimeMillis();
			byte[] buffer2 = new byte[1024];
			int len4;
			while ((len4 = bis2.read(buffer2)) != -1) {
				fos4.write(buffer2, 0, len4);
			}
			bis2.close();
			fis4.close();
			fos4.close();
			end = System.currentTimeMillis();
			System.out.println("使用BufferedInputStream的read(byte[] b)方法复制文件用时：" + (end - start) + "毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}