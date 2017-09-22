package liwei.Collect;
import java.util.ArrayList;

/**
 *  集合体系
 *     目标 集合本身是一个存储的容器
 *         必须使用集合存储对象
 *         遍历集合，取出对象
 *         集合自己的特性
 * */
public class ArrayListDemo {
    public static void main(String[] args) {
			// 集合ArrayList,存储int类型数
        	    // 集合本身不接受基本类型，自动装箱存储
        	ArrayList<Integer> arrayList = new ArrayList<Integer>();
        	arrayList.add(11);
        	arrayList.add(12);
        	arrayList.add(13);
        	for (int i = 0; i < arrayList.size(); i++) {
				System.out.println(arrayList.get(i));
		}
        	// 
    }
}
