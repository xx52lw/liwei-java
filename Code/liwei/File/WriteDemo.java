package liwei.File;

import java.io.FileWriter;
import java.io.IOException;

/**
 *   write（int c）写入1个字符
 *   write (char[] c)写字符数组
 *   write (char[] c, int, int)字符数组一部分，开始索引，写几个
 *   write (string s)写入字符串
 *   
 *   字符输出流写数据的时候，必须要运行一个功能，刷新功能
 *   
 * */
public class WriteDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    FileWriter fWriter = new FileWriter("/Users/liwenting/Desktop/write.txt");
    // 写入一个字符
    fWriter.write(100);
    fWriter.flush();
    // 写入一个字符数组
    char[] c = {'a','b','c','e'};
    fWriter.write(c);
    fWriter.flush();
    // 写入数组一部分
    fWriter.write(c, 1, 2);
    fWriter.flush();
    // 写入字符串
    fWriter.write("\nhellow");
    fWriter.flush();
    
    // 关闭
    fWriter.close();
	}

}
