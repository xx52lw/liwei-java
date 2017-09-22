package liwei.Doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DouDiZhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1.组合牌
		// 创建Map集合，键是编号，值是牌
		HashMap<Integer, String> pooker = new HashMap<Integer,String>();
		// 创建List集合，存储编号
		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
		// 定义出13个点数组
		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		// 定义4个花色
		String[] colors = {"♠","♥","♣","♦"};
		// 定义整数变量，作为键出现
		int index = 2;
		// 遍历数组，花色+点数的组合，存储到map集合
		for (String number : numbers) {
			for (String color : colors) {
				pooker.put(index, color+number);
				pookerNumber.add(index);
				index++;
			}
		}
		// 存储大小王
		pooker.put(0, "大王");
		pookerNumber.add(0);
		pooker.put(1, "小王");
		pookerNumber.add(1);
		// 洗牌
		Collections.shuffle(pookerNumber);
		// 发牌
		ArrayList<Integer> palyer1 = new ArrayList<Integer>();
		ArrayList<Integer> palyer2 = new ArrayList<Integer>();
		ArrayList<Integer> palyer3 = new ArrayList<Integer>();
		ArrayList<Integer> bottom = new ArrayList<Integer>();
		// 发牌采用的是集合索引%3
		for (int i = 0; i < pookerNumber.size(); i++) {
			// 先将底牌做好
			if (i < 3) {
				// 存储底牌
				bottom.add(pookerNumber.get(i));
			}
			else if (i % 3 == 0) {
				palyer1.add(pookerNumber.get(i));
			}
			else if (i % 3 == 1) {
				palyer2.add(pookerNumber.get(i));
			}
			else if (i % 3 == 2) {
				palyer3.add(pookerNumber.get(i));
			}
		}
		// 对玩家手中的编号排序
		Collections.sort(palyer1);
		Collections.sort(palyer2);
		Collections.sort(palyer3);
		
		look("玩家1", palyer1, pooker);
		look("玩家2", palyer2, pooker);
		look("玩家3", palyer3, pooker);
		look("底牌", bottom, pooker);
		
	}

	public static void look(String name,ArrayList<Integer> player,HashMap<Integer, String> pooker) {
		// 遍历
		System.out.println(name + " ");
		for (Integer key : player) {
			String value = pooker.get(key);
			System.out.println(value+" ");
		}
		System.out.println();
	}
	
}
