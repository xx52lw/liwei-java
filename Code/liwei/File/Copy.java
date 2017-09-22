package liwei.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.management.RuntimeErrorException;

public class Copy {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//function2();
		namFileOutputStreamDemoe();
 	}
	/** 
	 *  1：创建字节类对象，绑定数据
	 *  2：调用流对象的方法write写
	 *  3：close释放资源
	 *  流对象的结构方法，创建文件，如果文件存在直接覆盖
	 * @throws IOException 
	 * */
	public static void namFileOutputStreamDemoe() throws IOException {
		FileOutputStream fos = new FileOutputStream("/Users/liwenting/Desktop/a.txt");
		// 流对象的方法write写入数据
		fos.write(97);
		// 写字节数组
		byte[] bytes = {65,66,67,68};
		fos.write(bytes);
		// 写入字符串
		fos.write("\rhello".getBytes());
		// 关闭资源
		fos.close();
	}
	
	/**
	 *  字节流复制文件
	 *  采用数组缓冲提高效率
	 *  字节数组
	 * */
    @SuppressWarnings("resource")
	public static void function2() {
        long s = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
        	    // 建立两个流对象，绑定数据源和数据的目的
        	    fis = new FileInputStream("/Users/liwenting/Desktop/FileDemo.java");
        	    fos = new FileOutputStream("/Users/liwenting/Desktop/copy1.java");
        		// 定义字节流数组，缓冲		
        	    byte[] bytes = new byte[1024*10];
        	    // 读取数组，写入数组
        	    int len = 0;
        	    while ((len = fis.read(bytes)) != -1) {
					fos.write(bytes, 0, len);
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("文件复制失败");
			
		}
        finally {
        	try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				throw new RuntimeException("资源释放失败");
			}
		}
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
	
	
	
    public static void function1() {
    // 定义两个流的对象变量
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 建立两个流对象，绑定数据源和数据的目的
			fis = new FileInputStream("/Users/liwenting/Desktop/FileDemo.java");
			fos = new FileOutputStream("/Users/liwenting/Desktop/copy.java");
			// 字节输入流读取1个字节，输出流写入1个字节
			int len = 0;
			while ((len = fis.read()) != -1) {
				fos.write(len);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("文件复制失败");
		}
		finally {
			// TODO: handle finally clause
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				throw new RuntimeException("资源释放失败");
			}
		}
     }
    
    
    
    
    
}
