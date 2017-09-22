package liwei.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tickets implements Runnable {
      // 定义出售的票源
	private int ticket = 100;
	private Lock lock = new ReentrantLock();
	Object object = new Object();
	public void run() {
		//模拟卖票
				while(true){
					synchronized (object) {
						if (ticket > 0) {
							//模拟选坐的操作
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket--);
						}
					}
					
				}

//		//模拟卖票
//				while(true){
//					if (ticket > 0) {
//						//模拟选坐的操作
//						try {
//							Thread.sleep(1);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket--);
//					}
//				}

//		while (true) {
//			// 调用lock接口方法lock获取锁
//			lock.lock();
//			// 对票数判断，大于0，可以出售，变量--操作
//				if (ticket > 0) {
//					try {
//						Thread.sleep(5);
//						System.out.println(Thread.currentThread().getName()+"出售第"+ticket--);
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					finally {
//						lock.unlock();
//					}
//				}
//		}	
	}
	
}
