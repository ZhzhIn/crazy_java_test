package chapter15;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[]args) throws IOException{
		File file = new File(".");
//		System.out.println(file.exists());//true
//		System.out.println(file.getName());
//		System.out.println(file.getParent());
//		System.out.println(file.getAbsoluteFile().getParent());
//		File tmpFile = File.createTempFile("aaa", ".txt",file);
//		tmpFile.deleteOnExit();
//		File newFile = new File(System.currentTimeMillis()+"");
//		System.out.println(newFile.exists());//false
//		newFile.createNewFile();
		String[]fileList = file.list();
		System.out.println("--the file and path is --");
		for(String fileName:fileList){
			System.out.println(fileName);
		}
		File []roots =File.listRoots();
		System.out.println("--the root list is --");
		for(File root:roots){
			System.out.println(root);
		}
	}
}
