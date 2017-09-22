package liwei.Thread;




public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//     function2();
//		function3();
//		function4();
//		function5();
//		function6();
		function7();
	}
	/**
	 * 开启输入线程和输出线程，实现赋值和打印值
	 * */
	public static void function7() {
		Resource resource = new Resource();
		Input input = new Input(resource);
		Output output = new Output(resource);
		
		Thread tin = new Thread(input);
		Thread tout = new Thread(output);
		
		tin.start();
		tout.start();
	}
	/**
	 * 多线程并发访问同一个资源
	 * 3个线程，对一个票资源出售
	 * */
	public static void function6() {
		// 创建runnable接口实现类对象
		Tickets tickets = new Tickets();
		// 创建3个thread类对象，传递runnable接口实现类
		Thread t0 = new Thread(tickets);
		Thread t1 = new Thread(tickets);
		Thread t2 = new Thread(tickets);
		Thread t3 = new Thread(tickets);
		
	t0.start();
	t1.start();
	t2.start();
	t3.start();
	
		
	}
	/**
	 * 使用匿名内部类，实现多线程程序
	 * 前提：集成或者接口实现
	 * new 父类或者接口（）{
	 *    重写抽象方法
	 * }
	 * */
	public static void function5() {
		// 继承方式 XXX extends thread {public viod run(){}}
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println("!!!!!!");
			}
		}.start();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("######");
			}
		};
		new Thread(runnable).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("@@@@");
			}
		}).start();
		
	}
	
	/**
	 * 实现接口方式的线程
	 *   创建thread类对象，构造方法中，传递ruannable接口实现类
	 *   调用thread类方法start
	 * */
	public static void function4() {
		SubRunnable sr = new SubRunnable();
	    	Thread thread  = new Thread(sr);
	    	thread.start();
	    	for (int i = 0; i < 50; i++) {
				System.out.println("main..."+i);
			}
	    	
	}
	
	
	public static void function3() throws Exception {
		Thread.sleep(500);
		new SleepThread().start();
	}

	/**
	 * 
	 * 每个线程，都有自己的名字
	 * 运行方法main线程，名字就是main
	 * 其他新建的线程默认是thread-0，thread-1
	 * 
	 * JVM开启主线程，运行方法main，主线程也是线程，是线程必然就是Thread类对象，
	 * 
	 * */
	public static void function2() {
		NameThread nt = new NameThread();
		nt.setName("旺财");
		nt.start();
		
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
	}
	
	public static void function1() {
		 SubThread st = new SubThread();
	      SubThread st1 = new SubThread();
	      st.start();
	      st1.start();
	      for (int i = 0; i < 50; i++) {
			System.out.println("main..."+i);
		  }
	}
	
}
