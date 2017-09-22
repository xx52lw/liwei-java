package liwei;

import java.util.Scanner;

public class shop {

	private static Scanner scanner;

	public static void main(String[] args) {
		// 使用数组，保存商品信息
		// 品名，尺寸，价格，库存量，
		String[] brands = {"mackBookAir","Thinkpad"};
		double[] size = {13.3,15.6};
		double[] price = {9998.97,6789.56};
		int[] count = {0,0};
		while (true) {
			int choose = chooseFunction();
			switch (choose) {
			case 1:
				printStores(brands, size, price, count);
				// 调用查看库存清单方法
				break;
            case 2:
            	// 调用修改库存的方法
            	update(brands, count);
            	break;
            case 3:
                return;
			default:
				System.out.println("没有这个功能");
				break;
			}
		}
	}
	/** 修改库存数 */
	public static void update(String[] brands, int[] count) {
		for (int i = 0; i < brands.length; i++) {
			System.out.println("请输入"+brands[i]+"的库存数");
			int newCount = scanner.nextInt();
			count[i] = newCount;
		}
	}
	/** 遍历库存数据 */
	public static void printStores(String[] brand, double[] size, double[] price, int[] count) {
		System.out.println("-----------商场库存清单-----------");
		System.out.println("品牌型号 尺寸 价格 库存数");
		int totalCount = 0;
		int totalMoney = 0;
		for (int i = 0; i < brand.length; i++) {
			System.out.println(brand[i] +"  " + size[i] +"   "+ price[i] +"   "+count[i]);
			totalCount += count[i];
			totalMoney += count[i] * price[i];
			System.out.println("库存数："+totalCount);
			System.out.println("库存商品总价："+totalMoney);
		}
	}
    /** 自定义方法，实现用户的选择功能，功能的需要返回
     *  返回值，int
     *  参数 没有
     *  */	
	public static int chooseFunction() {
		System.out.println("---------库存管理--------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号");
		scanner = new Scanner(System.in);
		int shooseNumber = scanner.nextInt();
		return shooseNumber;
	}
}
