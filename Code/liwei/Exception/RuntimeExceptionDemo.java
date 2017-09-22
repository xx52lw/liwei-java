package liwei.Exception;

import javax.management.RuntimeErrorException;

/**
 * 异常分为编译异常和运行时异常
 * 编译异常：调用了抛出异常的方法，不处理编译失败
 * 运行异常：抛出的异常时RuntimeException类，或者是他的子类
 * 
 * 运行异常的特点：
 *   方法内部抛出的异常时运行异常， new XXXException
 *   方法的声明上，不需要throws语句，调用者，不需要处理
 *   设计原因：
 *          运行异常，不能发生，但是如果发生了，程序人员停止程序修改代码（一旦发生，不要处理，请你修改源代码，运行异常一旦发生，后面的代码没有执行的意义）
 * 
 * */
public class RuntimeExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double d = getArea(0);
        System.out.println(d);
        System.out.println("=======");
	} 
	
	public static double getArea(double r) {
		if (r <= 0) {
			throw new RuntimeErrorException(null, "圆形不存在");
		}
	  return r*r*Math.PI;
	}
}
