package liwei.Compter;

public class Computer {
     public void openComputer() {
	   System.out.println("笔记本开机");
     }
     public void closeComputer() {
		System.out.println("笔记本关机");
	 }
     public void useUSB(USB usb) {
		usb.open();
		usb.close();
	}
}
