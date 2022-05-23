package savefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestSaveFile {
	
	public static void main(String[] args) {
//		FileDao dao = new FileDao();
//		File file = new File("E:\\Projects\\imags\\im.jpg");
//		try {
//			FileInputStream fin = new FileInputStream(file);
//			dao.saveFile(2, "chinku", "im.jpg", fin);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println("done");
//		
	
		FileDao dao = new FileDao();
		dao.getFile("E:\\Projects\\downloaded img\\one.jpg", 1);

		
	}
}
