public class Engine {
	String description;
	int mpg, maxSpeed;
	
	Engine(String des, int MPG, int max) {
		if (des.length() == 0)
			description = "Generic Engine";
		else
			description = des;
		
		if (MPG < 0)
			mpg = 0;
		else
			mpg = MPG;
		
		if (max < 0)
			maxSpeed = 0;
		else
			maxSpeed = max;
	}
	
	public String getDescription() {
		return (description + " (MPG: " + mpg + ", Max Speed: " + maxSpeed + ")");
	}
	
	public int getMpg() {
		return mpg;
	}
	
	public int getTopSpeed() {
		return maxSpeed;
	}
}