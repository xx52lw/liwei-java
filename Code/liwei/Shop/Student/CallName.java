package liwei.Shop.Student;

import java.util.ArrayList;


/**
 *  随机点名器
 *    1.创建集合，将student对象存储到集合中
 *    2.浏览所有学生的信息
 *      将存储到集合的student对象遍历出来
 *    3.随机学生
 *      随机数，作为索引，到集合中去查找元素
 *  
 */

public class CallName {

	public static void main(String[] args) {
      ArrayList<Student> array = new ArrayList<Student>();
		addStudent(array);
        printStudent(array);
	}
	/** 展示学生信息 */
	public static void printStudent(ArrayList<Student> array) {
		for (int i = 0; i < array.size(); i++) {
			Student student = array.get(i);
			System.out.println(student.getName() + "   " + student.getAge());
		}
	}
   /** 自定义方法，存储student对象到集合中 */
	public static void addStudent(ArrayList<Student> array) {
		Student s1 = new Student();
		s1.setName("liwei");
		s1.setAge(26);
		Student s2 = new Student();
		s2.setName("zhangsan");
		s2.setAge(12);
		Student s3 = new Student();
		s3.setName("wanger");
		s3.setAge(28);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
	}
}
