package liwei.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       function2();
		function3();
	}
	/**
	 * 使用多线程技术求和
	 * 两个线程，一个线程计算1+100，另一个计算1+200
	 * 
	 * */
	public static void function3() {
		ExecutorService eService  = Executors.newFixedThreadPool(2);
		Future<Integer> f1 = eService.submit(new GetSumCallable(100));
		Future<Integer> f2 = eService.submit(new GetSumCallable(200));
	    System.out.println("hahha.."+f1);
	    System.out.println(f2);
	    eService.shutdown();
	    
	}
	
	/**
	 * 实现线程程序的第三个方式，实现callable接口方式
	 * 实现步骤
	 *   工厂类 Excutors静态方法newFixedThreadPool方法，创建线程池对象
	 *   线程池对象ExecutorService接口实现类，调用方法submit提交线程任务
	 * */
	public static void function2() {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<String> future = es.submit(new ThreadPoolCallable());
		String string = null;
		try {
			string = future.get();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(string);
	}
	
	/**
	 * 使用工厂类 Executors中的静态方法创建线程对象，指定线程的个数
	 * 
	 * */
	public static void function1() {
		   // 创建线程池，并指定线程个数
				ExecutorService es = Executors.newFixedThreadPool(4);
				// 调用接口类对象es中的方法submit提交线程任务
				// 将runnable接口实现类对象，传递
				es.submit(new ThreadPoolRunnable());
				es.submit(new ThreadPoolRunnable());
				es.submit(new ThreadPoolRunnable());
				es.submit(new ThreadPoolRunnable());
				es.submit(new ThreadPoolRunnable());
	}
	
}
