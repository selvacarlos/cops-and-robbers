public class GasTank {
	int capacity;
	double lvl;
	
	GasTank(int tankCapacity) {
		lvl = 0;
		
		if (tankCapacity < 0)
			capacity = 0;
		else
			capacity = tankCapacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public double getLevel() {
		return lvl;
	}
	
	public void setLevel(double levelIn) {
		if (levelIn < 0)
			lvl = 0.00;
		else if (levelIn > capacity)
			lvl = (double)capacity;
		else
			lvl = (Math.round(levelIn));
	}
}