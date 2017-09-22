package liwei.Thread;

public class SubThread extends Thread{
//     @Override
    public void run() {
    	// TODO Auto-generated method stub
//    	super.run();
    	for (int i = 0; i < 50; i++) {
			System.out.println("run..."+i);
		}
    }
}
