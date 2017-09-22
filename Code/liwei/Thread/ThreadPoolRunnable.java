package liwei.Thread;

public class ThreadPoolRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName() + " 线程提交任务");
	}

}
