package liwei;

import java.util.Random;

/*
 *  随机点名 
 * 
 */
public class callName {
  /*
   * 主函数
   */
  public static void main(String[] args) {
	String[] names = new String[8];  
	  addStudent(names);
	  printStudentName(names);
	  System.out.println("======================");
	  randomStudentName(names);
  }
  /** 添加方法 */
  public static void addStudent(String[] names) {
	    names[0] = "张三";
		names[1] = "李四";
		names[2] = "王五";
		names[3] = "李蕾";
		names[4] = "韩梅梅";
		names[5] = "小名";
		names[6] = "老王";
		names[7] = "小华";
  }
  /** 打印学生姓名 */
  public static void printStudentName(String[] names) {
	  for (int i = 0; i < names.length; i++) {
		System.out.println(names[i]);
	}
  }
  /** 随机一个学生 */
  public static void randomStudentName(String[] names) {
	Random random = new Random();
	int index = random.nextInt(names.length);
	System.out.println(names[index]);
}
  
}
