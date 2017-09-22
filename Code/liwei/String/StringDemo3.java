package liwei.String;

public class StringDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
split_1();
	}
    /** 
     * String类方法split对字符串进行分割
     * 12-25-36-98
     *  */
	public static void split_1() {
//		String string = "12-25-36-98";
//		String[] strArray = string.split("-");
//		String string = "12 25   36  98";
//		String[] strArray = string.split(" +"); // 空格分割
		String string = "12.25.36.98";
		String[] strArray = string.split("\\."); // 空格分割
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
	}
}
