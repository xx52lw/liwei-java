package liwei;

public class arrayMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] array = {3,1,4,3,56,7,0};
        System.out.println("冒泡排序");
        bubbleSort(array);
//        selectSort(array);
        printArray(array);
	}
    /** 冒泡排序 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			// 小的后移
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j+1] < array[j]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	/** 选择排序 */
	public static void selectSort(int[] array) {
		for (int a = 0; a < array.length - 1; a++) {
			// 大的后移
			for (int i = a + 1; i < array.length; i++) {
				if (array[a] > array[i]) {
					int temp = array[a];
					array[a] = array[i];
					array[i] = temp;
				}
			}
		}
	}
	/** 打印数组 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}
