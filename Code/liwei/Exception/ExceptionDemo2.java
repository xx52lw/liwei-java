package liwei.Exception;
/** 
 *  继承后，在子类重写父类方法的时候，异常处理
 *  结论：
 *      父类的方法，如果抛出异常，子类重写后可以不抛出异常，也可以抛出异常，但是如果子类要抛出，异常的异常不能大于父类异常，大于是指继承关系
 *      父类的方法，没有异常抛出，子类重写后也不能抛出异常，如果子类要抛出异常，别无选择，只能try..catch
 *  
 * */
class Fu {
	public void function() {
	}
}
class Zi extends Fu {
	public void function() {
		try {
			method();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void method() throws Exception {
		throw new Exception("抛出异常");
	}
}
public class ExceptionDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Fu fu = new Zi();
      fu.function();
	}

}
