import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car {
	static Engine engine = new Engine("V6", 20, 200);
	private int Yrat, Xrat;
	private boolean captured = false;
	private boolean escaped = false;
	private static int escapeCount;
	private static int captureCount;
	Random random;
	
	public RobberCar() {
		super("RobberCar", 5000, engine, "red-car.jpg");
		fillUp();
		
		random = new Random();
		Xrat = random.nextInt() - 5;
		Yrat = random.nextInt() - 5;
	}
	
	public boolean isCaptured() {
		return captured;
	}
	
	public boolean isEscaped() {
		return escaped;
	}
	
	public static int getEscaped() {
		return escapeCount;
	}
	
	public static int getCaptured() {
		return captureCount;
	}
	
	public static void resetStats() {
		escapeCount = 0;
		captureCount = 0;
	}
	
	public void updateState() {
		if (!isCaptured()) {
			super.drive(4, Yrat, Xrat);
		}
		
		if (super.getX() > x - 100 || super.getX() < 0 || super.getY() > y - 100 || super.getY() < 0) {
			escapeCount += 1;
			escaped = true;
		}
	}

	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
	
	public void captured() {
		super.setImage("jail.jpg");
		captured = true;
		captureCount += 1;
	}
}