package liwei.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import liwei.Integer.Person;

/** 
 * IO流对象，实现对象person序列化和反序列化
 * ObjectOutputStream写对象，实现序列化
 * ObjectInputStream读取对象，实现反序列化
 **/
public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
      writeObject();
      readObject();
	}
	public static void readObject() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("/Users/liwenting/Desktop/obj.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object obj = objectInputStream.readObject();
		System.out.println(obj);
		objectInputStream.close();
	}
   public static void writeObject() throws IOException {
	   // 创建字节流输出，封装文件
	   FileOutputStream fileOutputStream = new FileOutputStream("/Users/liwenting/Desktop/obj.txt");
	   // 穿件写出对象的序列化流对象，构造方法传递字节输出流
	   ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fileOutputStream);
	   Person person = new Person("liwei", 26);
	   objectOutputStream.writeObject(person);
	   objectOutputStream.close();
   }
}
