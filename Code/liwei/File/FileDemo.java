package liwei.File;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       function1();
       function2();
      try {
		createFile();
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();
	   }
      createMkdirs();
//      deleteFile();
      getPathName();
      function3();
      searchFile();
      selectFile();
	}
	
	// File类的获取，文件获取过滤器 便利目录的时候，可以根据需求，只获取满足条件的文件
	// 遍历目录的方法 listFiles()重载形式
	public static void selectFile() {
		File file = new File("/Users/liwenting/Desktop/java文件");
		File[] files = file.listFiles(new MyFilter());
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
	
    public static void searchFile() {
		File file = new File("/Users/liwenting/Desktop/java文件");
		String[] strArr = file.list();
		System.out.println(strArr.length);
		for (String string : strArr) {
			System.out.println(string);
		}
		File[] fileArray = file.listFiles();
		for (File file2 : fileArray) {
			System.out.println(file2);
		}
		File[] file2 = File.listRoots();
		for (File f : file2) {
			System.out.println(f);
		}
	}
	
	// file判断功能
	public static void function3() {
		File file = new File("/Users/liwenting/Desktop/java");
		boolean b = file.exists();
		if (b) {
			System.out.println("文件" + file.isDirectory());
		}
		System.out.println("=====" + b);
	}
	// 返回最后路径的名称
	public static void getPathName() {
		File file = new File("/Users/liwenting/Desktop/java.java");
		String name = file.getName();
		System.out.println(name);
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		System.out.println(file.getParentFile());
	}
	// 删除文件(慎用)
	public static void deleteFile() {
		File file = new File("/Users/liwenting/Desktop/java文件/ ");
		boolean b = file.delete();
		System.out.println(b);
	}
	// 创建文件夹
	public static void createMkdirs() {
		File file = new File("/Users/liwenting/Desktop/java文件/java.java");
		boolean b = file.mkdirs();
		System.out.println(b);
	}
	// 创建文件
	public static void createFile() throws IOException {
		File file = new File("/Users/liwenting/Desktop/java");
		Boolean boolean1 = file.createNewFile();
		System.out.println(boolean1);
	}
	
	public static void function2() {
		File file = new File("/Users/liwenting/");
		System.out.println(file);
//		File file2 = new File("/Users/liwenting/", "Desktop");
		File file2 = new File(file, "Desktop");
		System.out.println(file2);
		
	}
	
	public static void function1() {
		// 与系统相关的路径分隔符
				String separator = File.pathSeparator;
				System.out.println(separator);
				// 与系统相关的默认名称分隔符
				separator = File.separator;
				System.out.println(separator);
	}

}
