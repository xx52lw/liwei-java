package liwei.Compter;

public abstract class Keyboard implements USB{
	   public void open() {
	    	// TODO Auto-generated method stub
	        System.out.println("键盘开启");	
	    }
	     public void close() {
	    	// TODO Auto-generated method stub
	    	System.out.println("键盘关闭");
	    }
}
