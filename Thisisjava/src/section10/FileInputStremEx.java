package section10;

import java.io.FileInputStream;

public class FileInputStremEx {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/file1.txt");
			int data;
			while ((data = fis.read()) != -1) {
				System.out.println(data);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
