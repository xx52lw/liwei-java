package liwei.Thread;

public class SleepThread extends Thread {
     @Override
    	public void run() {
    		// TODO Auto-generated method stub
    		super.run();
    		for (int i = 0; i < 5; i++) {
		  try {
		      Thread.sleep(1000); 	
		  }
		  catch (Exception e) {
			// TODO: handle exception
		  }		
		  System.out.println(i);
		}
    	}
}
