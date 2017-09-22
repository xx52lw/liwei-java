package liwei.Doudizhu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map接口中的常用方法
 * 使用Map接口的实现类 HashMap
 * */
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       // 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		System.out.println(map);
		map.remove("b");
		Integer integer = map.get("b");
		System.out.println(integer);
		Set<String> set =map.keySet(); // 所有key
		Iterator<String> iterator = set.iterator(); // 放入迭代器
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			System.out.println("key："+ key + "----" + "value：" + value);
		}
		System.out.println("========================");
		for (String key : set) {
			Integer value = map.get(key);
			System.out.println("key："+ key + "----" + "value：" + value);
		}
		/*
		 *   Map集合获取方式
		 *   entrySet方法，键值对映射关系获取
		 *   实现步骤：
		 *   1：调用map集合方法entrySet()将集合中的映射关系对象，存储到set集合Set<Entry <K,V>>
		 *   2：迭代Set集合
		 *   3：获取出的Set集合的元素，是映射关系对象
		 *   4：通过映射关系对象方法getKey,getValue获取键值对
		 *   
		 * */
		System.out.println("==========Map.Entry==============");
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(1, "q");
		map2.put(2, "w");
		map2.put(3, "e");
		map2.put(4, "r");
		
		// 1.调用map集合方法entrySet()将集合中的映射关系对象，存储到Set集合
		Set<Map.Entry<Integer, String>> set2 = map2.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry<Integer, String> entry = iterator2.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key："+ key + "----" + "value：" + value);
			value = "liwei";
		}
		System.out.println("=======================");
		for (Map.Entry<Integer, String> entry : set2) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key："+ key + "----" + "value：" + value);
		}
	}

}
