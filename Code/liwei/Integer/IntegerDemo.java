package liwei.Integer;
/*
 *   Integer类，封装基本数据类型int，提高大量方法
 *   将字符串转成基本数据类型int 
 */
public class IntegerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       function();
	}
    /**
     *  integer类型中静态方法 pareseInt(String s)返回基本数据类型
     *  int 转成字符串 toString()
     * */
	public static void function() {
		int i = Integer.parseInt("12");
		System.out.println(i/2);
		
		String s1 = Integer.toString(i) + "li";
		System.out.println(s1);
	}
}
