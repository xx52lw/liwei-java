package liwei.File;

import java.awt.RenderingHints.Key;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/*
 *  集合对象Properties类,继承Hashtable,实现Map接口
 *  可以和IO对象结合使用,实现数据的持久存储
 */
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
function1();
	}

/** 
 * 使用properties集合，存储键值对
 *  setProperty等同与map接口中的put
 * @throws IOException 
 * 
 **/
	
public static void function1() throws IOException {
	Properties properties = new Properties();
	properties.setProperty("a", "1");
	properties.setProperty("b", "2");
	properties.setProperty("c", "3");
	
	System.out.println(properties);
	
	Set<String> set = properties.stringPropertyNames();
	for (String string : set) {
		System.out.println(string + "...." + properties.getProperty(string));
	}
	
	FileWriter fw = new FileWriter("/Users/liwenting/Desktop/pop.properties");
	properties.store(fw, "");;
	fw.close();
	
	FileReader frFileReader  = new FileReader("/Users/liwenting/Desktop/pop.properties");
	Properties newP = new Properties();
	newP.load(frFileReader);
	System.out.println(newP);
	
	
}
	
	
	
}
