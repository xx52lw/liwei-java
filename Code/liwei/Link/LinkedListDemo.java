package liwei.Link;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 链表集合的特有功能
 *   链表的底层实现，查询慢，增删快
 *  子类的特有功能，不能多态调用
 * */
public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      function();
	}
   /**
    * addFirst(E) 添加到链表的开头
    * addLast(E)添加到链表的结尾
    * */ 
	public static void function() {
//		LinkedList<String> link = new LinkedList<String>();
//		link.add("1");
//		link.add("2");
//		link.add("3");
//		link.addLast("liwei");
//		String first = link.removeFirst();
//		String hehe = link.get(2);
//		String laString = link.getLast();
//		System.out.println(first);
//		System.out.println(hehe);
//		System.out.println(laString);
		
//		迭代器的并发修改异常 java.util.ConcurrentModificationException
//		 就是在遍历的过程中,使用了集合方法修改了集合的长度,不允许的
		List<String> lt = new ArrayList<String>();
		lt.add("abc");
		lt.add("123");
		System.out.println(lt.size());
		Iterator<String> it = lt.iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("abc")) {
//			lt.add("ABC");
			}
			System.out.println(s);
			
		}
		
	}
}