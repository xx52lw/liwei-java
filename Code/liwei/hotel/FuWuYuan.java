package liwei.hotel;
/** 
 * 定义服务员类
 *    属于员工一种，具体额外服务功能
 *    集成employee，实现VIP接口
 *  */
public class FuWuYuan extends Employyee implements VIP{

	public FuWuYuan() {
		super();
	}
	public FuWuYuan(String name, String id) {
		super(name, id);
	}
	@Override
	public void services() {
		// TODO Auto-generated method stub
		System.out.println("服务员给顾客倒酒");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("服务员在上菜");
	}

}
