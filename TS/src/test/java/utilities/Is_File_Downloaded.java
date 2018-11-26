package utilities;

import java.io.File;

public class Is_File_Downloaded {
	
	public static boolean delete_File_If_Present(String fileName) { // Example: filename.xlsx
		//String downloadPath = "C:\\Users\\Jeff15\\Downloads";
		String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources";
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}
	

}
