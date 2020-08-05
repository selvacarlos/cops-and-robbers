import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car {
	static Engine engine = new Engine("V6", 30, 100);
	private static int Yrat, Xrat;
	Random random;
	
	public CopCar() {
		super("RobberCar", 5000, engine, "cop-car.jpg");
		fillUp();
		
		random = new Random();
		Xrat = random.nextInt() - 5;
		Yrat = random.nextInt() - 5;
	}
	
	public void updateState(int x, int y) {
		int Ty = Yrat;
		int Tx = Xrat;
		
		if (getX() > x) {
			setX(x);
			if (Xrat > 0) {
				Tx = -1 * Xrat;
			}
		}
		
		if (getX() < 0) {
			setX(0);
			if (Xrat < 0) {
				Tx = -1 * Xrat;
			}
		}
		
		if (getX() > y) {
			setX(y);
			if (Yrat > 0) {
				Ty = -1 * Yrat;
			}
		}
		
		if (getX() < 0) {
			setX(0);
			if (Yrat < 0) {
				Ty = -1 * Yrat;
			}
		}
		super.drive(2, Ty, Tx);
	}
	
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
}