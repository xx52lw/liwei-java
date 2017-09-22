package liwei.Thread;


public class NameThread extends Thread {

	public NameThread() {
		// TODO Auto-generated constructor stub
		super("小强");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(getName());
	}
	
}
