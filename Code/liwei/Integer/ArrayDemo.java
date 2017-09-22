package liwei.Integer;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
	
//	     function();
		int[] arr = {23,67,46,75,45,97,76,123,122};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int[] newArray = test(arr);
		
		System.out.println(Arrays.toString(newArray));
	}
	
	public static int[] test(int[] arr) {
		// 对数组排序
		Arrays.sort(arr);
		// 将最后三个成绩存储到新的数组中
		int[] result = new int[3];
		System.arraycopy(arr, arr.length - 3, result, 0, 3);
		for (int i = 0; i < 3; i++) {
//			result[i] = arr[i];
		}
		return result;
	}
	

	public static void function() {
		int[] array = {5,1,4,2,34,2};
//		Arrays.sort(array); 	// 排序数组- 升序
		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i]);
		}
//		int index = Arrays.binarySearch(array, 10); // 不存在返回负数
//		System.out.println(index);
		
	 // 将数组转换成字符串
		String string = Arrays.toString(array);
		System.out.println(string);
		
	}
	
}
