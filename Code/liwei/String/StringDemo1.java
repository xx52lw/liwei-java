package liwei.String;
/**
 *   String类构造方法
 *   String类的构造方法，重载形式
 * */
public class StringDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        function_1();;
	}
	/**
	 * string(char[] value) 传递字符数组
	 * 将字符数组，转成字符串，字符数组的参数，不查询编码表
	 * 
	 * String(char[] value, int offset, int count) 传递字符数组
	 * 将字符数组的一部分转成字符串
	 * offset 数组开始索引
	 * count 个数
	 * */
	public static void function_1() {
		char[] ch = {'a','b','c','d','e','f'};
		// 调用String构造方法，传递字符串数组
		String string = new String(ch);
		System.out.println(string);
	}
   /**
    *   定义方法，string类的构造方法
    *   string（byte[] bytes）传递字节数组
    *   字节数组转成字符串
    *   通过使用平台的默认字符集解码指定的byte数组，构造一个新的string
    *   平台：机器操作系统
    *   默认字符集：操作系统中的默认编码，默认编码表GBK
    *   将字节数组中的每个字节，查询编码表的到的结果
    *   字节是负数，汉字的字节编码就是负数，默认编码表，一个汉字采用2个字节表示
    *   
    *   string（byte[] bytes, int offset, int length）传递字节数组
    *   字节数组的一部分转成字符串
    *   offset数组的起始索引
    *   length个数，转几个，不是结束的索引
    *   
    * */
	public static void function() {
		byte[] bytes = {97,98,99,100};
		String string = new String(bytes);
		System.out.println(string);
		
		byte[] bytest = {65,66,67,68,69};
		// 调用string构造方法，传递数组，传递2个int值
		String s1 = new String(bytest, 1, 3);
		System.out.println(s1);
	}
}
