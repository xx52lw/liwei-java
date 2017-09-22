package liwei.Thread;
/**
 * 输入线程，对资源对象resource中成员变量赋值
 * 一次赋值张三，男
 * 下一次赋值 李四，女
 * */
public class Input implements Runnable {
    private Resource r;
    public Input(Resource r) {
		// TODO Auto-generated constructor stub
    	    this.r = r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
        int i = 0;
        while (true) {
			synchronized (r) {
				// 标记是true，等待
				if (r.flag) {
					try {
						r.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				if (i % 2 == 0) {
					r.name = "张三";
					r.sex = "男";
				}
				else {
					r.name = "lisi";
					r.sex = "nv";
				}
				// 将对方线程唤醒，标记改成true
				r.flag = true;
				r.notify();
			}
			i++;
		}
	}

}
