package liwei.Extend;
/** 
 * 自定义研发员工类
 *   属于员工的一种，集成员工类
 *   抽象类develop给自己的员工
 */
public abstract class Develop extends Employee {
     // 重写他父类的父类抽象方法
	public void work() {
		System.out.println("JavaEE的工程师开发淘宝"+ super.getName()+".."+super.getID());
	}
}
