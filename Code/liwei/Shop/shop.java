package liwei.Shop;
import java.util.ArrayList;
import java.util.Scanner;

import liwei.Shop.fruitltem;

/** 
 * 
 *    超市管理系统
 *    实现：
 *      1：商品数据的初始化
 *      2：用户的菜单选择
 *      3：根据选择执行不同的功能
 *        3.1：read   查看商品
 *        3.2：create 添加商品
 *        3.3：delete 删除商品
 *        3.4：update 修改商品
 * 
 *  */
public class shop {

	private static Scanner scanner;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 创建ArrayList集合，存储商品类型，存储数据类型fruitItem类型
		ArrayList<fruitltem> arrayList = new ArrayList<fruitltem>();
		// 调用商品初始化方法，传递集合
		init(arrayList);
		while (true) {
			// 调用菜单方法
			mainMenu();
			int choose = shooseFunction();
			switch (choose) {
			case 1:
				showFruitList(arrayList);
				break;
            case 2:
            	addFruit(arrayList);
            	break;
            case 3:
            	deleteFruit(arrayList);
            	break;
            case 4:
            	updateFruit(arrayList);
            	break;
			default:
				System.out.println("输入序号");
				break;
			}
		}
	}
	 /** 自定义方法，实现更新货物清单功能 */
		@SuppressWarnings("unused")
		public static void updateFruit(ArrayList<fruitltem> array) {
			System.out.println("选择的是删除功能");
			System.out.println("请输入商品的编号");
			int ID = scanner.nextInt();
			fruitltem updateItem = null;
			for (int i = 0; i < array.size(); i++) {
				fruitltem item = array.get(i);
				if (item.ID == ID) {
					System.out.println("请输入商品编号");
					 item.ID = scanner.nextInt();
					 System.out.println("请输入商品名字");
					 item.name =scanner.next();
					 System.out.println("请输入商品价格");
					 item.price = scanner.nextDouble();
					 updateItem = item;
					return;
				}
			}
			if (updateItem != null) {
				System.out.println("更新成功");
			} 
			else {
				System.out.println("更新失败");	
			}
		}
  /** 自定义方法，实现删除货物清单功能 */
	@SuppressWarnings("unused")
	public static void deleteFruit(ArrayList<fruitltem> array) {
		System.out.println("选择的是删除功能");
		System.out.println("请输入商品的编号");
		int ID = scanner.nextInt();
		fruitltem deleteItem = null;
		for (int i = 0; i < array.size(); i++) {
			fruitltem item = array.get(i);
			if (item.ID == ID) {
				deleteItem = item;
				return;
			}
		}
		if (deleteItem != null) {
			array.remove(deleteItem);
			System.out.println("删除成功");
		} 
		else {
			System.out.println("删除失败");	
		}
	}
  /** 自定义方法，实现添加货物功能 */
	public static void addFruit(ArrayList<fruitltem> array) {
		System.out.println("选择的是添加商品功能");
		System.out.println("请输入商品的编号");
		int ID = scanner.nextInt();
		System.out.println("请输入商品的名字");
		String name = scanner.next();
		System.out.println("请输入商品的价格");
		double price = scanner.nextDouble();
		
		fruitltem item = new fruitltem();
		item.ID = ID;
		item.name = name;
		item.price = price;
		array.add(item);
		System.out.println("添加商品成功");
	}
  /** 自定义方法，实现显示货物清单功能 */
	public static void showFruitList(ArrayList<fruitltem> array) {
		System.out.println();
		System.out.println("===========商品库存清单============");
		System.out.println("商品编号    商品名称  商家价格");
		for (int i = 0; i < array.size(); i++) {
			fruitltem item = array.get(i);
			System.out.println(item.ID + "   "+item.name+"   "+item.price);
		}
		
	}
  /** 自定义方法，实现接收用户的键盘输入 */
	public static int  shooseFunction() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
  /** 自定义菜单 */
	public static void mainMenu() {
		System.out.println();
		System.out.println("==============欢迎光临ItCast超市===============");
		System.out.println("1: 货物清单  2：添加货物 3：删除货物 4：修改货物 5：退出");
		System.out.println("请输入您呀操作的功能序号");
	}
  /** 自定义商品初始化方法 */
	public static void init(ArrayList<fruitltem> array) {
		// 穿件多个fruitItem类型，并且属性赋值
		fruitltem f1 = new fruitltem();
		f1.ID = 123;
		f1.name = "核桃";
		f1.price = 12.3;
		fruitltem f2 = new fruitltem();
		f2.ID = 124;
		f2.name = "月饼";
		f2.price = 9.5;
		fruitltem f3 = new fruitltem();
		f3.ID = 125;
		f3.name = "哈密瓜";
		f3.price = 15.0;
		 
		array.add(f1);
		array.add(f2);
		array.add(f3);
	}
}
