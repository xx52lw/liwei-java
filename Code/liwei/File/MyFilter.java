package liwei.File;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		/**
		 * pathname 接受到的也是文件的全路径
		 * 对路径进行判断，如果是Java文件，返回true，反之返回false
		 * */
		String name = pathname.getName();
		return name.endsWith(".java");
	}

}
