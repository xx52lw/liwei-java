package liwei.Exception;
/**
 * 异常处理方式
 * try..catch..finally
 * 格式：
 *   try{
 *      被检查的代码
 *      可能出现异常的代码
 *   }catch (异常类名 变量) {
 *   异常处理方式
 *   循环，判断，调用方法，变量
 *   }finally {
 *     必要执行代码
 *   }
 * */
public class ExceptionDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] array = null;
         try {
	        int i = getArray(array);
	        System.out.println(i);
         } 
         catch (NullPointerException e) {
	     // TODO: handle exception
        	 System.out.println("####"+e);
         }   
         catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
        	 System.out.println("!!!!"+e);
		}
         System.out.println("over");
	}
	
	@SuppressWarnings("unused")
	private static int getArray(int[] array) throws NullPointerException,ArrayIndexOutOfBoundsException{
	    // 对数组判断
		if (array == null) {
			// 手动抛出异常
			throw new NullPointerException("数组不存在");
		}
		// 对数组索引进行判断
		if (array.length < 3) {
			// 手动抛出异常，抛出数组索引越界异常
	       throw new ArrayIndexOutOfBoundsException("数组没有3索引");
		}
		return array[3] + 1;
	}

}
