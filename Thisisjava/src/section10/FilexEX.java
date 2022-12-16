package section10;

import java.io.File;

public class FilexEX {

	public static void main(String[] args) {
		File dir = new File("C:\\temp\\dir");
		File file1 = new File("C:\\temp/file1.txt");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		try {
			file1.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
