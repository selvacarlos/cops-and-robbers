import java.awt.Graphics;

public class Car extends Sprite{
	String description;
	protected int x, y; 
	GasTank gastank;
	Engine engine;
	
	Car(String des, int maxFuel, Engine object, String jpgName) {
		super(jpgName);
		if (des.length() == 0)
			description = "Generic Car";
		else
			description = des;
		
		if (object == null)
			engine = new Engine("",0,0);
		else 
			engine = object;
		
		gastank = new GasTank(maxFuel);
	}
	
	public String getDescription() {
		return (description + (" Engine: " + engine.getDescription() + "), fuel: " 
				+ gastank.getLevel() + "/" + gastank.getCapacity()) + ", location: ("
				+ getX() + "," + getY() + ")");
	}
	
	private double deepMath(double xx, double yy, double zz) {
		if(xx < 0 && yy <= 0)
			return Math.sin(Math.atan(xx/yy)) * zz * -1;
		else if (yy < 0 && xx >= 0)
			return Math.sin(Math.atan(xx/yy)) * zz * -1;
		else
			return Math.sin(Math.atan(xx/yy)) * zz;
	}
	
	public double getFuelLevel() {
		return gastank.getLevel();
	}
	
	public void updateImage(Graphics g) {
		super.updateImage(g);
	}
	
	public void fillUp() {
		gastank.setLevel(gastank.getCapacity());
	}
	
	public int getMaxSpeed() {
		return engine.getTopSpeed();
	}
	
	public double drive(double distance, double xRatio, double yRatio) {
		if (distance / engine.getMpg() > gastank.getLevel()) {
			double miles = gastank.getLevel() * engine.getMpg();
			
			x = getX() + (int)deepMath(xRatio, yRatio, miles);
			y = getY() + (int)deepMath(yRatio, xRatio, miles);
			
			setX(x);
			setY(y);
			
			gastank.setLevel(0);
			
			System.out.println("Ran out of gas after driving " + miles + "miles.");
			return miles;
		}
		else {
			x = getX() + (int)deepMath(xRatio, yRatio, distance);
			y = getY() + (int)deepMath(yRatio, xRatio, distance);
			
			setX(x);
			setY(y);
			
			double setlvl = (double)(distance)/(double)(engine.getMpg());
			gastank.setLevel(gastank.getLevel() - setlvl);
			return distance;
		}
	}
}