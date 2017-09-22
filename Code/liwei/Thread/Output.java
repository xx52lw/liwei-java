package liwei.Thread;

public class Output implements Runnable {
     private Resource r;
     public  Output(Resource r) {
		// TODO Auto-generated constructor stub
    	      this.r = r;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
        while (true) {
			synchronized (r) {
				// 判断是否标记
				if (r.flag == false) {
					try {
						r.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			System.out.println(r.name+"..."+r.sex);
			// 标记成false，唤醒对方线程
			r.flag = false;
			r.notify();
		}
	}

}
