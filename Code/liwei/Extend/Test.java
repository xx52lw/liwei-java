package liwei.Extend;

/** 
   测试员工案例
   创建最下面的子类的对象
  */

public class Test {

	public static void main(String[] args) {
	
	    JavaEE ee = new JavaEE();
	    ee.setName("张三");
	    ee.setID("研发部001");
	    Network network = new Network();
	    network.setName("李四");
	    network.setID("维护部007");
	    
	    ee.work();
	    network.work();
	}

}
