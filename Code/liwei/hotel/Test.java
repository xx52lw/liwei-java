package liwei.hotel;

public class Test {

	public static void main(String[] args) {
        // 创建1个经理，2个服务员，2个厨师
		JingLi j1 = new JingLi("小明", "董事会001", 1234);
		j1.work();
		
		FuWuYuan f1 = new FuWuYuan("翠花", "服务部01");
		f1.work();
		f1.services();
		
		FuWuYuan f2 = new FuWuYuan("酸菜", "服务部02");
		f2.work();
		f2.services();
		
		Chushi c1 = new Chushi("老干妈", "后厨001");
		c1.work();
		c1.services();
		Chushi c2 = new Chushi("老干爹", "后厨002");
		c2.work();
		c2.services();
		
	}

}
