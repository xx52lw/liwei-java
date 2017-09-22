package liwei.Compter;

public class Test {

	public static void main(String[] args) {
	
		Computer computer = new Computer();
		computer.openComputer();
		Mouse mouse = new Mouse() {
		};
		computer.useUSB(mouse);
		Keyboard keyboard = new Keyboard() {
		};
		computer.useUSB(keyboard);
        computer.closeComputer();
	}

}
