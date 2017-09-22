package liwei.Integer;

public class SystemDemo {

	public static void main(String[] args) {

       function();
	}
    /**
     * 获取当前系统毫秒值
     * static long currentTimeMillis()
     * */
	public static void function() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
 		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.exit(0); // 退出程序	
		System.out.println(System.getProperties());
	
	}
}
