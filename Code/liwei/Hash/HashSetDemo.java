package liwei.Hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import liwei.Integer.Person;

/**
 *  set接口，特点不重复元素，没有索引
 *  set接口实现类，HashSet(哈希表)
 *  特点：无序集合，存储和取出的顺序不同，没有索引，不存储重复元素
 *  
 *  hashSet集合的自身特点：
 *  底层数据结构，哈希表
 *  存储，取出比较快
 *  线程不安全，运行速度快
 *  
 * */
public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//      Set<String> set = new HashSet<String>();
//      set.add("cn");
//      set.add("java");
//      set.add("java");
//      Iterator<String> iterator = set.iterator();
//      while(iterator.hasNext()) {
//    	     System.out.println(iterator.next());
//      }
//      
//      System.out.println("===================");
//      for (String string : set) {
//		System.out.println(string);
//	}
		
		HashSet<Person>setPerson = new HashSet<Person>();
		setPerson.add(new Person("a", 11));
		setPerson.add(new Person("b", 12));
		System.out.println(setPerson.size());
      
      
	}

}
