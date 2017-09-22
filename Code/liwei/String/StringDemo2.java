package liwei.String;

public class StringDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         function();
	}
	/**
	 *   int length（）返回字符串的长度
	 *   包含多少个字符
	 * 
	 * */
   public static void function() {
	String string  = "efadfs@$FDGSDFG45654GFDGFD";
	int length = string.length();
	System.out.println("字符串长度"+length);
//	string = string.substring(2,10);
	System.out.println("从2号位置开始截取10个长度"+string);
	boolean b = string.startsWith("e");
	System.out.println("判断字符串是否以e开头"+b);
	int index = string.indexOf('@'); // 没有-1，有返回对应索引
	System.out.println("字符@出现的位置"+index);
	
	byte[] bytes = string.getBytes();
	for (int i = 0; i < bytes.length; i++) {
		System.out.println(bytes[i]);
		String s1 = new String(bytes, i, 1);
		System.out.println(s1);
	}
	
   }
}
