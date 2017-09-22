package liwei.Compter;

public abstract class Mouse implements USB{
      @Override
    public void open() {
    	// TODO Auto-generated method stub
    	System.out.println("开启鼠标");
    }
      @Override
    public void close() {
    	// TODO Auto-generated method stub
    	System.out.println("关闭鼠标");
    }
}
